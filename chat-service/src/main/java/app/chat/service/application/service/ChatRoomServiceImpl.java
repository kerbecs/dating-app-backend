package app.chat.service.application.service;

import app.chat.service.application.entity.ChatRoom;
import app.chat.service.application.repository.ChatRoomRepository;
import app.chat.service.port.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatRoomServiceImpl implements ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;

    @Override
    public ChatRoom findChatRoomById(String id) {
        return chatRoomRepository.findById(id).orElse(null);
    }

    @Override
    public List<ChatRoom> findAllChatRoomsByUserId(Long userId) {
        return chatRoomRepository.findByUsersIdContains(userId);
    }

    @Override
    public ChatRoom findChatRoomByUsersId(List<Long> usersId) {
        return chatRoomRepository.findByUsersIdContainingAll(usersId);
    }

    @Override
    public ChatRoom saveChatRoom(ChatRoom chatRoom) {
        return chatRoomRepository.save(chatRoom);
    }
}
