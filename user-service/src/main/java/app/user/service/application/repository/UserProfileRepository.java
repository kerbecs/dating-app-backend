package app.user.service.application.repository;

import app.user.service.application.entity.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Set;

public interface UserProfileRepository extends MongoRepository<UserProfile, String> {
    UserProfile findUserProfileByUserId(Long userId);
    List<UserProfile> findAllByUserIdIn(Set<Long> usersId);
}
