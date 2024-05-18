package app.tool.service.application.service;

import app.tool.service.application.dto.TranslateMessageDto;
import app.tool.service.application.helper.Language;
import app.tool.service.port.service.TranslateService;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.translate.Translate;
import com.google.api.services.translate.model.TranslationsListResponse;
import com.google.api.services.translate.model.TranslationsResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TranslateServiceImpl implements TranslateService {
    @Override
    public TranslateMessageDto translate(String message, Language language) throws GeneralSecurityException, IOException {
        Translate t = new Translate.Builder(
                GoogleNetHttpTransport.newTrustedTransport()
                , GsonFactory.getDefaultInstance(), null)
                .setApplicationName("Stackoverflow-Example")
                .build();
        Translate.Translations.List list = t.new Translations().list(
                Arrays.asList(message), language.toString());

        list.setKey("AIzaSyCzyHcPSmDfoDPZXAP_76N70Lg3Q_k4JhY");
        TranslationsListResponse response = list.execute();

        return new TranslateMessageDto(response.getTranslations().get(0).getTranslatedText(), language);
    }

    @Override
    public Language[] getAllLanguages() {
        return Language.values();
    }
}
