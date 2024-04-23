package app.user.service.ports.facade;

import app.user.service.application.dto.UserProfileDto;
import app.user.service.application.entity.UserProfile;

import java.util.List;

public interface UserProfileFacade {
    UserProfileDto getUserProfileById(String id);
    UserProfileDto getUserProfileByUserId(Long id);
    void removeUserProfileById(String id);
    UserProfileDto saveUserProfile(UserProfileDto userProfile);
    List<UserProfileDto> getAllUsersProfile();
    void modifyUserOnlineStatus(long userId,boolean status);
}
