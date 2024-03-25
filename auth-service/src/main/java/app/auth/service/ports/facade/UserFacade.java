package app.auth.service.ports.facade;

import app.auth.service.application.dto.UserLoginDto;
import app.auth.service.application.dto.UserLoginResponseDto;
import app.auth.service.application.dto.UserRegisterDto;
import app.auth.service.application.entity.User;

public interface UserFacade {
    void saveUser(UserRegisterDto userRegisterDto);
    User getUserByEmail(String email);
    UserLoginResponseDto loginUser(UserLoginDto userLoginDto);
}
