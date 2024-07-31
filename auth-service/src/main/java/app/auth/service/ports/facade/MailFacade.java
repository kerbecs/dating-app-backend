package app.auth.service.ports.facade;

public interface MailFacade {
    boolean validateEmail(String token);
}
