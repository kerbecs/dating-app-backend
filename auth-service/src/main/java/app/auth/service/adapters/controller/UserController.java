package app.auth.service.adapters.controller;

import app.auth.service.application.dto.*;
import app.auth.service.ports.facade.LoginTokenFacade;
import app.auth.service.ports.facade.MailFacade;
import app.auth.service.ports.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {
    private final UserFacade userFacade;
    private final MailFacade mailFacade;
    private final LoginTokenFacade loginTokenFacade;

    @PostMapping("/new-user")
    public boolean registerUser(@RequestBody UserRegisterDto userRegisterDto) {
        userFacade.saveUser(userRegisterDto);

        return true;
    }

    @PostMapping("/login")
    public UserLoginResponseDto loginUser(@RequestBody UserLoginDto userLoginDto) {
        return userFacade.loginUser(userLoginDto);
    }

    @GetMapping("/email/{email}")
    public boolean checkIfEmailIsAvailable(@PathVariable String email) {
        return userFacade.getUserByEmail(email) == null;
    }

    @GetMapping("/email/token/{token}")
    public boolean validateEmail(@PathVariable String token) {
        return mailFacade.validateEmail(token);
    }

    @PostMapping("/token")
    public UserDataDto validateToken(@RequestBody UserLoginTokenDto loginTokenDto) {
        return loginTokenFacade.validateToken(loginTokenDto.getToken());
    }

    @PostMapping("/token/userId")
    public long getUserIdByToken(@RequestBody UserLoginTokenDto loginTokenDto) {
        return loginTokenFacade.getUserIdByToken(loginTokenDto.getToken());
    }

    @PostMapping("/logout")
    void logout(@RequestBody UserLoginTokenDto loginTokenDto) {
        loginTokenFacade.removeToken(loginTokenDto.getToken());
    }
}
