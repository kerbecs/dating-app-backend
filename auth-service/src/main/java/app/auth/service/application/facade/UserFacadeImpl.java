package app.auth.service.application.facade;

import app.auth.service.adapters.client.MessageClient;
import app.auth.service.adapters.client.UserProfileClient;
import app.auth.service.application.dto.*;
import app.auth.service.application.entity.LoginToken;
import app.auth.service.application.entity.MailToken;
import app.auth.service.application.entity.User;
import app.auth.service.application.mapper.LoginTokenMapper;
import app.auth.service.application.mapper.UserMapper;
import app.auth.service.application.mapper.UserProfileMapper;
import app.auth.service.ports.facade.UserFacade;
import app.auth.service.ports.service.LoginTokenService;
import app.auth.service.ports.service.MailService;
import app.auth.service.ports.service.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    private final UserProfileMapper userProfileMapper;

    private final MessageClient messageClient;
    private final UserProfileClient userProfileClient;

    @Override
    @Transactional
    public void saveUser(@Valid UserRegisterDto userRegisterDto) {
        UserProfileDto userProfileDtoToSave = userProfileMapper.userRegisterDtoToUserProfileDto(userRegisterDto);
        userProfileDtoToSave.setImgUrl("https://static-00.iconduck.com/assets.00/user-2-account-icon-2048x2046-oucjsuyg.png");

        UserProfileDto userProfileDto = userProfileClient.saveUserProfile(userProfileDtoToSave);

        User user = userMapper.userRegisterDtoToUser(userRegisterDto);
        user.setIsActive(false);
        user.setId(null);
        user.setRegistrationDate(LocalDateTime.now());
        user.setUserProfileId(userProfileDto.getId());

        MailToken mailToken = new MailToken();
        mailToken.setUser(user);
        mailToken.setGenerationDate(LocalDateTime.now());
        mailToken.setId(UUID.randomUUID().toString());

        userService.saveUser(user);

        userProfileDto.setUserId(user.getId());
        userProfileClient.saveUserProfile(userProfileDto);

        mailService.saveMailToken(mailToken);

        MailMessageDto mailMessageDto = new MailMessageDto("http://localhost:4200/validate-email/" + mailToken.getId(), user.getEmail(), "Test");

        messageClient.sendMessage(mailMessageDto);
    }

    @Override
    public User getUserByEmail(String email) {
        return userService.getUserByEmail(email);
    }

    @Override
    @Transactional
    public UserLoginResponseDto loginUser(UserLoginDto userLoginDto) {
        User user = userService.getUserByEmail(userLoginDto.getEmail());
        if (user == null) {
            return new UserLoginResponseDto(false, null, null, null);
        } else if (!user.getPassword().equals(userLoginDto.getPassword()) || !user.getIsActive()) {
            return new UserLoginResponseDto(false, null, null, null);
        }
        LoginToken loginToken = new LoginToken(UUID.randomUUID().toString(), user, LocalDateTime.now());
        loginTokenService.saveToken(loginToken);

        LoginTokenDto loginTokenDto = loginTokenMapper.loginTokenToLoginTokenDto(loginToken);

        UserProfileDto userProfileDto = userProfileClient.getUserProfileById(user.getUserProfileId());

        return new UserLoginResponseDto(true, loginTokenDto.getId(), loginTokenDto.getGenerationDate(), new UserDataDto(user.getId(), userProfileDto));
    }

    @Override
    public User getUserByUserProfileId(String profileId) {
        return userService.getUserByUserProfileId(profileId);
    }
}
