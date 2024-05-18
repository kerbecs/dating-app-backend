package app.notification.service.adapter.controller;

import app.notification.service.adapter.feign.UserProfileClient;
import app.notification.service.application.dto.NotificationDto;
import app.notification.service.application.dto.UserProfileDto;
import app.notification.service.application.entity.Notification;
import app.notification.service.port.facade.NotificationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/notification")
public class NotificationController {
    private final SimpMessagingTemplate messagingTemplate;
    private final NotificationFacade notificationFacade;
    private final UserProfileClient userProfileClient;

    @PostMapping()
    public void sendNotification(@RequestBody NotificationDto notificationDto) {
        final UserProfileDto user = userProfileClient.getUserProfileByUserId(notificationDto.getSenderId());
        notificationDto = notificationFacade.saveNotification(notificationDto);
        notificationDto.setSenderFirstName(user.getFirstName());

        messagingTemplate.convertAndSendToUser(
                String.valueOf(notificationDto.getReceiverId()),
                "/queue",
                notificationDto);
    }
    @GetMapping("/{userId}")
    public List<NotificationDto> getAllUnreadNotificationByUserId(@PathVariable Long userId){
        return notificationFacade.getAllActiveNotificationByUserId(userId);
    }
    @PutMapping("/readNotification/{userId}")
    public void readAllNotification(@PathVariable Long userId){
        notificationFacade.readAllNotification(userId);
    }
}
