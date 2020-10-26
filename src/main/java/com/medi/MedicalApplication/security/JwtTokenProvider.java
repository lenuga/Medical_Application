package com.medi.MedicalApplication.security;


import com.medi.MedicalApplication.model.Login;
import io.jsonwebtoken.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import static com.medi.MedicalApplication.security.SecurityConstants.EXPIRATION_TIME;
import static com.medi.MedicalApplication.security.SecurityConstants.SECRET;

@Component
public class JwtTokenProvider {
    //Generate the token

    public String generateToken(Authentication authentication) {
        Login login = (Login) authentication.getPrincipal();
        Date now = new Date(System.currentTimeMillis());

        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);

        String loginId = Long.toString(login.getLoginId());

        Map<String, Object> claims = new HashMap<>();
        claims.put("loginId", (Long.toString(login.getLoginId())));
        claims.put("username", login.getUsername());


        return Jwts.builder()
                .setSubject(loginId)
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    //Validate the token
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
            return true;
        } catch (SignatureException ex) {
            System.out.println("Invalid JWT SSignature");
        } catch (MalformedJwtException ex) {
            System.out.print("Invalid JWT Token");
        } catch (ExpiredJwtException ex) {
            System.out.println("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            System.out.println("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            System.out.println("JWT claims string is empty");
        }
        return false;
    }


    //Get login Id from token

public Long getLoginIdFromJWT(String token){
        Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        String loginId = (String)claims.get("loginId");


        return Long.parseLong(loginId);
   }
}
