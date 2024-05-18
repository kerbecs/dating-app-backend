package app.tool.service.port.service;

import app.tool.service.application.dto.TranslateMessageDto;
import app.tool.service.application.helper.Language;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public interface TranslateService {
    TranslateMessageDto translate(String message, Language language) throws GeneralSecurityException, IOException;
    Language[] getAllLanguages();
}
