package app.auth.service.application.facade;

import app.auth.service.application.dto.UserDataDto;
import app.auth.service.application.dto.UserLoginTokenDto;
import app.auth.service.application.entity.LoginToken;
import app.auth.service.ports.facade.LoginTokenFacade;
import app.auth.service.ports.service.LoginTokenService;
import app.auth.service.ports.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginTokenFacadeImpl implements LoginTokenFacade {
    private final LoginTokenService loginTokenService;
    @Override
    public UserDataDto validateToken(String token) {
        Optional<LoginToken> loginToken = loginTokenService.getLoginTokenByTokenId(token);
        return loginToken.map(value -> new UserDataDto(value.getUser().getId())).orElse(null);
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
