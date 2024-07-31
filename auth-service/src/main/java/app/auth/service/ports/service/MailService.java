package app.auth.service.ports.service;

import app.auth.service.application.entity.MailToken;

import java.util.Optional;

public interface MailService {
    Optional<MailToken> getMailTokenById(String token);

    void deleteMailTokenById(String token);

    void saveMailToken(MailToken mailToken);
}
