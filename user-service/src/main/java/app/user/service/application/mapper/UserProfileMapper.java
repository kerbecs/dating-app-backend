package app.user.service.application.mapper;

import app.user.service.application.dto.UserPersonalDataDto;
import app.user.service.application.dto.UserProfileDto;
import app.user.service.application.entity.UserProfile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    UserProfileDto userProfileToUserProfileDto(UserProfile userProfile);
    UserProfile userProfileDtoToUserProfile(UserProfileDto userProfileDto);
    default UserProfile userPersonalDataDtoToUserProfile(UserProfile userProfile, UserPersonalDataDto userPersonalDataDto){
        userProfile.setFirstName(userPersonalDataDto.getFirstName());
        userProfile.setLastName(userPersonalDataDto.getLastName());
        userProfile.setCity(userPersonalDataDto.getCity());
        userProfile.setBirthDate(userPersonalDataDto.getBirthDate());
        userProfile.setCountryCode(userPersonalDataDto.getCountryCode());
        userProfile.setGender(userPersonalDataDto.getGender());
        userProfile.setEducationList(userPersonalDataDto.getEducationList());
        userProfile.setSexualOrientation(userPersonalDataDto.getSexualOrientation());
        userProfile.setRace(userPersonalDataDto.getRace());

        return userProfile;
    }
}
