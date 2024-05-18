package app.user.service.adapters.controller;

import app.user.service.application.helper.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile-data")
@CrossOrigin
public class PreferenceController {
    @GetMapping("/preference")
    public Preference[] getPreferenceList(){
        return Preference.values();
    }
    @GetMapping("/sexual-orientation")
    public SexualOrientation[] getSexualOrientationList(){
        return SexualOrientation.values();
    }
    @GetMapping("/race")
    public Race[] getRaceList(){
        return Race.values();
    }
    @GetMapping("/education")
    public Education[] getEducationList(){
        return Education.values();
    }
    @GetMapping("/gender")
    public Gender[] getGenderList(){
        return Gender.values();
    }

}
