package app.map.service.application.facade;

import app.map.service.adapters.feign.UserClient;
import app.map.service.application.dto.GetMapEventDto;
import app.map.service.application.dto.SendMapEventDto;
import app.map.service.application.entity.MapEvent;
import app.map.service.application.mapper.MapEventMapper;
import app.map.service.ports.facade.MapEventFacade;
import app.map.service.ports.service.MapEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MapEventFacadeImpl implements MapEventFacade {
    private final MapEventService mapEventService;
    private final MapEventMapper mapEventMapper;
    private final UserClient userClient;
    @Override
    public List<SendMapEventDto> getAllMapEvents() {
        return mapEventService.getAllMapEvents()
                .stream()
                .map(mapEventMapper::mapEventToSendMapEventDto)
                .toList();
    }

    @Override
    public SendMapEventDto saveMapEvent(GetMapEventDto getMapEventDto) {
        Long clientId = userClient.getUserIdByToken(getMapEventDto.getUserToken());

        MapEvent mapEvent = mapEventMapper.getMapEventDtoToMapEvent(getMapEventDto);
        mapEvent.setCreationDate(LocalDateTime.now());
        mapEvent.setUserId(clientId);

        mapEventService.saveMapEvent(mapEvent);

        return mapEventMapper.mapEventToSendMapEventDto(mapEvent);
    }
}
