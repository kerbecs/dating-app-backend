package app.auth.service.application.facade;

import app.auth.service.adapters.client.MessageClient;
import app.auth.service.application.dto.MailMessageDto;
import app.auth.service.application.dto.NewPasswordDto;
import app.auth.service.application.dto.ResetPasswordTokenDto;
import app.auth.service.application.entity.ResetPasswordToken;
import app.auth.service.application.entity.User;
import app.auth.service.application.mapper.ResetPasswordTokenMapper;
import app.auth.service.ports.facade.ResetPasswordTokenFacade;
import app.auth.service.ports.service.ResetPasswordTokenService;
import app.auth.service.ports.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ResetPasswordTokenFacadeImpl implements ResetPasswordTokenFacade {
    private final ResetPasswordTokenService tokenService;
    private final UserService userService;
    private final MessageClient messageClient;

    @Override
    public boolean validateToken(String tokenId) {
        return tokenValid(tokenService.getTokenById(tokenId));
    }

    @Override
    public boolean changeUserPassword(NewPasswordDto newPasswordDto) {
        final ResetPasswordToken token = tokenService.getTokenById(newPasswordDto.getTokenId());
        if(!tokenValid(token)) return false;

        final User user = userService.getUserById(token.getUser().getId());

        if(user == null) return false;

        user.setPassword(newPasswordDto.getNewPassword());

        userService.saveUser(user);
        tokenService.deleteTokenById(token.getId());


        return true;
    }

    @Override
    public void generateResetPasswordToken(String email) {
        User user = userService.getUserByEmail(email);
        if(user == null) return;

        ResetPasswordToken resetPasswordToken = ResetPasswordToken.builder()
                .id(UUID.randomUUID().toString())
                .generationDate(LocalDateTime.now())
                .user(user)
                .build();

        tokenService.saveToken(resetPasswordToken);

        messageClient.sendMessage(new MailMessageDto("http://localhost:4200/reset/"+resetPasswordToken.getId(), user.getEmail(),"Reset password"));
    }

    private boolean tokenValid(ResetPasswordToken token){
        return token != null && token.getGenerationDate().isAfter(LocalDateTime.now().minusHours(1));
    }
}
