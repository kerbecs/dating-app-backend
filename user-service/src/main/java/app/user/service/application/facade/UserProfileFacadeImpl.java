package app.user.service.application.facade;

import app.user.service.application.dto.UserProfileDto;
import app.user.service.application.entity.UserProfile;
import app.user.service.application.mapper.UserProfileMapper;
import app.user.service.ports.facade.UserProfileFacade;
import app.user.service.ports.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProfileFacadeImpl implements UserProfileFacade {
    private final UserProfileService userProfileService;
    private final UserProfileMapper userProfileMapper;
    @Override
    public UserProfileDto getUserProfileById(String id) {
        UserProfile userProfile = userProfileService.getUserProfileById(id);

        if(userProfile == null) return null;

        return userProfileMapper.userProfileToUserProfileDto(userProfile);
    }

    @Override
    public UserProfileDto getUserProfileByUserId(Long id) {
        return userProfileMapper.userProfileToUserProfileDto(userProfileService.getUserProfileByUserId(id));
    }

    @Override
    public void removeUserProfileById(String id) {
        userProfileService.removeUserProfileById(id);
    }

    @Override
    public UserProfileDto saveUserProfile(UserProfileDto userProfileDto) {
        UserProfile userProfile = userProfileService.saveUserProfile(
                userProfileMapper.userProfileDtoToUserProfile(userProfileDto));

        if(userProfile == null) return null;

        return userProfileMapper.userProfileToUserProfileDto(userProfile);
    }

    @Override
    public List<UserProfileDto> getAllUsersProfile() {
        return userProfileService.getAllUsersProfile()
                .stream()
                .map(userProfileMapper::userProfileToUserProfileDto)
                .toList();
    }

    @Override
    public void modifyUserOnlineStatus(long userId, boolean status) {
        userProfileService.modifyUserOnlineStatus(userId, status);
    }
}
