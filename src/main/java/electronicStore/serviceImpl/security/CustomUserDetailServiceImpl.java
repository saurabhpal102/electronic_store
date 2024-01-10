//package electronicStore.serviceImpl;
//
//import electronicStore.model.User;
//import electronicStore.repositories.UserRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//@Service
//@Slf4j
//@Component
//public class CustomUserDetailServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findUserByEmailAndDeleted(username, false);
//        if (user != null) {
//            return user;
//        } else throw new UsernameNotFoundException("User name with given detail not exist");
//    }
//}
