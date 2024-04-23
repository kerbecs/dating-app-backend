package app.user.service.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserConnexionDto {
    private Long userId;
    private Long userConnexionId;
}
