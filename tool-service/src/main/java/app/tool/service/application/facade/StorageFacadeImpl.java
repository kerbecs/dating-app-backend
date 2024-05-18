package app.tool.service.application.facade;

import app.tool.service.port.facade.StorageFacade;
import app.tool.service.port.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class StorageFacadeImpl implements StorageFacade {
    private final StorageService storageService;
    @Override
    public String upload(MultipartFile multipartFile) {
        return storageService.upload(multipartFile);
    }

    @Override
    public void delete(String file) throws IOException {
        storageService.delete(file);
    }
}
