package app.auth.service.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class UserDto {
    private Long id;

    private String userProfileId;

    private String email;

    private String password;

    private Boolean isActive;

    private LocalDateTime registrationDate;

    private List<LoginTokenDto> loginTokenList;

    public void removeToken(LoginTokenDto loginToken) {
        if (loginTokenList == null) loginTokenList = new ArrayList<>();

        loginTokenList.remove(loginToken);
    }

    public void addToken(LoginTokenDto loginToken) {
        if (loginTokenList == null) loginTokenList = new ArrayList<>();

        loginTokenList.add(loginToken);
    }
}
