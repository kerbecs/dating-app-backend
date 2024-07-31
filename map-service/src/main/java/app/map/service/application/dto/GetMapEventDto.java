package app.map.service.application.dto;

import app.map.service.application.helper.EventType;
import app.map.service.application.helper.Visibility;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GetMapEventDto {

    @NotNull
    private String x;

    @NotNull
    private String y;

    @NotNull
    private String userToken;

    @NotBlank
    private String description;

    @NotNull
    private Visibility visibilityId;

    @NotNull
    private EventType eventType;
}
