package app.map.service.ports.service;

import app.map.service.application.entity.MapEvent;

import java.util.List;

public interface MapEventService {
    List<MapEvent> getAllMapEvents();
    void saveMapEvent(MapEvent mapEventEntity);
}
