package app.map.service.application.facade;

import app.map.service.adapters.feign.UserClient;
import app.map.service.adapters.feign.UserProfileClient;
import app.map.service.application.dto.GetMapEventDto;
import app.map.service.application.dto.SendMapEventDto;
import app.map.service.application.dto.UserProfileDto;
import app.map.service.application.entity.MapEvent;
import app.map.service.application.helper.Visibility;
import app.map.service.application.mapper.MapEventMapper;
import app.map.service.ports.facade.MapEventFacade;
import app.map.service.ports.service.MapEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MapEventFacadeImpl implements MapEventFacade {
    private final MapEventService mapEventService;
    private final MapEventMapper mapEventMapper;
    private final UserClient userClient;
    private final UserProfileClient userProfileClient;

    @Override
    public List<SendMapEventDto> getAllMapEvents(String loginToken) {
        UserProfileDto user = userProfileClient.getUserProfileByUserId(userClient.getUserIdByToken(loginToken));
        if (user == null) return new ArrayList<>();

        return mapEventService.getAllMapEvents()
                .stream()
                .map(mapEventMapper::mapEventToSendMapEventDto)
                .filter(event -> this.checkMapEvent(event, user))
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

    private boolean checkMapEvent(SendMapEventDto mapEven, UserProfileDto user) {
        if (mapEven.getVisibilityId().equals(Visibility.EVERYONE)) return true;
        return mapEven.getVisibilityId().equals(Visibility.FRIENDS) && user.getConnexions() != null && user.getConnexions().contains(mapEven.getUserId());
    }
}
