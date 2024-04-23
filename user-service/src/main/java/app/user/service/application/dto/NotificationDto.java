package app.user.service.application.dto;

import app.user.service.application.helper.UserMatchAction;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class NotificationDto {
    private String id;
    private Long senderId;
    private Long receiverId;
    private UserMatchAction userMatchAction;
    private LocalDateTime time;
    private String senderFirstName;
    private boolean read;
}
