package app.chat.service.application.mapper;

import app.chat.service.application.dto.MessageDto;
import app.chat.service.application.entity.Message;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    Message messageDtoToMessage(MessageDto messageDto);
    MessageDto messageToMessageDto(Message message);
}
