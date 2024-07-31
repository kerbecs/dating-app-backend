package app.compatibility.service.application.helper.counter;

import app.compatibility.service.application.dto.UserProfileDto;
import app.compatibility.service.application.helper.Race;

import java.util.List;

import static app.compatibility.service.application.helper.Race.*;

public class RaceCompatibilityCounter {
    private RaceCompatibilityCounter() {}
    public static double countCompatibilityByRace(UserProfileDto user1, UserProfileDto user2){
        Race race1 = user1.getRace();
        Race race2 = user2.getRace();

        if(race1 == null || race2 == null) return 0.0;

        if(race1.equals(race2)) return 1.0;

        List<Race> white = List.of(WHITE, CAUCASIAN, ROMANI, HISPANIC_LATINO, JEWISH);
        List<Race> black = List.of(NEGROID, INDIGENOUS, INDIGENOUS_SIBERIAN, AFRO_LATINO, PACIFIC_ISLANDER);
        List<Race> mongoloid = List.of(MONGOLOID,SOUTH_ASIAN, EAST_ASIAN, SOUTH_ASIAN);
        List<Race> arab = List.of(ARAB);

        if((white.contains(race1) && white.contains(race2))
                ||
                (black.contains(race1) && black.contains(race2))
                ||
                (mongoloid.contains(race1) && mongoloid.contains(race2))
                ||
                (arab.contains(race1) && arab.contains(race2))
        ) return 1.0;

        if((white.contains(race1) && black.contains(race2)) || (white.contains(race2) && black.contains(race1))) return 0.5;
        if((white.contains(race1) && mongoloid.contains(race2)) || (white.contains(race2) && mongoloid.contains(race1))) return 0.75;
        if((white.contains(race1) && arab.contains(race2)) || (white.contains(race2) && arab.contains(race1))) return 0.75;
        if((black.contains(race1) && mongoloid.contains(race2)) || (black.contains(race2) && mongoloid.contains(race1))) return 0.5;
        if((arab.contains(race1) && mongoloid.contains(race2)) || (arab.contains(race2) && mongoloid.contains(race1))) return 0.25;
        if((black.contains(race1) && arab.contains(race2)) || (black.contains(race2) && arab.contains(race1))) return 0.5;


        return 0.15;


    }
}
