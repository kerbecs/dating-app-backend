package app.chat.service.application.facade;

import app.chat.service.application.dto.MessageDto;
import app.chat.service.application.entity.ChatRoom;
import app.chat.service.application.entity.Message;
import app.chat.service.application.mapper.MessageMapper;
import app.chat.service.port.facade.MessageFacade;
import app.chat.service.port.service.ChatRoomService;
import app.chat.service.port.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MessageFacadeImpl implements MessageFacade {
    private final MessageService messageService;
    private final ChatRoomService chatRoomService;
    private final MessageMapper messageMapper;

    @Override
    public MessageDto saveMessage(MessageDto message) {
        return messageMapper
                .messageToMessageDto(
                        messageService.saveMessage(messageMapper.messageDtoToMessage(message))
                );
    }

    @Override
    public List<MessageDto> findAllMessagesByChatId(String chatId) {
        return messageService.findAllMessagesByChatId(chatId)
                .stream()
                .map(messageMapper::messageToMessageDto)
                .toList();
    }

    @Override
    public List<MessageDto> findAllMessagesByUsersId(List<Long> usersId) {
        final ChatRoom chatRoom = chatRoomService.findChatRoomByUsersId(usersId);
        if(chatRoom == null) return new ArrayList<>();

        return messageService.findAllMessagesByChatId(chatRoom.getChatRoomId())
                .stream()
                .map(messageMapper::messageToMessageDto)
                .toList();
    }

    @Override
    public void removeMessageById(String messageId) {
        messageService.removeMessageById(messageId);
    }

    @Override
    public int getUnreadUserMessages(long userId) {
        return messageService.getUnreadUserMessages(userId);
    }

    @Override
    public void setAllUsersMessagesAsRead(Long senderId, Long receiverId) {
        final ChatRoom chatRoom = chatRoomService.findChatRoomByUsersId(List.of(senderId, receiverId));
        if(chatRoom == null) return;

        List<Message> messages = messageService.findAllMessagesByChatId(chatRoom.getChatRoomId());

        messages = messages.stream()
                        .filter(message -> Objects.equals(message.getReceiverId(), receiverId))
                                .toList();

        messages.forEach(message -> message.setRead(true));

        messageService.saveAllMessages(messages);
    }

    @Override
    public MessageDto findLastMessage(long receiverId, long senderId) {
        ChatRoom chatRoom = chatRoomService.findChatRoomByUsersId(List.of(receiverId, senderId));
        if(chatRoom == null) return null;

        return messageMapper.messageToMessageDto(messageService.findLastMessage(chatRoom.getChatRoomId()));
    }
}
