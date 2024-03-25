package app.auth.service.ports.facade;

import java.util.UUID;

public interface MailFacade {
    boolean validateEmail(String token);
}
