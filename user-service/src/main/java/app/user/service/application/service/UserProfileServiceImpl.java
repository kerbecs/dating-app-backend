package app.user.service.application.service;

import app.user.service.application.entity.UserProfile;
import app.user.service.application.repository.UserProfileRepository;
import app.user.service.ports.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService{
    private final UserProfileRepository userProfileRepository;

    @Override
    public UserProfile getUserProfileById(String id) {
        return userProfileRepository.findById(id).orElse(null);
    }

    @Override
    public UserProfile getUserProfileByUserId(Long userId) {
        return userProfileRepository.findUserProfileByUserId(userId);
    }

    @Override
    public void removeUserProfileById(String id) {
        userProfileRepository.deleteById(id);
    }

    @Override
    public UserProfile saveUserProfile(UserProfile userProfile) {
        System.out.println(userProfile);
        return userProfileRepository.save(userProfile);
    }

    @Override
    public List<UserProfile> getAllUsersProfile() {

        return userProfileRepository.findAll();
    }

    @Override
    public List<UserProfile> getAllUsersProfiles(Set<Long> usersId) {
        return userProfileRepository.findAllByUserIdIn(usersId);
    }

    @Override
    public void modifyUserOnlineStatus(long userId,boolean status) {
        UserProfile userProfile = userProfileRepository.findUserProfileByUserId(userId);
        if(userProfile == null) return;
        userProfile.setOnline(status);

        userProfileRepository.save(userProfile);

    }
}
