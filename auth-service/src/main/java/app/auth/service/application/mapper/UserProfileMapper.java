package app.auth.service.application.mapper;

import app.auth.service.application.dto.UserProfileDto;
import app.auth.service.application.dto.UserRegisterDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    UserProfileDto userRegisterDtoToUserProfileDto(UserRegisterDto userRegisterDto);
}
