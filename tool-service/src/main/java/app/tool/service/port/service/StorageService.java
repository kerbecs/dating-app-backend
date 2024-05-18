package app.tool.service.port.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface StorageService {
    String upload(MultipartFile multipartFile);

    void delete(String file) throws IOException;
}
