package app.chat.service.port.service;

import app.chat.service.application.entity.ChatRoom;

import java.util.List;

public interface ChatRoomService {
    ChatRoom findChatRoomById(String id);
    List<ChatRoom> findAllChatRoomsByUserId(Long userId);
    ChatRoom findChatRoomByUsersId(List<Long> usersId);
    ChatRoom saveChatRoom(ChatRoom chatRoom);
}
