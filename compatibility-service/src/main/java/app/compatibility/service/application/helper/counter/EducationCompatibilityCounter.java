package app.compatibility.service.application.helper.counter;

import app.compatibility.service.application.dto.UserProfileDto;
import app.compatibility.service.application.helper.Education;

import java.util.Set;

public class EducationCompatibilityCounter {
    public static double countCompatibilityByEducation(UserProfileDto user1, UserProfileDto user2) {
        Education education1 = getHighestEducation(user1.getEducationList());
        Education education2 = getHighestEducation(user2.getEducationList());

        if (education1 == null || education2 == null) return 0.25;
        if (education1.equals(Education.OTHER) || education2.equals(Education.OTHER)) return 0.5;

        return (double) Math.min(education1.ordinal() + 1, education2.ordinal() + 1) / Math.max(education1.ordinal() + 1, education2.ordinal() + 1);

    }

    private static Education getHighestEducation(Set<Education> educationList) {
        if (educationList == null || educationList.isEmpty()) return null;
        return educationList.stream()
                .reduce(((education1, education2) -> {
                    if (education1.equals(Education.OTHER)) return education2;
                    if (education2.equals(Education.OTHER)) return education1;
                    return education1.ordinal() > education2.ordinal() ? education1 : education2;
                }))
                .orElse(null);
    }
}
