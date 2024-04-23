package app.notification.service.application.service;

import app.notification.service.application.entity.Notification;
import app.notification.service.application.repository.NotificationRepository;
import app.notification.service.port.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository notificationRepository;
    @Override
    public Notification saveNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public List<Notification> getAllActiveNotificationByUserId(Long userId) {
        return notificationRepository.findAllByReceiverIdAndRead(userId, false);
    }
}
