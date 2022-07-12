package com.example.demospringboot.security;

import com.example.demospringboot.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


import java.util.Date;

@Component
@Slf4j
public class JwtTokenProvider {
    private final String JWT_KEY_SECRECT = "ABDC";

    private final long JWT_EXPIRATION = 604800000L;

    public String generateToken(User user){
        Date now = new Date();
        Date expriryDate = new Date(now.getTime() + JWT_EXPIRATION);

        return Jwts.builder()
                .setSubject(Long.toString(user.getId()))
                .setIssuedAt(now)
                .setExpiration(expriryDate)
                .signWith(SignatureAlgorithm.ES256,JWT_KEY_SECRECT)
                .compact();
    }

    public Long getUserIdFromToken(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_KEY_SECRECT)
                .parseClaimsJws(token)
                .getBody();
        return Long.parseLong(claims.getSubject());
    }

    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(JWT_KEY_SECRECT).parseClaimsJws(token);
            return true;
        }
        catch (Exception e){
            log.info("Token invalid");
        }
        return false;
    }
}
