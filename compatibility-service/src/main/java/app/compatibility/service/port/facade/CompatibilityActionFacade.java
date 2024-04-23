package app.compatibility.service.port.facade;

import app.compatibility.service.application.dto.CompatibilityActionDto;
import app.compatibility.service.application.helper.UserMatchAction;

import java.util.List;

public interface CompatibilityActionFacade {
    List<CompatibilityActionDto> findAllBySenderIdAndReceiverId(Long senderId, Long receiverId);

    Integer countAllByReceiverIdAndUserMatchAction(Long receiverId, UserMatchAction userMatchAction);

    CompatibilityActionDto saveCompatibilityAction(CompatibilityActionDto compatibilityAction);

}
