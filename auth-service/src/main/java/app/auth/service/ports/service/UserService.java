package app.auth.service.ports.service;

import app.auth.service.application.entity.User;

public interface UserService {
    void saveUser(User user);
    User getUserById(Long userId);
    User getUserByEmail(String email);
    void activateUserById(Long id);
    User getUserByUserProfileId(String profileId);
    void updateUser(User user);
}
