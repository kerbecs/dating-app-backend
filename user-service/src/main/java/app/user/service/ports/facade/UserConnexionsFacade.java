package app.user.service.ports.facade;

import app.user.service.application.dto.UserConnexionDto;
import app.user.service.application.dto.UserProfileDto;

import java.util.List;

public interface UserConnexionsFacade {
    void addUserConnexion(UserConnexionDto userConnexionDto);
    List<UserProfileDto> getAllUserConnexions(Long userId);
    void removeUserConnexion(Long userId, Long userConnexionId);
}
