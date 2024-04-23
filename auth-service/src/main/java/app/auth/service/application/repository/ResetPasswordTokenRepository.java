package app.auth.service.application.repository;

import app.auth.service.application.entity.ResetPasswordToken;
import app.auth.service.application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResetPasswordTokenRepository extends JpaRepository<ResetPasswordToken, String> {
}
