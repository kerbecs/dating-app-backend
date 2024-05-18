package app.user.service.application.facade;

import app.user.service.adapters.client.UserClient;
import app.user.service.adapters.client.FileClient;
import app.user.service.application.dto.UserPersonalDataDto;
import app.user.service.application.dto.UserProfileDto;
import app.user.service.application.entity.UserProfile;
import app.user.service.application.helper.Coords;
import app.user.service.application.helper.Language;
import app.user.service.application.helper.Preference;
import app.user.service.application.helper.UserSettings;
import app.user.service.application.mapper.UserProfileMapper;
import app.user.service.ports.facade.UserProfileFacade;
import app.user.service.ports.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProfileFacadeImpl implements UserProfileFacade {
    private final UserProfileService userProfileService;
    private final UserProfileMapper userProfileMapper;
    private final UserClient userClient;
    private final FileClient fileClient;
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

    @Override
    public void saveUserPersonalData(UserPersonalDataDto userPersonalDataDto, String loginToken) {
        Long userId = userClient.getUserIdByToken(loginToken);

        UserProfile userProfile = userProfileService.getUserProfileByUserId(userId);

        if(userProfile == null) return;

        userProfileService.saveUserProfile(userProfileMapper.userPersonalDataDtoToUserProfile(userProfile, userPersonalDataDto));
    }

    @Override
    public void saveUserPreference(List<Preference> preferences, String loginToken) {
        Long userId = userClient.getUserIdByToken(loginToken);

        UserProfile userProfile = userProfileService.getUserProfileByUserId(userId);

        if(userProfile == null) return;

        if(userProfile.getPreferenceList() == null) userProfile.setPreferenceList(new HashSet<>());

        userProfile.getPreferenceList().addAll(preferences);

        userProfileService.saveUserProfile(userProfile);
    }

    @Override
    public void removeUserPreference(Preference preference, String loginToken) {
        Long userId = userClient.getUserIdByToken(loginToken);

        UserProfile userProfile = userProfileService.getUserProfileByUserId(userId);

        if(userProfile == null) return;

        if(userProfile.getPreferenceList() == null) userProfile.setPreferenceList(new HashSet<>());

        userProfile.getPreferenceList().remove(preference);

        userProfileService.saveUserProfile(userProfile);
    }

    @Override
    public void updateUserCoords(Coords coords, String loginToken) {
        Long userId = userClient.getUserIdByToken(loginToken);

        UserProfile userProfile = userProfileService.getUserProfileByUserId(userId);

        if(userProfile == null) return;

        userProfile.setCoords(coords);

        userProfileService.saveUserProfile(userProfile);
    }

    @Override
    public void addNewPhoto(MultipartFile multipartFile, String loginToken) {
        Long userId = userClient.getUserIdByToken(loginToken);

        UserProfile userProfile = userProfileService.getUserProfileByUserId(userId);

        if(userProfile == null) return;

        String link = fileClient.upload(multipartFile);

        if(userProfile.getImages() == null) userProfile.setImages(new ArrayList<>());

        userProfile.getImages().add(link);

        userProfileService.saveUserProfile(userProfile);
    }

    @Override
    public void deletePhoto(String name, String loginToken) {
        Long userId = userClient.getUserIdByToken(loginToken);

        UserProfile userProfile = userProfileService.getUserProfileByUserId(userId);

        if(userProfile == null) return;

        userProfile.getImages().remove(userProfile.getImages().stream().filter(img -> img.contains(name)).findFirst().orElse(null));
        if(userProfile.getImgUrl().equals(name)) userProfile.setImgUrl(null);

        userProfileService.saveUserProfile(userProfile);

        fileClient.delete(name);
    }

    @Override
    public void modifyProfilePhoto(String photoId, String loginToken) {
        Long userId = userClient.getUserIdByToken(loginToken);

        UserProfile userProfile = userProfileService.getUserProfileByUserId(userId);

        if(userProfile == null) return;

        String photo = userProfile.getImages().stream().filter(link -> link.contains(photoId)).findFirst().orElse(null);

        if(photo == null) return;

        userProfile.setImgUrl(photo);

        userProfileService.saveUserProfile(userProfile);
    }

    @Override
    public void setUserLanguage(String language, String loginToken) {
        Long userId = userClient.getUserIdByToken(loginToken);

        UserProfile userProfile = userProfileService.getUserProfileByUserId(userId);

        if(userProfile == null) return;

        if(userProfile.getUserSettings() == null) userProfile.setUserSettings(new UserSettings());

        userProfile.getUserSettings().setLanguage(Language.valueOf(language));

        userProfileService.saveUserProfile(userProfile);
    }
}
