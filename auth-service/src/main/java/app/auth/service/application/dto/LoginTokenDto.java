package app.auth.service.application.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LoginTokenDto {
    private String id;
    private LocalDateTime generationDate;

}
