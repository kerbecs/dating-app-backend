package app.chat.service.port.facade;

import app.chat.service.application.dto.MessageDto;

import java.util.List;

public interface MessageFacade {
    MessageDto saveMessage(MessageDto message);
    List<MessageDto> findAllMessagesByChatId(String chatId);
    List<MessageDto> findAllMessagesByUsersId(List<Long> usersId);
    void removeMessageById(String messageId);
    int getUnreadUserMessages(long userId);
    void setAllUsersMessagesAsRead(Long senderId, Long receiverId);
    MessageDto findLastMessage(long user1, long user2);
}
