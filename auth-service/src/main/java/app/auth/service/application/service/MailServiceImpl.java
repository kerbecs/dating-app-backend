package app.auth.service.application.service;

import app.auth.service.application.entity.MailToken;
import app.auth.service.application.repository.MailTokenRepository;
import app.auth.service.ports.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {
    private final MailTokenRepository mailTokenRepository;
    @Override
    public Optional<MailToken> getMailTokenById(String token) {
        return  mailTokenRepository.findById(token);
    }

    @Override
    public void deleteMailTokenById(String token) {
        mailTokenRepository.deleteById(token);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void saveMailToken(MailToken mailToken) {
        mailTokenRepository.save(mailToken);
    }
}
