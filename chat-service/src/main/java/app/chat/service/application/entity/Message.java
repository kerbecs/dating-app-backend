package app.chat.service.application.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

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
}
