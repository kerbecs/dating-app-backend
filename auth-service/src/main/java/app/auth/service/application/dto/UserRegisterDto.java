package app.auth.service.application.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserRegisterDto {
    @NotNull
    @Pattern(regexp = "[a-zA-z\\-\\s]{2,20}$")
    private String firstName;

    @NotNull
    @Pattern(regexp = "[a-zA-z\\-\\s]{2,20}$")
    private String lastName;

    @NotNull
    @NotEmpty
    private String countryCode;

    @NotNull
    @Pattern(regexp = "[a-zA-Z\\s\\-_0-9]{2,40}$")
    private String city;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Pattern(regexp = "^(?=.{8,}$)(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*\\W).*$")
    private String password;

    @NotNull
    private String repeatedPassword;

    @NotNull
    @NotEmpty
    private String gender;

    @NotNull
    @NotEmpty
    @Past
    private LocalDateTime birthDate;

    @NotNull
    @AssertTrue
    private Boolean declareIsAdult;

    @NotNull
    @AssertTrue
    private Boolean declareAgreeTerms;
}
