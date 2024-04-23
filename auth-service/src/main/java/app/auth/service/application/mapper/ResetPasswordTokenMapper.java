package app.auth.service.application.mapper;

import app.auth.service.application.dto.ResetPasswordTokenDto;
import app.auth.service.application.entity.ResetPasswordToken;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResetPasswordTokenMapper {
    ResetPasswordTokenDto resetPasswordTokenToResetPasswordTokenDto(ResetPasswordToken resetPasswordToken);
    ResetPasswordToken resetPasswordTokenDtoToResetPasswordToken(ResetPasswordTokenDto resetPasswordTokenDto);

}
