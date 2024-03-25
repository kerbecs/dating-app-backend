package app.auth.service.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UserLoginResponseDto {
    private boolean success;
    private String loginToken;
    private LocalDateTime loginTokenGenerationDate;
    private UserDataDto userDataDto;
}
