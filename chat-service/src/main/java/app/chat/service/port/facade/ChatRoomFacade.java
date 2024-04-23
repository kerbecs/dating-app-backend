package app.chat.service.port.facade;

import app.chat.service.application.dto.ChatRoomDto;
import app.chat.service.application.entity.ChatRoom;

import java.util.List;

public interface ChatRoomFacade {
    ChatRoomDto findChatRoomById(String id);
    List<ChatRoomDto> findAllChatRoomsByUserId(Long userId);
    ChatRoomDto findChatRoomByUsersId(List<Long> usersId);
    ChatRoomDto saveChatRoom(ChatRoomDto chatRoom);
}
