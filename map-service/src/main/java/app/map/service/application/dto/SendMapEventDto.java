package app.map.service.application.dto;

import app.map.service.application.helper.EventType;
import app.map.service.application.helper.Visibility;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SendMapEventDto {
    private String id;

    @NotNull
    private String x;

    @NotNull
    private String y;

    @NotNull
    private Long userId;

    private String userFullName;

    private Long userToken;

    @NotNull
    private LocalDateTime creationDate;

    @NotBlank
    private String description;

    @NotNull
    private Visibility visibilityId;

    @NotNull
    private EventType eventType;
}
