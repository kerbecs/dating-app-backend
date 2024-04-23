package app.chat.service.application.repository;

import app.chat.service.application.entity.ChatRoom;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ChatRoomRepository extends MongoRepository<ChatRoom, String> {
    List<ChatRoom> findByUsersIdContains(Long userId);
    @Query("{ 'usersId': { $all: ?0 } }")
    ChatRoom findByUsersIdContainingAll(List<Long> usersId);
}
