package app.auth.service.ports.service;

import app.auth.service.application.entity.ResetPasswordToken;

public interface ResetPasswordTokenService {
    ResetPasswordToken getTokenById(String id);
    void deleteTokenById(String id);
    ResetPasswordToken saveToken(ResetPasswordToken resetPasswordToken);
}
