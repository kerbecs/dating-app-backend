package app.chat.service.application.dto;

import lombok.Data;

import java.util.List;

@Data
public class ChatRoomDto {
    private String chatRoomId;
    private List<Long> usersId;
}
