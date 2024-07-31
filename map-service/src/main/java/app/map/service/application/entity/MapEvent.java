package app.map.service.application.entity;

import app.map.service.application.helper.EventType;
import app.map.service.application.helper.Visibility;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
public class MapEvent {
    @Id
    private String id;

    private String x;

    private String y;

    private Long userId;

    private LocalDateTime creationDate;

    private String description;

    private Visibility visibilityId;

    private EventType eventType;
}
