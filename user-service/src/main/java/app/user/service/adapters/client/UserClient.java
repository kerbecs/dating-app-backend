package app.user.service.adapters.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "auth-service")
public interface UserClient {
    @PostMapping("/user/token/userId")
    long getUserIdByToken(@RequestHeader String loginToken);
}
