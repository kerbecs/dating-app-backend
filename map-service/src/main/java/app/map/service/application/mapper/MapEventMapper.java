package app.map.service.application.mapper;

import app.map.service.application.dto.GetMapEventDto;
import app.map.service.application.dto.SendMapEventDto;
import app.map.service.application.entity.MapEvent;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapEventMapper {
    SendMapEventDto mapEventToSendMapEventDto(MapEvent mapEvent);
    MapEvent sendEventDtoToSendMapEvent(SendMapEventDto sendMapEventDto);
    MapEvent getMapEventDtoToMapEvent(GetMapEventDto getMapEventDto);
}
