package app.chat.service.adapter.controller;

import app.chat.service.application.dto.MessageDto;
import app.chat.service.port.facade.MessageFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
@CrossOrigin
public class MessageController {
    private final MessageFacade messageFacade;

    @GetMapping("/{userId1}/{userId2}")
    public List<MessageDto> getAllUsersMessages(@PathVariable Long userId1, @PathVariable Long userId2){
        return messageFacade.findAllMessagesByUsersId(List.of(userId1, userId2));
    }
    @GetMapping("/unread-message/{userId}")
    public Integer getUnreadUserMessages(@PathVariable Long userId){
        return messageFacade.getUnreadUserMessages(userId);
    }
    @PutMapping("/read-messages/{senderId}/{receiverId}")
    public void setAllUsersMessagesAsRead(@PathVariable Long senderId, @PathVariable Long receiverId){
        messageFacade.setAllUsersMessagesAsRead(senderId, receiverId);
    }
    @GetMapping("/last-message/{receiverId}/{senderId}")
    public MessageDto getLastMessage(@PathVariable Long receiverId, @PathVariable Long senderId){
        return messageFacade.findLastMessage(receiverId, senderId);
    }

}
