package app.auth.service.application.service;

import app.auth.service.application.entity.LoginToken;
import app.auth.service.application.entity.User;
import app.auth.service.application.repository.LoginTokenRepository;
import app.auth.service.ports.service.LoginTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginTokenServiceImpl implements LoginTokenService {
    private final LoginTokenRepository loginTokenRepository;
    @Override
    public List<LoginToken> getLoginTokensByUser(User user) {
        return loginTokenRepository.getLoginTokensByUser(user);
    }

    @Override
    public Optional<LoginToken> getLoginTokenByTokenId(String tokenId) {
        return loginTokenRepository.findById(tokenId);
    }

    @Override
    public void saveToken(LoginToken loginToken) {
        loginTokenRepository.save(loginToken);
    }

    @Override
    public boolean removeTokenById(String tokenId) {
        Optional<LoginToken> loginToken = loginTokenRepository.findById(tokenId);
        if(loginToken.isEmpty()) return false;

        loginTokenRepository.delete(loginToken.get());

        return true;
    }

    @Override
    public void removeTokensByUser(User user) {
        loginTokenRepository.removeLoginTokensByUser(user);
    }
}
