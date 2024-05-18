package app.compatibility.service.application.helper.counter;

import app.compatibility.service.application.dto.UserProfileDto;
import app.compatibility.service.application.helper.Preference;

import java.util.Set;

public class PreferenceCounter {
    public static double countCompatibilityByPreference(UserProfileDto user1, UserProfileDto user2){
        Set<Preference> pref1 = user1.getPreferenceList();
        Set<Preference> pref2 = user2.getPreferenceList();

        if(pref1 == null || pref1.isEmpty() || pref2 == null || pref2.isEmpty()) return 0.0;

        long matches = pref1.stream().filter(pref2::contains).count();

        if((double) matches /pref1.size() > 0.85) return 1.0;
        if((double) matches /pref1.size() > 0.7) return 0.85;
        if((double) matches /pref1.size() > 0.5) return 0.6;
        if((double) matches /pref1.size() > 0.4) return 0.5;
        if((double) matches /pref1.size() > 0.25) return 0.4;
        if((double) matches /pref1.size() > 0.15) return 0.3;
        if((double) matches /pref1.size() > 0.1) return 0.2;

        return 0.1;


    }
}
