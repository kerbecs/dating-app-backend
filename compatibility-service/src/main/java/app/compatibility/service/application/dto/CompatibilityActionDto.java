package app.compatibility.service.application.dto;

import app.compatibility.service.application.helper.UserMatchAction;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CompatibilityActionDto {
    private String id;
    private Long senderId;
    private Long receiverId;
    private UserMatchAction userMatchAction;
    private LocalDateTime time;
}
