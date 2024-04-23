package app.chat.service.application.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class ChatRoom {
    @Id
    private String chatRoomId;
    private List<Long> usersId;
}
