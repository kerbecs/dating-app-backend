package app.user.service.adapters.controller.client;

import app.user.service.application.dto.ChatRoomDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "chat-service")
public interface ChatRoomClient{
    @PostMapping("/chat-room")
    ChatRoomDto saveChatRoom(@RequestBody ChatRoomDto chatRoomDto);

}
