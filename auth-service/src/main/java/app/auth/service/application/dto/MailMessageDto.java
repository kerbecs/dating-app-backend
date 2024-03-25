package app.auth.service.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MailMessageDto {
    private String message;
    private String to;
    private String subject;
}
