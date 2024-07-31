package app.auth.service.application.repository;

import app.auth.service.application.entity.MailToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailTokenRepository extends JpaRepository<MailToken, String> {

}
