package app.auth.service.application.facade;

import app.auth.service.application.entity.MailToken;
import app.auth.service.application.entity.User;
import app.auth.service.ports.facade.MailFacade;
import app.auth.service.ports.service.MailService;
import app.auth.service.ports.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MailFacadeImpl implements MailFacade {
    private final MailService mailService;
    private final UserService userService;

    public boolean validateEmail(String token) {
        Optional<MailToken> mailToken = mailService.getMailTokenById(token);

        if (mailToken.isEmpty()) return false;

        User user = mailToken.get().getUser();

        userService.activateUserById(user.getId());
        mailService.deleteMailTokenById(token);

        return true;
    }
}
