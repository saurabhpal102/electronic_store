//package electronicStore.security;
//
//import java.io.Serializable;
//import java.time.Duration;
//import java.time.Instant;
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.exceptions.JWTVerificationException;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//@Component
//@Slf4j
//public class JwtHelper implements Serializable {
//
//    public static final String HEADER_PREFIX = "Bearer ";
//    private static final Duration JWT_TOKEN_VALIDITY = Duration.ofMinutes(120);
//
//    private final Algorithm hmac512;
//
//    private final JWTVerifier verifier;
//
//    private String secret = "1111111111";
//
//    public JwtHelper(@Value("${jwt.secret}") final String secret) {
//        this.hmac512 = Algorithm.HMAC512(secret);
//        this.verifier = JWT.require(this.hmac512).build();
//    }
//
//    public String generateToken(String name) {
//        final Instant now = Instant.now();
//        return JWT.create()
//                .withSubject(name)
//                .withIssuer("app")
//                .withIssuedAt(now)
//                .withExpiresAt(now.plusMillis(JWT_TOKEN_VALIDITY.toMillis()))
//                .sign(this.hmac512);
//    }
//
//    public String generateToken(String name, Integer minutes) {
//        final Instant now = Instant.now();
//        return JWT.create()
//                .withSubject(name)
//                .withIssuer("app")
//                .withIssuedAt(now)
//                .withExpiresAt(now.plusMillis(Duration.ofMinutes(minutes).toMillis()))
//                .sign(this.hmac512);
//    }
//
//    public Boolean validateToken(final String token) {
//        try {
//            return !verifier.verify(token).getSubject().isEmpty();
//        } catch (final JWTVerificationException verificationEx) {
//            return false;
//        }
//    }
//
//    public String validateTokenAndGetUsername(final String token) {
//        try {
//            return verifier.verify(token).getSubject();
//        } catch (final JWTVerificationException verificationEx) {
//            return null;
//        }
//    }
//
//
//    public String getUsernameFromToken(String token) {
//        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
//                .getPrincipal();
//        String username = userDetails.getUsername();
//        return username;
//    }
//}
