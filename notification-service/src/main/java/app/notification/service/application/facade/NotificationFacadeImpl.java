package app.notification.service.application.facade;

import app.notification.service.adapter.feign.UserProfileClient;
import app.notification.service.application.dto.UserProfileDto;
import app.notification.service.application.mapper.NotificationMapper;
import app.notification.service.application.dto.NotificationDto;
import app.notification.service.port.facade.NotificationFacade;
import app.notification.service.port.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationFacadeImpl implements NotificationFacade {
    private final NotificationService notificationService;
    private final NotificationMapper notificationMapper;
    private final UserProfileClient userProfileClient;
    @Override
    public NotificationDto saveNotification(NotificationDto notification) {
        return notificationMapper.notificationToNotificationDto(notificationService.saveNotification(notificationMapper.notificationDtoToNotification(notification)));
    }

    @Override
    public List<NotificationDto> getAllActiveNotificationByUserId(Long userId) {
        return notificationService.getAllActiveNotificationByUserId(userId)
                .stream()
                .map(notificationMapper::notificationToNotificationDto)
                .peek(notificationDto -> {
                    UserProfileDto user = userProfileClient.getUserProfileByUserId(notificationDto.getSenderId());
                    if(user != null) notificationDto.setSenderFirstName(user.getFirstName());
                })
                .toList();
    }
}
