package app.chat.service.adapter.controller;

import app.chat.service.application.dto.ChatRoomDto;
import app.chat.service.application.dto.MessageDto;
import app.chat.service.port.facade.ChatRoomFacade;
import app.chat.service.port.facade.MessageFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Controller
@CrossOrigin
@RequiredArgsConstructor
public class MessageControllerWebSocket {
    private final MessageFacade messageFacade;
    private final SimpMessagingTemplate messagingTemplate;
    private final ChatRoomFacade chatRoomFacade;

    @MessageMapping("/message")
    public void sendNewMessage(@Payload MessageDto messageDto) {
        ChatRoomDto chatRoom = chatRoomFacade.findChatRoomByUsersId(List.of(messageDto.getReceiverId(), messageDto.getSenderId()));

        messageDto.setChatId(chatRoom.getChatRoomId());
        messageDto.setTime(System.currentTimeMillis());
        messageDto.setRead(false);

        MessageDto savedMessage = messageFacade.saveMessage(messageDto);
        messagingTemplate.convertAndSendToUser(String.valueOf(messageDto.getReceiverId()), "/queue/message", savedMessage);
    }
}
