package app.notification.service.port.facade;

import app.notification.service.application.dto.NotificationDto;
import app.notification.service.application.entity.Notification;

import java.util.List;

public interface NotificationFacade {
    NotificationDto saveNotification(NotificationDto notification);
    List<NotificationDto> getAllActiveNotificationByUserId(Long userId);
}
