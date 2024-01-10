package electronicStore.serviceImpl;

import electronicStore.dto.requestDto.UserRequestDto;
import electronicStore.dto.responseDto.UserResponseDto;
import electronicStore.mapper.UserMapper;
import electronicStore.model.User;
import electronicStore.repositories.UserRepository;
import electronicStore.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService {


    private static final boolean isDeletedFalse = false;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user = userMapper.userRequestDtoToUser(userRequestDto);
        Boolean verifyDuplicate = verifyDuplicateUserOnAdd(user);
        if (verifyDuplicate == true) {
            user.setId(UUID.randomUUID().toString());
            user.setDeleted(false);
            User savedUser = userRepository.save(user);
            return userMapper.userToUserResponseDto(savedUser);
        } else {
            throw new RuntimeException("User already exists");
        }
    }

    private boolean verifyDuplicateUserOnAdd(User user) {
        User user1 = userRepository.findByNameAndDeleted(user.getName(), isDeletedFalse);
        if (user1 != null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public UserResponseDto updateUser(String id, UserRequestDto userRequestDto) {
        User user = userMapper.userRequestDtoToUser(userRequestDto);
        if (verifyDuplicateUserOnUpdate(id, user) == true) {
            User user1 = userMapper.userRequestDtoToUserOverwrite(userRequestDto, user);
            User updatedUser = userRepository.save(user1);
            return userMapper.userToUserResponseDto(updatedUser);
        } else throw (new RuntimeException("User not exist"));
    }

    private Boolean verifyDuplicateUserOnUpdate(String id, User user) {
        User userRes = userRepository.findByNameAndDeletedAndIdNot(user.getName(), isDeletedFalse, id);
        if (userRes != null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public UserResponseDto searchUser(String subTitle) {
        User searchedUser = userRepository.findByNameContainingAndDeleted(subTitle, isDeletedFalse);
        return userMapper.userToUserResponseDto(searchedUser);
    }

    @Override
    public UserResponseDto getUserById(String id) {
        User userById = userRepository.findByIdAndDeleted(id, isDeletedFalse);
        if (userById != null) {
            return userMapper.userToUserResponseDto(userById);
        } else throw new RuntimeException("User with given id not exist");
    }

    @Override
    public List<UserResponseDto> getAllUser() {
        List<User> user = userRepository.findByDeleted(isDeletedFalse);
        if (user != null) {
            return user.stream().map(userMapper::userToUserResponseDto).toList();
        }
        else throw new RuntimeException("User not found");
    }

    @Override
    public void deleteUser(String id) {
        User userById = userRepository.findByIdAndDeleted(id, isDeletedFalse);
        if (userById != null) {
            userById.setDeleted(true);
            User save = userRepository.save(userById);
        }
    }
}
