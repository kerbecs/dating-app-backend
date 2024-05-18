package app.auth.service.application.dto;

import lombok.Data;

@Data
public class ChangePasswordDto {
    private Long userId;
    private String newPassword;
}
