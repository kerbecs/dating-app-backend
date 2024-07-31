package app.auth.service.adapters.client;

import app.auth.service.application.dto.MailMessageDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "message-service")
public interface MessageClient {
    @PostMapping("/email")
    boolean sendMessage(@RequestBody MailMessageDto mailMessageDto);
}
