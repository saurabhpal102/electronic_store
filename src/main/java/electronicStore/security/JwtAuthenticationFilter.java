//package electronicStore.security;
//
//import io.jsonwebtoken.ExpiredJwtException;
//import io.jsonwebtoken.MalformedJwtException;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//@Slf4j
//@Component
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//
//    @Autowired
//    private JwtHelper jwtHelper;
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException, ServletException {
//        log.info("request :: {}", request);
//        String requestHeader = request.getHeader("Authorization");
//        log.info("requestHeader :: {}", requestHeader);
//        String email = null;
//        String token = null;
//        if (requestHeader != null && requestHeader.startsWith("Bearer")) {
//            token = requestHeader.substring(7);
//
//            try {
//                email = jwtHelper.getUsernameFromToken(token);
//            } catch (IllegalArgumentException e) {
//                log.info("IllegalArgumentException :: {} ", e.getMessage());
//            } catch (ExpiredJwtException e) {
//                log.info("ExpiredJwtException :: {}", e.getMessage());
//            } catch (MalformedJwtException e) {
//                log.info("MalformedJwtException :: {}", e.getMessage());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else {
//            log.info("Invalid header value !!");
//        }
//
//        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//            UserDetails userDetails = this.userDetailsService.loadUserByUsername(email);
//            Boolean validateToken = this.jwtHelper.validateToken(token);
//
//            if (validateToken) {
//                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            }
//        } else {
//            log.info("Validation failed !!");
//        }
//        filterChain.doFilter(request, response);
//    }
//}
