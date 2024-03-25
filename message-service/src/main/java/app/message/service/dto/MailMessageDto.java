package app.message.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MailMessageDto {
    private final String message;
    private final String to;
    private final String subject;
}
