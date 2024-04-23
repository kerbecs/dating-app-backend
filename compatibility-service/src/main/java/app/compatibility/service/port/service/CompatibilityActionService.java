package app.compatibility.service.port.service;

import app.compatibility.service.application.entity.CompatibilityAction;
import app.compatibility.service.application.helper.UserMatchAction;

import java.util.List;

public interface CompatibilityActionService {
    List<CompatibilityAction> findAllBySenderIdAndReceiverId(Long senderId, Long receiverId);
    Integer countAllByReceiverIdAndUserMatchAction(Long receiverId, UserMatchAction userMatchAction);
    CompatibilityAction saveCompatibilityAction(CompatibilityAction compatibilityAction);
}
