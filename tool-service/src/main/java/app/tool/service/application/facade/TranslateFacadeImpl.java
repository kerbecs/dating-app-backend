package app.tool.service.application.facade;

import app.tool.service.application.dto.TranslateMessageDto;
import app.tool.service.application.helper.Language;
import app.tool.service.port.facade.TranslateFacade;
import app.tool.service.port.service.TranslateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Service
@RequiredArgsConstructor
public class TranslateFacadeImpl implements TranslateFacade {
    private final TranslateService translateService;

    @Override
    public TranslateMessageDto translate(TranslateMessageDto messageDto) throws GeneralSecurityException, IOException {
        return translateService.translate(messageDto.getMessage(), messageDto.getLanguage());
    }

    @Override
    public Language[] getAllLanguages() {
        return translateService.getAllLanguages();
    }
}
