package app.auth.service.application.mapper;

import app.auth.service.application.dto.LoginTokenDto;
import app.auth.service.application.entity.LoginToken;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoginTokenMapper {
    LoginTokenDto loginTokenToLoginTokenDto(LoginToken loginToken);
}
