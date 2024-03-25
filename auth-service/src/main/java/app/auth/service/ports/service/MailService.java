package app.auth.service.ports.service;

import app.auth.service.application.entity.MailToken;

import java.util.Optional;
import java.util.UUID;

public interface MailService {
    Optional<MailToken> getMailTokenById(String token);
    void deleteMailTokenById(String token);
    void saveMailToken(MailToken mailToken);
}
