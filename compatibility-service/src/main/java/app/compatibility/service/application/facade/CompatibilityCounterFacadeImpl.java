package app.compatibility.service.application.facade;

import app.compatibility.service.adapter.client.UserProfileClient;
import app.compatibility.service.application.dto.UserProfileDto;
import app.compatibility.service.application.helper.counter.*;
import app.compatibility.service.port.facade.CompatibilityCounterFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompatibilityCounterFacadeImpl implements CompatibilityCounterFacade {
    private final UserProfileClient userProfileClient;

    @Override
    public Double countCompatibilityRate(Long user1, Long user2) {
        UserProfileDto userProfileDto1 = userProfileClient.getUserProfileByUserId(user1);
        UserProfileDto userProfileDto2 = userProfileClient.getUserProfileByUserId(user2);

        if (userProfileDto1 == null || userProfileDto2 == null) return 0.0;

        double age = AgeCompatibilityCounter.countCompatibilityByAge(userProfileDto1, userProfileDto2);
        double education = EducationCompatibilityCounter.countCompatibilityByEducation(userProfileDto1, userProfileDto2);
        double sexualOrientation = SexualOrientationCompatibility.countCompatibilityBySexualOrientation(userProfileDto1, userProfileDto2);
        double race = RaceCompatibilityCounter.countCompatibilityByRace(userProfileDto1, userProfileDto2);
        double preference = PreferenceCounter.countCompatibilityByPreference(userProfileDto1, userProfileDto2);

        return ((age + education + sexualOrientation + race + preference) / 5) * 100;


    }

}
