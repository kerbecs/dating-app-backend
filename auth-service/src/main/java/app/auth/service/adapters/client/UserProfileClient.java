package app.auth.service.adapters.client;

import app.auth.service.application.dto.UserProfileDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "user-service")
public interface UserProfileClient {
    @GetMapping("/user-profile/{userProfileId}")
    UserProfileDto getUserProfileById(@PathVariable String userProfileId);
    @DeleteMapping("/user-profile/{userProfileId}")
    void removeUserProfileById(@PathVariable String userProfileId);
    @PostMapping("/user-profile")
    UserProfileDto saveUserProfile(UserProfileDto userProfileDto);
}
