package app.chat.service.application.dto;

import app.chat.service.application.helper.MessageType;
import lombok.Data;

@Data
public class MessageDto {
    private String messageId;
    private String chatId;
    private Long receiverId;
    private Long senderId;
    private String content;
    private Long time;
    private boolean isRead;
    private MessageType messageType;

}
