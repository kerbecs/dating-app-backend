package app.user.service.application.facade;

import app.user.service.application.dto.UserConnexionDto;
import app.user.service.application.dto.UserProfileDto;
import app.user.service.application.entity.UserProfile;
import app.user.service.application.mapper.UserProfileMapper;
import app.user.service.ports.facade.UserConnexionsFacade;
import app.user.service.ports.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserConnexionFacadeImpl implements UserConnexionsFacade {
    private final UserProfileService userProfileService;
    private final UserProfileMapper  userProfileMapper;
    @Override
    public void addUserConnexion(UserConnexionDto userConnexionDto) {
        UserProfile userProfile = userProfileService.getUserProfileByUserId(userConnexionDto.getUserId());
        UserProfile connexionProfile = userProfileService.getUserProfileByUserId(userConnexionDto.getUserConnexionId());

        if(userProfile == null || connexionProfile == null) return;
        if(userProfile.getConnexions() == null) userProfile.setConnexions(new HashSet<>());
        if(connexionProfile.getConnexions() == null) connexionProfile.setConnexions(new HashSet<>());

        userProfile.getConnexions().add(userConnexionDto.getUserConnexionId());
        connexionProfile.getConnexions().add(userConnexionDto.getUserId());

        userProfileService.saveUserProfile(userProfile);
        userProfileService.saveUserProfile(connexionProfile);

    }

    @Override
    public List<UserProfileDto> getAllUserConnexions(Long userId) {
        UserProfile userProfile = userProfileService.getUserProfileByUserId(userId);
        if(userProfile == null || userProfile.getConnexions() == null) return new ArrayList<>();

        return userProfileService.getAllUsersProfiles(userProfile.getConnexions())
                .stream()
                .map(userProfileMapper::userProfileToUserProfileDto)
                .toList();
    }

    @Override
    public void removeUserConnexion(Long userId, Long userConnexionId) {
        UserProfile userProfile = userProfileService.getUserProfileByUserId(userId);
        if(userProfile == null || userProfile.getConnexions() == null) return;
        userProfile.getConnexions().remove(userConnexionId);

        userProfileService.saveUserProfile(userProfile);
    }
}
