package app.auth.service.application.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class MailTokenDto {
    @NotNull
    @NotEmpty
    private UUID token;

    @NotNull
    private Long userId;
}
