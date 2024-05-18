package app.user.service.adapters.client;

import app.user.service.application.config.FileClientConfig;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "tool-service", configuration = FileClientConfig.class)
public interface FileClient {
    @PostMapping(value = "/file",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String upload(@RequestPart("file") MultipartFile multipartFile);
    @DeleteMapping("/file/{file}")
    void delete(@PathVariable String file);
}
