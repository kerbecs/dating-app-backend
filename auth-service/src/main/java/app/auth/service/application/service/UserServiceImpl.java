package app.auth.service.application.service;

import app.auth.service.application.entity.User;
import app.auth.service.application.repository.UserRepository;
import app.auth.service.ports.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    public void activateUserById(Long id) {
        userRepository.activateUser(id);
    }

    @Override
    public User getUserByUserProfileId(String profileId) {
        return userRepository.getUserByUserProfileId(profileId);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

}
