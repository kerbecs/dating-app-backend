package app.chat.service.application.mapper;

import app.chat.service.application.dto.ChatRoomDto;
import app.chat.service.application.entity.ChatRoom;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChatRoomMapper {
    ChatRoom chatRoomDtoToChatRoom(ChatRoomDto chatRoomDto);
    ChatRoomDto chatRoomToChatRoomDto(ChatRoom chatRoom);
}
