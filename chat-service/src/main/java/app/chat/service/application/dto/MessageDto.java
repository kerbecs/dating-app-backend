package app.chat.service.application.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageDto {
    private String messageId;
    private String chatId;
    private Long receiverId;
    private Long senderId;
    private String content;
    private Long time;
    private boolean isRead;
}
