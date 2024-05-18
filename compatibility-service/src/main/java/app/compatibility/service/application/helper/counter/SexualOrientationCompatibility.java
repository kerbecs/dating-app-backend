package app.compatibility.service.application.helper.counter;

import app.compatibility.service.application.dto.UserProfileDto;
import app.compatibility.service.application.helper.Gender;
import app.compatibility.service.application.helper.SexualOrientation;

import static app.compatibility.service.application.helper.SexualOrientation.*;

public class SexualOrientationCompatibility {
    public static double countCompatibilityBySexualOrientation(UserProfileDto user1, UserProfileDto user2) {
        SexualOrientation orientation1 = user1.getSexualOrientation();
        SexualOrientation orientation2 = user2.getSexualOrientation();

        if(orientation1 == null || orientation2 == null) return 0.0;

        Gender gender1 = user1.getGender();
        Gender gender2 = user2.getGender();

        if(gender1 == null || gender2 == null) return 0.0;

        if (orientation1.equals(STRAIGHT) && orientation2.equals(STRAIGHT)) {
            if (!gender1.equals(gender2)) return 1.0;
            return 0.0;
        }
        if ((orientation1.equals(GAY) && orientation2.equals(GAY))
                ||
                (orientation1.equals(LESBIAN) && orientation2.equals(LESBIAN)
                )) {
            if (gender1.equals(gender2)) return 1.0;
            return 0.0;
        }
        if((orientation1.equals(BISEXUAL) || orientation1.equals(DEMISEXUAL)) && (orientation2.equals(BISEXUAL) || orientation2.equals(DEMISEXUAL))) return 1.0;
        if((orientation1.equals(BISEXUAL) || orientation1.equals(DEMISEXUAL)) && (orientation2.equals(GAY) || orientation2.equals(LESBIAN))){
            if(gender1.equals(gender2)) return 1.0;
            return 0.5;
        }
        if((orientation1.equals(BISEXUAL) || orientation1.equals(DEMISEXUAL)) && orientation2.equals(STRAIGHT)){
            if(!gender1.equals(gender2)) return 0.25;
            return 0.0;
        }

        if(orientation1.equals(PANSEXUAL) && (orientation2.equals(PANSEXUAL) || orientation2.equals(BISEXUAL) || orientation2.equals(DEMISEXUAL))) return 1.0;
        if(orientation1.equals(PANSEXUAL) && orientation2.equals(STRAIGHT)){
            if(!gender1.equals(gender2)) return 0.25;
            else return 0.0;
        }
        if(orientation1.equals(QUESTIONING)) return 1.0;
        if(orientation1.equals(OTHER) && orientation2.equals(OTHER)) return 1.0;

        return 0.0;

    }
}
