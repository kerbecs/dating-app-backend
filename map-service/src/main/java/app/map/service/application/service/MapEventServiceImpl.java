package app.map.service.application.service;

import app.map.service.application.entity.MapEvent;
import app.map.service.application.repository.MapEventRepository;
import app.map.service.ports.service.MapEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MapEventServiceImpl implements MapEventService {
    private final MapEventRepository mapEventRepository;
    @Override
    public List<MapEvent> getAllMapEvents() {
        return mapEventRepository.findAll();
    }

    @Override
    public void saveMapEvent(MapEvent mapEventEntity) {
        System.out.println(mapEventEntity);
        mapEventRepository.save(mapEventEntity);
    }
}
