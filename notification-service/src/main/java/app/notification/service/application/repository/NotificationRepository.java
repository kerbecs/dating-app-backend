package app.notification.service.application.repository;

import app.notification.service.application.entity.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NotificationRepository extends MongoRepository<Notification, String> {
    List<Notification> findAllByReceiverIdAndRead(Long id, boolean read);
}
