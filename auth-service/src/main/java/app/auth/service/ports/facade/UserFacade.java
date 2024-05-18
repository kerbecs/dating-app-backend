package app.auth.service.ports.facade;

import app.auth.service.application.dto.*;
import app.auth.service.application.entity.User;

public interface UserFacade {
    void saveUser(UserRegisterDto userRegisterDto);
    User getUserByEmail(String email);
    UserLoginResponseDto loginUser(UserLoginDto userLoginDto);
    User getUserByUserProfileId(String profileId);
    UserAccountDto getUserAccount(Long userId);
    boolean changePassword(ChangePasswordDto changePasswordDto);
}
