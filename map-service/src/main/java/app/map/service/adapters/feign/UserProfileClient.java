package app.map.service.adapters.feign;


import app.map.service.application.dto.UserProfileDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")
public interface UserProfileClient {
    @GetMapping("/user-profile/user/{userId}")
    UserProfileDto getUserProfileByUserId(@PathVariable Long userId);
}
