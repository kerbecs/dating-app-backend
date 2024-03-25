package app.auth.service.application.repository;

import app.auth.service.application.entity.LoginToken;
import app.auth.service.application.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface LoginTokenRepository extends JpaRepository<LoginToken, String> {
    List<LoginToken> getLoginTokensByUser(User user);
    @Modifying
    @Transactional
    void removeLoginTokensByUser(User user);
}
