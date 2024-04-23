package app.compatibility.service.application.mapper;

import app.compatibility.service.application.dto.CompatibilityActionDto;
import app.compatibility.service.application.dto.NotificationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NotificationMapper {
    @Mapping(target = "id", ignore = true)
    NotificationDto compatibilityActionDtoToNotificationDto(CompatibilityActionDto compatibilityActionDto);
}
