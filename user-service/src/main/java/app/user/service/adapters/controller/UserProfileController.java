package app.user.service.adapters.controller;

import app.user.service.application.dto.UserPersonalDataDto;
import app.user.service.application.dto.UserProfileDto;
import app.user.service.application.dto.UserStatusDto;
import app.user.service.application.helper.Coords;
import app.user.service.application.helper.Preference;
import app.user.service.ports.facade.UserProfileFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/user-profile")
@RequiredArgsConstructor
@CrossOrigin
public class UserProfileController {
    private final UserProfileFacade userProfileFacade;

    @GetMapping("/{userProfileId}")
    UserProfileDto getUserProfileById(@PathVariable String userProfileId) {
        return userProfileFacade.getUserProfileById(userProfileId);
    }

    @GetMapping("/user/{userId}")
    public UserProfileDto getUserProfileByUserId(@PathVariable Long userId) {
        return userProfileFacade.getUserProfileByUserId(userId);
    }

    @DeleteMapping("/{userProfileId}")
    public void removeUserProfileById(@PathVariable String userProfileId) {
        userProfileFacade.removeUserProfileById(userProfileId);
    }

    @PostMapping
    public UserProfileDto saveUserProfile(@RequestBody UserProfileDto userProfileDto) {
        return userProfileFacade.saveUserProfile(userProfileDto);
    }

    @GetMapping
    public List<UserProfileDto> getAllUsersProfile() {
        return userProfileFacade.getAllUsersProfile();
    }

    @PutMapping("/user/online-status")
    public void modifyUserOnlineStatus(@RequestBody UserStatusDto userStatusDto) {
        this.userProfileFacade.modifyUserOnlineStatus(userStatusDto.getUserId(), userStatusDto.getIsOnline());

    }

    @PutMapping("/user-personal-data")
    public void modifyUserPersonalData(@RequestBody UserPersonalDataDto userPersonalDataDto, @RequestHeader("loginToken") String loginToken) {
        userProfileFacade.saveUserPersonalData(userPersonalDataDto, loginToken);
    }

    @PutMapping("/user-preference")
    public void modifyUserPreference(@RequestBody List<Preference> preferences, @RequestHeader("loginToken") String loginToken) {
        userProfileFacade.saveUserPreference(preferences, loginToken);
    }

    @DeleteMapping("/user-preference")
    public void deleteUserPreference(@RequestBody Preference preference, @RequestHeader("loginToken") String loginToken) {
        userProfileFacade.removeUserPreference(preference, loginToken);
    }

    @PostMapping("/coords")
    public void setUserCoords(@RequestBody Coords coords, @RequestHeader("loginToken") String loginToken) {
        userProfileFacade.updateUserCoords(coords, loginToken);
    }

    @PostMapping("/new-photo")
    public void addNewPhoto(@RequestPart("file") MultipartFile multipartFile, @RequestHeader("loginToken") String loginToken) {
        userProfileFacade.addNewPhoto(multipartFile, loginToken);
    }

    @DeleteMapping("/photo/{file}")
    public void deletePhoto(@PathVariable String file, @RequestHeader("loginToken") String loginToken) {
        userProfileFacade.deletePhoto(file, loginToken);
    }

    @PutMapping("/photo/{photo}")
    public void modifyProfilePhoto(@PathVariable String photo, @RequestHeader("loginToken") String loginToken) {
        userProfileFacade.modifyProfilePhoto(photo, loginToken);
    }

    @PutMapping("/language/{language}")
    public void setUserLanguage(@PathVariable String language, @RequestHeader("loginToken") String loginToken) {
        userProfileFacade.setUserLanguage(language, loginToken);
    }

}
