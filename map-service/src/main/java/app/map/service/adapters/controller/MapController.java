package app.map.service.adapters.controller;

import app.map.service.adapters.feign.UserProfileClient;
import app.map.service.application.dto.GetMapEventDto;
import app.map.service.application.dto.SendMapEventDto;
import app.map.service.application.dto.UserProfileDto;
import app.map.service.application.helper.EventType;
import app.map.service.application.helper.Visibility;
import app.map.service.ports.facade.MapEventFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/map")
@CrossOrigin
public class MapController {
    private final MapEventFacade mapEventFacade;
    private final UserProfileClient userProfileClient;

    @GetMapping("/events")
    public List<SendMapEventDto> getAllMapEvents(@RequestHeader("loginToken") String loginToken) {
        List<SendMapEventDto> mapEvents = mapEventFacade.getAllMapEvents(loginToken);
        mapEvents.forEach(event -> {
            UserProfileDto userProfileDto = userProfileClient.getUserProfileByUserId(event.getUserId());
            if (userProfileDto == null) return;
            event.setUserFullName(userProfileDto.getFirstName() + " " + userProfileDto.getLastName());
        });
        return mapEvents;
    }

    @PostMapping("/event")
    public SendMapEventDto saveMapEvent(@RequestBody GetMapEventDto getMapEventDto) {
        return mapEventFacade.saveMapEvent(getMapEventDto);
    }

    @GetMapping("/visibility")
    public Visibility[] getVisibility() {
        return Visibility.values();
    }

    @GetMapping("/eventType")
    public EventType[] getEventTypes() {
        return EventType.values();
    }
}
