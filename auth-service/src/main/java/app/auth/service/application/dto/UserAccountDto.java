package app.auth.service.application.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserAccountDto {
    private Long id;
    private String email;
    private Boolean isActive;
    private LocalDateTime registrationDate;
}
