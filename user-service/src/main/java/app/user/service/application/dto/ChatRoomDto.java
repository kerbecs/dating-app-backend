package app.user.service.application.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ChatRoomDto {
    private String chatRoomId;
    private List<Long> usersId;
}
