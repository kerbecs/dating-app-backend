package app.tool.service.adapter.controller;

import app.tool.service.application.dto.TranslateMessageDto;
import app.tool.service.application.helper.Language;
import app.tool.service.port.facade.TranslateFacade;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.translate.Translate;
import com.google.api.services.translate.model.TranslationsListResponse;
import com.google.api.services.translate.model.TranslationsResource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;

@RestController
@RequestMapping("/translate")
@RequiredArgsConstructor
public class TranslateController {
    private final TranslateFacade translateFacade;
    @PostMapping("/message")
    public TranslateMessageDto translate(@RequestBody TranslateMessageDto messageDto) throws GeneralSecurityException, IOException {
        return translateFacade.translate(messageDto);
    }
    @GetMapping("/language")
    public Language[] getAllLanguages(){
        return translateFacade.getAllLanguages();
    }
}
