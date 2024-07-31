package app.compatibility.service.application.helper.counter;

import app.compatibility.service.application.dto.UserProfileDto;

import java.time.LocalDateTime;

public class AgeCompatibilityCounter {
    private AgeCompatibilityCounter() {}
    public static double countCompatibilityByAge(UserProfileDto user1, UserProfileDto user2){
        return countCompatibilityByAge(countAge(user1), countAge(user2));
    }
    private static int countAge(UserProfileDto user){
        return LocalDateTime.now().getYear() - user.getBirthDate().getYear();
    }
    public static double countCompatibilityByAge(int age1, int age2){
        int maxAge = Math.max(age1, age2);
        int minAge = Math.min(age1, age2);
        double differenceIndex = (double) maxAge - minAge;
        double ageIndex = 1+minAge/100.0;

        double result = (1.0/differenceIndex)*ageIndex;
        if(result < 0) result = 0;
        else if(result > 1) result = 1;

        return result;
    }

}
