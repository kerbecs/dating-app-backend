package app.notification.service.port.service;

import app.notification.service.application.entity.Notification;

import java.util.List;

public interface NotificationService {
    Notification saveNotification(Notification notification);
    List<Notification> getAllActiveNotificationByUserId(Long userId);
}
