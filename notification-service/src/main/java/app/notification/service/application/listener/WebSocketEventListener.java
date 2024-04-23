package app.notification.service.application.listener;

import app.notification.service.adapter.feign.UserProfileClient;
import app.notification.service.application.dto.UserStatusDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.security.Principal;

@Component
@RequiredArgsConstructor
public class WebSocketEventListener {
    private final UserProfileClient userProfileClient;
    @EventListener
    public void onUserDisconnect(SessionDisconnectEvent event){
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());

        UserStatusDto userStatusDto = new UserStatusDto(Long.valueOf((String) accessor.getSessionAttributes().get("userId")),false);
        userProfileClient.modifyUserOnlineStatus(userStatusDto);

    }
    @EventListener
    public void onUserConnect(SessionConnectedEvent sessionConnectedEvent){
        MessageHeaderAccessor headerAccessor = MessageHeaderAccessor.getAccessor(sessionConnectedEvent.getMessage().getHeaders(), MessageHeaderAccessor.class);
        StompHeaderAccessor stompHeaderAccessor = MessageHeaderAccessor.getAccessor((Message<?>)headerAccessor.getHeader("simpConnectMessage"), StompHeaderAccessor.class) ;
        String userId = stompHeaderAccessor.getNativeHeader("userId").get(0);

        stompHeaderAccessor.getSessionAttributes().put("userId", userId);

        UserStatusDto userStatusDto = new UserStatusDto(Long.valueOf(userId),true);
       userProfileClient.modifyUserOnlineStatus(userStatusDto);

    }
}
