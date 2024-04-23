package app.chat.service.application.facade;

import app.chat.service.application.dto.ChatRoomDto;
import app.chat.service.application.entity.ChatRoom;
import app.chat.service.application.mapper.ChatRoomMapper;
import app.chat.service.port.facade.ChatRoomFacade;
import app.chat.service.port.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatRoomFacadeImpl implements ChatRoomFacade {
    private final ChatRoomService chatRoomService;
    private final ChatRoomMapper chatRoomMapper;

    @Override
    public ChatRoomDto findChatRoomById(String id) {
        final ChatRoom chatRoom = chatRoomService.findChatRoomById(id);
        if(chatRoom == null) return null;
        return chatRoomMapper.chatRoomToChatRoomDto(chatRoom);
    }

    @Override
    public List<ChatRoomDto> findAllChatRoomsByUserId(Long userId) {
        return chatRoomService.findAllChatRoomsByUserId(userId)
                .stream()
                .map(chatRoomMapper::chatRoomToChatRoomDto)
                .toList();
    }

    @Override
    public ChatRoomDto findChatRoomByUsersId(List<Long> usersId) {
        final ChatRoom chatRoom = chatRoomService.findChatRoomByUsersId(usersId);
        if(chatRoom == null) return null;
        return chatRoomMapper.chatRoomToChatRoomDto(chatRoom);
    }

    @Override
    public ChatRoomDto saveChatRoom(ChatRoomDto chatRoomDto) {
        ChatRoom chatRoom = chatRoomService.findChatRoomByUsersId(List.copyOf(chatRoomDto.getUsersId()));
        if(chatRoom != null) return chatRoomMapper.chatRoomToChatRoomDto(chatRoom);

        return chatRoomMapper
                .chatRoomToChatRoomDto(
                        chatRoomService.saveChatRoom(chatRoomMapper.chatRoomDtoToChatRoom(chatRoomDto))
                );
    }
}
