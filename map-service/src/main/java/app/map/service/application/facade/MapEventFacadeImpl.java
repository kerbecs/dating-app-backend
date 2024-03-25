package app.map.service.application.facade;

import app.map.service.application.dto.GetMapEventDto;
import app.map.service.application.dto.SendMapEventDto;
import app.map.service.application.dto.UserLoginTokenDto;
import app.map.service.application.entity.MapEvent;
import app.map.service.application.mapper.MapEventMapper;
import app.map.service.ports.facade.MapEventFacade;
import app.map.service.ports.service.MapEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MapEventFacadeImpl implements MapEventFacade {
    private final MapEventService mapEventService;
    private final MapEventMapper mapEventMapper;
    @Override
    public List<SendMapEventDto> getAllMapEvents() {
        return mapEventService.getAllMapEvents()
                .stream()
                .map(mapEventMapper::mapEventToSendMapEventDto)
                .toList();
    }

    @Override
    public SendMapEventDto saveMapEvent(GetMapEventDto getMapEventDto) {
        WebClient webClient = WebClient.create();

        Long clientId = webClient.post().uri("http://localhost:8080/user/token/userId").header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(new UserLoginTokenDto(getMapEventDto.getUserToken())), UserLoginTokenDto.class)
                .retrieve()
                .bodyToMono(Long.class)
                .block();

        MapEvent mapEvent = mapEventMapper.getMapEventDtoToMapEvent(getMapEventDto);
        mapEvent.setCreationDate(LocalDateTime.now());
        mapEvent.setUserId(clientId);

        mapEventService.saveMapEvent(mapEvent);

        return mapEventMapper.mapEventToSendMapEventDto(mapEvent);
    }
}
