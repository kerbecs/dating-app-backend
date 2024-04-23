package app.user.service.adapters.controller;

import app.user.service.application.dto.UserProfileDto;
import app.user.service.application.dto.UserStatusDto;
import app.user.service.ports.facade.UserProfileFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user-profile")
@RequiredArgsConstructor
@CrossOrigin
public class UserProfileController {
    private final UserProfileFacade userProfileFacade;
    @GetMapping("/{userProfileId}")
    UserProfileDto getUserProfileById(@PathVariable String userProfileId){
        return userProfileFacade.getUserProfileById(userProfileId);
    }
    @GetMapping("/user/{userId}")
    public UserProfileDto getUserProfileByUserId(@PathVariable Long userId){
        return userProfileFacade.getUserProfileByUserId(userId);
    }
    @DeleteMapping("/{userProfileId}")
    public void removeUserProfileById(@PathVariable String userProfileId){
        userProfileFacade.removeUserProfileById(userProfileId);
    }
    @PostMapping
    public  UserProfileDto saveUserProfile(@RequestBody UserProfileDto userProfileDto){
        return userProfileFacade.saveUserProfile(userProfileDto);
    }
    @GetMapping
    public List<UserProfileDto> getAllUsersProfile(){
        return userProfileFacade.getAllUsersProfile();
    }
    @PutMapping("/user/online-status")
    public void modifyUserOnlineStatus(@RequestBody UserStatusDto userStatusDto){
        System.out.println(userStatusDto);
        this.userProfileFacade.modifyUserOnlineStatus(userStatusDto.getUserId(), userStatusDto.getIsOnline());

    }

}
