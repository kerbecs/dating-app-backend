package app.user.service.adapters.controller;

import app.user.service.adapters.client.NotificationClient;
import app.user.service.adapters.controller.client.ChatRoomClient;
import app.user.service.application.dto.ChatRoomDto;
import app.user.service.application.dto.NotificationDto;
import app.user.service.application.dto.UserConnexionDto;
import app.user.service.application.dto.UserProfileDto;
import app.user.service.application.helper.UserMatchAction;
import app.user.service.ports.facade.UserConnexionsFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/user-connexions")
@RequiredArgsConstructor
@CrossOrigin
public class UserConnexionsController {
    private final UserConnexionsFacade userConnexionsFacade;
    private final ChatRoomClient chatRoomClient;
    private final NotificationClient notificationClient;
    @PostMapping
    public void addConnexionForUser(@RequestBody UserConnexionDto userConnexionDto){
        this.chatRoomClient.saveChatRoom(ChatRoomDto.builder()
                .usersId(List.of(userConnexionDto.getUserId(), userConnexionDto.getUserConnexionId()))
                .build());

        userConnexionsFacade.addUserConnexion(userConnexionDto);
        notificationClient.sendNotification(NotificationDto.builder()
                .userMatchAction(UserMatchAction.ADD)
                .read(false)
                .senderId(userConnexionDto.getUserId())
                .receiverId(userConnexionDto.getUserConnexionId())
                .time(LocalDateTime.now())
                .build());
    }
    @GetMapping("{userId}")
    public List<UserProfileDto> getAllUserConnexions(@PathVariable Long userId){
        return userConnexionsFacade.getAllUserConnexions(userId);
    }
    @DeleteMapping("{userId}/{userConnexionId}")
    public void removeUserConnexion(@PathVariable Long userId, @PathVariable Long userConnexionId){
        this.userConnexionsFacade.removeUserConnexion(userId, userConnexionId);
    }

}
