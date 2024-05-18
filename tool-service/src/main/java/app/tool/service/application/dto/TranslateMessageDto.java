package app.tool.service.application.dto;

import app.tool.service.application.helper.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TranslateMessageDto {
    private String message;
    private Language language;
}
