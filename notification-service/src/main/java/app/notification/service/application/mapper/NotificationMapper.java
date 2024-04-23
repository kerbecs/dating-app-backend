package app.notification.service.application.mapper;

import app.notification.service.application.dto.NotificationDto;
import app.notification.service.application.entity.Notification;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationMapper {
    NotificationDto notificationToNotificationDto(Notification notification);
    Notification notificationDtoToNotification(NotificationDto notificationDto);
}
