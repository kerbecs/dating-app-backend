package app.auth.service.application.facade;

import app.auth.service.adapters.client.UserProfileClient;
import app.auth.service.application.dto.UserDataDto;
import app.auth.service.application.dto.UserProfileDto;
import app.auth.service.application.entity.LoginToken;
import app.auth.service.ports.facade.LoginTokenFacade;
import app.auth.service.ports.service.LoginTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginTokenFacadeImpl implements LoginTokenFacade {
    private final LoginTokenService loginTokenService;
    private final UserProfileClient userProfileClient;
    @Override
    public UserDataDto validateToken(String token) {
        Optional<LoginToken> loginToken = loginTokenService.getLoginTokenByTokenId(token);
        UserProfileDto userProfileDto = userProfileClient.getUserProfileById(loginToken.get().getUser().getUserProfileId());
        return loginToken.map(value -> new UserDataDto(value.getUser().getId(), userProfileDto)).orElse(null);
    }

    @Override
    public void removeToken(String token) {
        loginTokenService.removeTokenById(token);
    }

    @Override
    public Long getUserIdByToken(String token) {
        Optional<LoginToken> loginToken = loginTokenService.getLoginTokenByTokenId(token);
        if(loginToken.isEmpty()) return -1L;
        return loginToken.get().getUser().getId();
    }
}
