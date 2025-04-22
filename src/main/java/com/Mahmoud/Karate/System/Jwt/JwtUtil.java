package com.Mahmoud.Karate.System.Jwt;

import com.Mahmoud.Karate.System.Entities.Instructor;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.xml.ws.Response;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import io.jsonwebtoken.Claims;

import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {


    private static Key securityKey ;
    private static final String SECRET_KEY ="mkloifbabsmckosijdhuqywyegrffdfqwettbcvgftcuiqkwjnfhuurymmmrrkluliuthnj";
    private static final long EXPIRATION_TIME = 3600000;


    public JwtUtil() throws NoSuchAlgorithmException {
        securityKey = getSecretKey();
    }

    private SecretKey getSecretKey() {
        byte[] keyBytes = Base64.getDecoder().decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public Map<String, Object> generateClaims(Instructor instructor) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", "Instructor");
        claims.put("instructorId", instructor.getId());
        claims.put("email", instructor.getEmail());
        return claims;

    }
    public ResponseEntity<String> generateToken(Instructor instructor) {
        String accessToken = Jwts.builder().setClaims(generateClaims(instructor))
                .setSubject(instructor.getUsername())               // Set the username as the subject
                .setIssuedAt(new Date())                      // Set the issue time
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hour expiration
                .signWith(securityKey) // Sign the token with HMAC-SHA256
                .compact();
        /*String refreshToken = Jwts.builder()
                .setClaims(generateClaims(instructor))
                .setSubject(instructor.getUsername())               // Set the username as the subject// Add the role as a custom claim
                .setIssuedAt(new Date())                      // Set the issue time
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 day expiration
                .signWith(securityKey ) // Sign the token with HMAC-SHA256
                .compact();*/

        ResponseEntity<String> s = new ResponseEntity<>(accessToken , HttpStatus.OK);
        return s;
    }

    public Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(securityKey)
                .build().parseClaimsJws(token).getBody();
    }


    // to extract the username from the token
    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(securityKey)               // Use the secret key for validation
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();

    }

    //to extract the role from the token
    public String extractRole(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(securityKey)               // Use the secret key for validation
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("role", String.class);       // Retrieve the role claim
    }


    public Date extractExpirationDate(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(securityKey)               // Use the secret key for validation
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();      // Retrieve the role claim
    }

    // Validate the token
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(securityKey)              // Verify with the secret key
                    .build()
                    .parseClaimsJws(token);                  // Parse the token
            return true; // Valid token
        } catch (JwtException | IllegalArgumentException e ) {
            return false; // Invalid token
        }

    }

    // Get the base64 encoded secret key (optional, for debugging or storage)
    public String getBase64EncodedKey() {
        return Base64.getEncoder().encodeToString(securityKey.getEncoded());
    }


}
