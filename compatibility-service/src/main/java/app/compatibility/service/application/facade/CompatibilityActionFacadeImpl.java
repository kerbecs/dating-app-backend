package app.compatibility.service.application.facade;

import app.compatibility.service.application.dto.CompatibilityActionDto;
import app.compatibility.service.application.helper.UserMatchAction;
import app.compatibility.service.application.mapper.CompatibilityActionMapper;
import app.compatibility.service.port.facade.CompatibilityActionFacade;
import app.compatibility.service.port.service.CompatibilityActionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompatibilityActionFacadeImpl implements CompatibilityActionFacade {
    private final CompatibilityActionService service;
    private final CompatibilityActionMapper mapper;

    @Override
    public List<CompatibilityActionDto> findAllBySenderIdAndReceiverId(Long senderId, Long receiverId) {
        return service.findAllBySenderIdAndReceiverId(senderId, receiverId)
                .stream()
                .map(mapper::compatibilityActionToCompatibilityActionDto)
                .toList();
    }

    @Override
    public Integer countAllByReceiverIdAndUserMatchAction(Long receiverId, UserMatchAction userMatchAction) {
        return service.countAllByReceiverIdAndUserMatchAction(receiverId, userMatchAction);
    }

    @Override
    public CompatibilityActionDto saveCompatibilityAction(CompatibilityActionDto compatibilityActionDto) {
        return mapper
                .compatibilityActionToCompatibilityActionDto(
                        service.saveCompatibilityAction(
                                mapper.compatibilityActionDtoToCompatibilityAction(
                                        compatibilityActionDto)));
    }
}
