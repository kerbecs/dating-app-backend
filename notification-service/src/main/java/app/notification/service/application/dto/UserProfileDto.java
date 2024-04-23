package app.notification.service.application.dto;

import app.notification.service.application.helper.Gender;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class UserProfileDto {
    private String id;
    private Long userId;
    private String firstName;
    private String lastName;
    private String countryCode;
    private String city;
    private Gender gender;
    private LocalDateTime birthDate;
    private String imgUrl;
    private Set<Long> connexions;
    private boolean online;

}
