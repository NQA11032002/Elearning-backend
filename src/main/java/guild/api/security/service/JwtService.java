package guild.api.security.service;

import guild.api.security.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Data
public class JwtService {
    private final String SECRET_KEY = "462884FCD356AE84BE6F1125725BF";

    //get token for user login
    public String generateToken(User userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(Map<String, Object> extraClaims, User userDetails) {
        //get list roles of user
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        List<String> roles = authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        //add roles in to Claims;
        extraClaims.put("roles", roles);
        extraClaims.put("userID", userDetails.getId());
        ZonedDateTime expirationTime = ZonedDateTime.now().plus(24, ChronoUnit.HOURS);
        Date exprire = Date.from(expirationTime.toInstant());

        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(exprire)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public Integer getUserID(String token){
        return this.extractClaim(token, claims -> claims.get("userID", Integer.class));
    }

    public Date getExpirationTimeFromToken(String token, String secretKey) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();

        return claims.getExpiration();
    }

    //check token
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    //get userName of token
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    //check token expired
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    //get expired of token
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    //get information user login by token
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    //Phương thức này trích xuất tất cả các claim từ token
    public Claims extractAllClaims(String token){
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }
}