package app.tool.service.adapter.controller;

import app.tool.service.port.facade.StorageFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/file")
@CrossOrigin
public class FileController {
    private final StorageFacade storageFacade;
    @PostMapping
    public String upload(@RequestPart("file") MultipartFile multipartFile) {
        return storageFacade.upload(multipartFile);
    }
    @DeleteMapping("/{file}")
    public void delete(@PathVariable String file) throws IOException {
        storageFacade.delete(file);
    }
}
