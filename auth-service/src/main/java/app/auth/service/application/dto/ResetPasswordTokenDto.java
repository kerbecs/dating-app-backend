package app.auth.service.application.dto;

import app.auth.service.application.entity.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResetPasswordTokenDto {
    private String id;
    private LocalDateTime generationDate;
    private User user;
}
