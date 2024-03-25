package app.map.service.ports.facade;

import app.map.service.application.dto.GetMapEventDto;
import app.map.service.application.dto.SendMapEventDto;

import java.util.List;

public interface MapEventFacade {
    List<SendMapEventDto> getAllMapEvents();
    SendMapEventDto saveMapEvent(GetMapEventDto getMapEventDto);
}
