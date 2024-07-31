package app.chat.service.application.entity;

import app.chat.service.application.helper.MessageType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Message {
    @Id
    private String messageId;
    private String chatId;
    private Long receiverId;
    private Long senderId;
    private String content;
    private Long time;
    private boolean isRead;
    private MessageType messageType;
}
