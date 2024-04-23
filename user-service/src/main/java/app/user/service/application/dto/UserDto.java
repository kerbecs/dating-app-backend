package app.user.service.application.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long userId;
    private UserProfileDto userProfileDto;
}
