package app.user.service.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserStatusDto {
    private Long userId;
    private Boolean isOnline;
}
