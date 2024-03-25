package app.map.service.adapters.controller;

import app.map.service.application.dto.GetMapEventDto;
import app.map.service.application.dto.SendMapEventDto;
import app.map.service.application.helper.EventType;
import app.map.service.application.helper.Visibility;
import app.map.service.ports.facade.MapEventFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/map")
@CrossOrigin
public class MapController {
    private final MapEventFacade mapEventFacade;

    @GetMapping("/events")
    public List<SendMapEventDto> getAllMapEvents() {
        System.out.println(mapEventFacade.getAllMapEvents());
        return mapEventFacade.getAllMapEvents();
    }
    @PostMapping("/event")
    public SendMapEventDto saveMapEvent(@RequestBody GetMapEventDto getMapEventDto){
        return mapEventFacade.saveMapEvent(getMapEventDto);
    }
    @GetMapping("/visibility")
    public Visibility[] getVisibility(){
        return Visibility.values();
    }
    @GetMapping("/eventType")
    public EventType[] getEventTypes(){
        return EventType.values();
    }
}
