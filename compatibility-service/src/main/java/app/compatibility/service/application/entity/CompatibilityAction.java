package app.compatibility.service.application.entity;

import app.compatibility.service.application.helper.UserMatchAction;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
public class CompatibilityAction {
    @Id
    private String id;
    private Long senderId;
    private Long receiverId;
    private UserMatchAction userMatchAction;
    private LocalDateTime time;
}
