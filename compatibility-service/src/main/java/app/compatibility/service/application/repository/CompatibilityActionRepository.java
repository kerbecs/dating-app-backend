package app.compatibility.service.application.repository;

import app.compatibility.service.application.entity.CompatibilityAction;
import app.compatibility.service.application.helper.UserMatchAction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CompatibilityActionRepository extends MongoRepository<CompatibilityAction, String> {
    List<CompatibilityAction> findAllBySenderIdAndReceiverId(Long senderId, Long receiverId);
    Integer countAllByReceiverIdAndUserMatchAction(Long receiverId, UserMatchAction userMatchAction);
}
