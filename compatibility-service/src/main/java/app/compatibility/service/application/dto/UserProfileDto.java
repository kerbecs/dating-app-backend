package app.compatibility.service.application.dto;

import app.compatibility.service.application.helper.*;
import app.compatibility.service.application.helper.counter.Coords;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
public class UserProfileDto {
    private String id;
    private Long userId;
    private String firstName;
    private String lastName;
    private String countryCode;
    private String city;
    private Gender gender;
    private Set<Education> educationList;
    private Set<Preference> preferenceList;
    private Race race;
    private SexualOrientation sexualOrientation;
    private LocalDateTime birthDate;
    private String imgUrl;
    private Set<Long> connexions;
    private Coords coords;
    private boolean online;
}
