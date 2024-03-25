package app.auth.service.application.facade;

import app.auth.service.application.dto.*;
import app.auth.service.application.entity.LoginToken;
import app.auth.service.application.entity.MailToken;
import app.auth.service.application.entity.User;
import app.auth.service.application.mapper.LoginTokenMapper;
import app.auth.service.application.mapper.UserMapper;
import app.auth.service.ports.facade.UserFacade;
import app.auth.service.ports.service.LoginTokenService;
import app.auth.service.ports.service.MailService;
import app.auth.service.ports.service.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserFacadeImpl implements UserFacade {
    private final UserService userService;
    private final MailService mailService;
    private final LoginTokenService loginTokenService;
    private final UserMapper userMapper;
    private final LoginTokenMapper loginTokenMapper;

    @Override
    @Transactional
    public void saveUser(@Valid UserRegisterDto userRegisterDto) {
        User user = userMapper.userRegisterDtoToUser(userRegisterDto);
        user.setIsActive(false);
        user.setId(null);
        user.setRegistrationDate(LocalDateTime.now());

        MailToken mailToken = new MailToken();
        mailToken.setUser(user);
        mailToken.setGenerationDate(LocalDateTime.now());
        mailToken.setId(UUID.randomUUID().toString());
        System.out.println(mailToken.getId());

        userService.saveUser(user);
        mailService.saveMailToken(mailToken);

        WebClient webClient = WebClient.create();
        MailMessageDto mailMessageDto = new MailMessageDto("http://localhost:8080/email/token/"+mailToken.getId(),user.getEmail(),"Test");

        webClient.post()
                .uri("http://localhost:8081/email")
                .body(BodyInserters.fromValue(mailMessageDto))
                .retrieve()
                .toBodilessEntity()
                .subscribe(System.out::println);
    }

    @Override
    public User getUserByEmail(String email) {
        return userService.getUserByEmail(email);
    }

    @Override
    @Transactional
    public UserLoginResponseDto loginUser(UserLoginDto userLoginDto) {
        User user = userService.getUserByEmail(userLoginDto.getEmail());
        if(user == null){
            return new UserLoginResponseDto(false, null, null, null);
        }
        else if(!user.getPassword().equals(userLoginDto.getPassword())){
            return new UserLoginResponseDto(false, null, null, null);
        }
        LoginToken loginToken = new LoginToken(UUID.randomUUID().toString(),user, LocalDateTime.now());
        loginTokenService.saveToken(loginToken);

        LoginTokenDto loginTokenDto = loginTokenMapper.loginTokenToLoginTokenDto(loginToken);

        return new UserLoginResponseDto(true, loginTokenDto.getId(), loginTokenDto.getGenerationDate(), new UserDataDto(user.getId()));
    }
}
