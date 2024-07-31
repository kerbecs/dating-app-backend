package app.tool.service.port.facade;

import app.tool.service.application.dto.TranslateMessageDto;
import app.tool.service.application.helper.Language;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface TranslateFacade {
    TranslateMessageDto translate(TranslateMessageDto messageDto) throws GeneralSecurityException, IOException;
    Language[] getAllLanguages();
}
