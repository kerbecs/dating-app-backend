package app.notification.service.adapter.feign;


import app.notification.service.application.dto.UserProfileDto;
import app.notification.service.application.dto.UserStatusDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-service")
public interface UserProfileClient {
    @GetMapping("/user-profile/user/{userId}")
    UserProfileDto getUserProfileByUserId(@PathVariable Long userId);
    @PutMapping("/user-profile/user/online-status")
    void modifyUserOnlineStatus(@RequestBody UserStatusDto userStatusDto);
}
