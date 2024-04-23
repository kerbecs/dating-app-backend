package app.auth.service.ports.facade;

import app.auth.service.application.dto.NewPasswordDto;
import app.auth.service.application.dto.ResetPasswordTokenDto;

public interface ResetPasswordTokenFacade {
    boolean validateToken(String tokenId);
    boolean changeUserPassword(NewPasswordDto newPasswordDto);
    void generateResetPasswordToken(String email);
}
