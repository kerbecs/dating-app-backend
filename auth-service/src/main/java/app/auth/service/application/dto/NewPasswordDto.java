package app.auth.service.application.dto;

import lombok.Data;

@Data
public class NewPasswordDto {
    private String tokenId;
    private String newPassword;
}
