package app.auth.service.ports.service;

import app.auth.service.application.entity.User;

public interface UserService {
    void saveUser(User user);
    User getUserByEmail(String email);
    void activateUserById(Long id);
}
