package app.auth.service.application.service;

import app.auth.service.application.entity.ResetPasswordToken;
import app.auth.service.application.repository.ResetPasswordTokenRepository;
import app.auth.service.ports.service.ResetPasswordTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResetPasswordTokenServiceImpl implements ResetPasswordTokenService {
    private final ResetPasswordTokenRepository tokenRepository;
    @Override
    public ResetPasswordToken getTokenById(String id) {
        return tokenRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteTokenById(String id) {
        tokenRepository.deleteById(id);
    }

    @Override
    public ResetPasswordToken saveToken(ResetPasswordToken resetPasswordToken) {
        return tokenRepository.save(resetPasswordToken);
    }
}
