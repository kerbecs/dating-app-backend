package app.user.service.ports.service;

import app.user.service.application.entity.UserProfile;

import java.util.List;
import java.util.Set;

public interface UserProfileService {
    UserProfile getUserProfileById(String id);
    UserProfile getUserProfileByUserId(Long id);
    void removeUserProfileById(String id);
    UserProfile saveUserProfile(UserProfile userProfile);
    List<UserProfile> getAllUsersProfile();
    List<UserProfile> getAllUsersProfiles(Set<Long> usersId);
    void modifyUserOnlineStatus(long userId,boolean status);
}
