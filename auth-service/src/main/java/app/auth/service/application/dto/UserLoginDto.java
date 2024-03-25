package app.auth.service.application.dto;

import lombok.Data;

@Data
public class UserLoginDto {
    private String email;
    private String password;
}
