package app.notification.service.application.entity;

import app.notification.service.application.helper.UserMatchAction;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
public class Notification {
    private String id;
    private Long senderId;
    private Long receiverId;
    private UserMatchAction userMatchAction;
    private LocalDateTime time;
    private boolean read;
}
