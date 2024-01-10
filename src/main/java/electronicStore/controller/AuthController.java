//package electronicStore.controller;
//
//import electronicStore.dto.JwtRequest;
//import electronicStore.dto.JwtResponse;
//import electronicStore.dto.responseDto.UserResponseDto;
//import electronicStore.mapper.UserMapper;
//import electronicStore.model.User;
//import electronicStore.security.JwtHelper;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.web.bind.annotation.*;
//
//import java.security.Principal;
//
//@RestController
//@RequestMapping("/auth")
//@Slf4j
//public class AuthController {
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private JwtHelper jwtHelper;
//
//    @Autowired
//    private UserMapper userMapper;
//
//    @GetMapping("/current")
//    public ResponseEntity<UserDetails> getCurrentUser(Principal principal) {
//        String name = principal.getName();
//        return new ResponseEntity<>(userDetailsService.loadUserByUsername(name), HttpStatus.OK);
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest jwtRequest) {
//        this.doAuthenticate(jwtRequest.getEmail(), jwtRequest.getPassword());
//        UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getEmail());
//        String token = jwtHelper.generateToken(userDetails.getUsername());
//        UserResponseDto userResponseDto = userMapper.userToUserResponseDto((User) userDetails);
//        JwtResponse jwtResponse = JwtResponse.builder().jwtToken(token).user(userResponseDto).build();
//        return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
//    }
//
//    private void doAuthenticate(String username, String password) {
//        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, password);
//        try {
//            log.info("authentication :: {}", authentication);
//            authenticationManager.authenticate(authentication);
//        } catch (BadCredentialsException e) {
//            throw new BadCredentialsException("Invalid username or password !!");
//        }
//    }
//}
