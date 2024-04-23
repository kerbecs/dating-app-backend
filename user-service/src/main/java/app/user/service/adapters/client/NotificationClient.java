package app.user.service.adapters.client;

import app.user.service.application.dto.NotificationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notification-service")
public interface NotificationClient {
    @PostMapping("/notification")
    void sendNotification(@RequestBody NotificationDto notificationDto);
}
