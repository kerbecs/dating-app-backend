package app.user.service.facade;


import app.user.service.application.dto.UserProfileDto;
import app.user.service.application.entity.UserProfile;
import app.user.service.application.helper.Gender;
import app.user.service.application.mapper.UserProfileMapper;
import app.user.service.ports.facade.UserConnexionsFacade;
import app.user.service.ports.service.UserProfileService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
public class TestUserConnexionFacade {
    @MockBean
    private UserProfileService userProfileService;
    @MockBean
    private UserProfileMapper userProfileMapper;
    @Autowired
    private UserConnexionsFacade userConnexionFacade;
    private final UserProfile user1 = new UserProfile("AFVDFVFG48484", 10L, "Eduard", "Mititiuc", "MD", "Singera", Gender.MALE, "google.com/img1.png", Set.of(11L), LocalDateTime.now(), true);
    private final UserProfile user2 = new UserProfile("TGRGRTGRG8878", 11L, "John", "Bree", "USA", "Detroit", Gender.MALE, "google.com/img2.png", Set.of(10L), LocalDateTime.now(), true);
    private final UserProfileDto userDto2 = new UserProfileDto("TGRGRTGRG8878", 11L, "John", "Bree", "USA", "Detroit", Gender.MALE, LocalDateTime.now(), "google.com/img2.png", Set.of(10L), true);

    @Test
    public void testGetAllUsersConnexionsWhenUserProfileNull() {
        when(userProfileService.getUserProfileByUserId(10L))
                .thenReturn(null);
        assertEquals(userConnexionFacade.getAllUserConnexions(10L).size(), 0);
    }

    @Test
    public void testGetAllUsersConnexionsWhenUserHasNoConnexions() {
        user1.setConnexions(null);
        when(userProfileService.getUserProfileByUserId(10L))
                .thenReturn(user1);
        assertEquals(userConnexionFacade.getAllUserConnexions(10L).size(), 0);
    }

    @Test
    public void testGetAllUsersConnexions() {
        when(userProfileService.getUserProfileByUserId(10L))
                .thenReturn(user1);
        when(userProfileService.getAllUsersProfiles(user1.getConnexions()))
                .thenReturn(List.of(user2));
        when(userProfileMapper.userProfileToUserProfileDto(user2))
                .thenReturn(userDto2);

        assertEquals(userConnexionFacade.getAllUserConnexions(10L), List.of(userDto2));
    }

}
