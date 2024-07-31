package app.user.service.application.dto;

import app.user.service.application.helper.Education;
import app.user.service.application.helper.Gender;
import app.user.service.application.helper.Race;
import app.user.service.application.helper.SexualOrientation;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class UserPersonalDataDto {

    @NotNull
    @Pattern(regexp = "^[a-zA-z\\-\\s]{2,20}$")
    private String firstName;
    @NotNull
    @Pattern(regexp = "^[a-zA-z\\-\\s]{2,20}$")
    private String lastName;
    @NotNull
    private String countryCode;
    @NotNull
    @Pattern(regexp = "^[a-zA-Z\\s\\-_0-9]{2,40}$\"")
    private String city;
    @NotNull
    private Gender gender;
    private Set<Education> educationList;
    private Race race;
    private SexualOrientation sexualOrientation;
    @NotNull
    @Past
    private LocalDateTime birthDate;

}
