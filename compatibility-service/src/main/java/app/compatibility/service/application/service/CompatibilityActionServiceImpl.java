package app.compatibility.service.application.service;

import app.compatibility.service.application.entity.CompatibilityAction;
import app.compatibility.service.application.helper.UserMatchAction;
import app.compatibility.service.application.repository.CompatibilityActionRepository;
import app.compatibility.service.port.service.CompatibilityActionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompatibilityActionServiceImpl implements CompatibilityActionService {
    private final CompatibilityActionRepository repository;
    @Override
    public List<CompatibilityAction> findAllBySenderIdAndReceiverId(Long senderId, Long receiverId) {
        return repository.findAllBySenderIdAndReceiverId(senderId, receiverId);
    }

    @Override
    public Integer countAllByReceiverIdAndUserMatchAction(Long receiverId, UserMatchAction userMatchAction) {
        return repository.countAllByReceiverIdAndUserMatchAction(receiverId, userMatchAction);
    }

    @Override
    public CompatibilityAction saveCompatibilityAction(CompatibilityAction compatibilityAction) {
        return repository.save(compatibilityAction);
    }
}
