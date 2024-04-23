package app.compatibility.service.application.mapper;

import app.compatibility.service.application.dto.CompatibilityActionDto;
import app.compatibility.service.application.entity.CompatibilityAction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompatibilityActionMapper {
    CompatibilityAction compatibilityActionDtoToCompatibilityAction(CompatibilityActionDto actionDto);
    CompatibilityActionDto compatibilityActionToCompatibilityActionDto(CompatibilityAction action);
}
