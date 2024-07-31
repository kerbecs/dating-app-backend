package app.user.service.ports.facade;

import app.user.service.application.dto.UserPersonalDataDto;
import app.user.service.application.dto.UserProfileDto;
import app.user.service.application.helper.Coords;
import app.user.service.application.helper.Preference;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserProfileFacade {
    UserProfileDto getUserProfileById(String id);

    UserProfileDto getUserProfileByUserId(Long id);

    void removeUserProfileById(String id);

    UserProfileDto saveUserProfile(UserProfileDto userProfile);

    List<UserProfileDto> getAllUsersProfile();

    void modifyUserOnlineStatus(long userId, boolean status);

    void saveUserPersonalData(UserPersonalDataDto userPersonalDataDto, String loginToken);

    void saveUserPreference(List<Preference> preferences, String loginToken);

    void removeUserPreference(Preference preference, String loginToken);

    void updateUserCoords(Coords coords, String loginToken);

    void addNewPhoto(MultipartFile multipartFile, String loginToken);

    void deletePhoto(String name, String loginToken);

    void modifyProfilePhoto(String link, String loginToken);

    void setUserLanguage(String language, String loginToken);
}
