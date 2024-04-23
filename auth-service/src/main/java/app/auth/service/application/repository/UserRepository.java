package app.auth.service.application.repository;

import app.auth.service.application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByEmail(String email);
    @Query("UPDATE User user SET user.isActive = true WHERE user.id = :userId")
    @Transactional
    @Modifying
    void activateUser(@Param("userId") Long userId);

    User getUserByUserProfileId(String profileId);
}
