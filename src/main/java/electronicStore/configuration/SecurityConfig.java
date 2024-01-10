//package electronicStore.configuration;
//
//import electronicStore.security.JwtAuthenticationEntryPoint;
//import electronicStore.security.JwtAuthenticationFilter;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@Slf4j
//public class SecurityConfig {
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Autowired
//    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
//
//    @Autowired
//    private JwtAuthenticationFilter jwtAuthenticationFilter;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.csrf(csrf -> csrf.disable())
//                .cors(cors -> cors.disable())
//                .authorizeHttpRequests(auth -> auth.requestMatchers("/home/**").authenticated()
//                        .requestMatchers("/auth/login").permitAll().anyRequest().authenticated())
//                .exceptionHandling(ex -> ex.authenticationEntryPoint(jwtAuthenticationEntryPoint))
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//        httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//        return httpSecurity.build();
//    }
//
//}
