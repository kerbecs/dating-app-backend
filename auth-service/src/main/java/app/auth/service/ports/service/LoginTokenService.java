package app.auth.service.ports.service;

import app.auth.service.application.entity.LoginToken;
import app.auth.service.application.entity.User;

import java.util.List;
import java.util.Optional;

public interface LoginTokenService {
    List<LoginToken> getLoginTokensByUser(User user);

    Optional<LoginToken> getLoginTokenByTokenId(String tokenId);
    void saveToken(LoginToken loginToken);
    boolean removeTokenById(String tokenId);
    void removeTokensByUser(User user);


}
