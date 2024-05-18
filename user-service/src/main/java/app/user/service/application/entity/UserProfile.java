package app.user.service.application.entity;

import app.user.service.application.helper.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Document
@Data
@AllArgsConstructor
public class UserProfile {
    @Id
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
    private String imgUrl;
    private List<String> images;
    private Set<Long> connexions;
    private LocalDateTime birthDate;
    private Coords coords;
    private UserSettings userSettings;
    private boolean online;
}
