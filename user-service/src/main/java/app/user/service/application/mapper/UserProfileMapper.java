package app.user.service.application.mapper;

import app.user.service.application.dto.UserProfileDto;
import app.user.service.application.entity.UserProfile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    UserProfileDto userProfileToUserProfileDto(UserProfile userProfile);
    UserProfile userProfileDtoToUserProfile(UserProfileDto userProfileDto);
}
