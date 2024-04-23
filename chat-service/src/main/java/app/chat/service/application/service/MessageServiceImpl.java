package app.chat.service.application.service;

import app.chat.service.application.entity.Message;
import app.chat.service.application.repository.MessageRepository;
import app.chat.service.port.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;
    @Override
    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public List<Message> findAllMessagesByChatId(String chatId) {
        return messageRepository.findAllByChatId(chatId);
    }

    @Override
    public void removeMessageById(String messageId) {
        messageRepository.deleteById(messageId);
    }

    @Override
    public Integer getUnreadUserMessages(long userId) {
        return messageRepository.countAllByReceiverIdAndIsRead(userId, false);
    }

    @Override
    public void saveAllMessages(List<Message> messages) {
        messageRepository.saveAll(messages);
    }

    @Override
    public Message findLastMessage(String chatId) {
        return messageRepository.findFirstByChatIdOrderByTimeDesc(chatId);
    }

}
