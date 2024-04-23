package app.chat.service.application.repository;

import app.chat.service.application.entity.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageRepository extends MongoRepository<Message, String> {
    List<Message> findAllByChatId(String chatId);
    Integer countAllByReceiverIdAndIsRead(long receiverId, boolean isRead);

    Message findFirstByChatIdOrderByTimeDesc(String chatId);
}
