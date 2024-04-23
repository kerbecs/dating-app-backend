package app.auth.service.adapters.controller;

import app.auth.service.application.dto.*;
import app.auth.service.ports.facade.LoginTokenFacade;
import app.auth.service.ports.facade.MailFacade;
import app.auth.service.ports.facade.ResetPasswordTokenFacade;
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
    private final ResetPasswordTokenFacade resetPasswordTokenFacade;

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
    public UserDataDto validateLoginToken(@RequestHeader String loginToken) {
        System.out.println(loginToken);
        return loginTokenFacade.validateToken(loginToken);
    }

    @PostMapping("/token/userId")
    public long getUserIdByToken(@RequestHeader String loginToken) {
        return loginTokenFacade.getUserIdByToken(loginToken);
    }

    @PostMapping("/logout")
    void logout(@RequestHeader String loginToken) {
        loginTokenFacade.removeToken(loginToken);
    }
    @GetMapping("/profileId/{profileId}")
    Long getUserIdByProfileId(@PathVariable String profileId){
        return userFacade.getUserByUserProfileId(profileId).getId();
    }
    @PostMapping("/resetPassword")
    boolean changeUserPassword(@RequestBody NewPasswordDto newPasswordDto){
        return resetPasswordTokenFacade.changeUserPassword(newPasswordDto);
    }

    @PostMapping("/resetPassword/{token}")
    boolean validateResetPasswordToken(@PathVariable String token){
        return resetPasswordTokenFacade.validateToken(token);
    }
    @PostMapping("/resetPasswordToken/{email}")
    void createResetPasswordToken(@PathVariable String email){
        resetPasswordTokenFacade.generateResetPasswordToken(email);
    }

}
