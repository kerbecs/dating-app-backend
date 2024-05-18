package app.tool.service.port.facade;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface StorageFacade {
    String upload(MultipartFile multipartFile);

    void delete(String file) throws IOException;
}
