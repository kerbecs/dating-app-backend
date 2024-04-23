package app.compatibility.service.application.dto;

import app.compatibility.service.application.helper.UserMatchAction;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotificationDto {
    private String id;
    private Long senderId;
    private Long receiverId;
    private UserMatchAction userMatchAction;
    private LocalDateTime time;
    private boolean read;
}
