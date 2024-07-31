package app.chat.service.port.service;

import app.chat.service.application.entity.Message;

import java.util.List;

public interface MessageService {
    Message saveMessage(Message message);

    List<Message> findAllMessagesByChatId(String chatId);

    void removeMessageById(String messageId);

    Integer getUnreadUserMessages(long userId);

    void saveAllMessages(List<Message> messages);

    Message findLastMessage(String chatId);

}
