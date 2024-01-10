package electronicStore.mapper;

import electronicStore.dto.requestDto.UserRequestDto;
import electronicStore.dto.responseDto.UserResponseDto;
import electronicStore.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User userRequestDtoToUser(UserRequestDto userRequestDto);

    UserResponseDto userToUserResponseDto(User user);

    @Mapping(target = "id", ignore = true)
    User userRequestDtoToUserOverwrite(UserRequestDto userRequestDto, @MappingTarget User user);
}
