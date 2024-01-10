package electronicStore.controller;

import electronicStore.helper.ApiResponseMessage;
import electronicStore.dto.requestDto.UserRequestDto;
import electronicStore.dto.responseDto.UserResponseDto;
import electronicStore.services.UserService;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto) {
        UserResponseDto userResponseDto = userService.createUser(userRequestDto);
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable("id") String id) {
        UserResponseDto userResponseDto = userService.getUserById(id);
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable("id") String id, @RequestBody UserRequestDto userRequestDto) {
        UserResponseDto userResponseDto = userService.updateUser(id, userRequestDto);
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<UserResponseDto> searchUser(@PathParam("keyword") String keyword) {
        UserResponseDto userResponseDto = userService.searchUser(keyword);
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<UserResponseDto>> getAllUser() {
        List<UserResponseDto> allUser = userService.getAllUser();
        return new ResponseEntity<>(allUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseMessage> deleteUser(@PathParam("id") String id) {
        userService.deleteUser(id);
        ApiResponseMessage status = ApiResponseMessage.builder().message("Succesfully deleted !!").success(true).status(HttpStatus.OK).build();
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
