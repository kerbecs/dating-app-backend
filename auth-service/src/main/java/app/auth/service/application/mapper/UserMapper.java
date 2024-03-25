package app.auth.service.application.mapper;

import app.auth.service.application.dto.UserRegisterDto;
import app.auth.service.application.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "isActive", ignore = true)
    @Mapping(target = "registrationDate", ignore = true)
    @Mapping(target = "loginTokenList", ignore = true)
    User userRegisterDtoToUser(UserRegisterDto userRegisterDto);
}
