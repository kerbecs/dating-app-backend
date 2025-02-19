package app.auth.service.ports.facade;

import app.auth.service.application.dto.UserDataDto;

public interface LoginTokenFacade {
    UserDataDto validateToken(String token);
    void removeToken(String token);
    Long getUserIdByToken(String token);
}
