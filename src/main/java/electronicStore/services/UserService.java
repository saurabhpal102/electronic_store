package electronicStore.services;

import electronicStore.dto.requestDto.UserRequestDto;
import electronicStore.dto.responseDto.UserResponseDto;

import java.util.List;

public interface UserService {

    UserResponseDto createUser(UserRequestDto userRequestDto);

    UserResponseDto updateUser(String Id,UserRequestDto userRequestDto);

    UserResponseDto searchUser(String subTitle);

    UserResponseDto getUserById(String Id);

    List<UserResponseDto> getAllUser();

    void deleteUser(String id);
}
