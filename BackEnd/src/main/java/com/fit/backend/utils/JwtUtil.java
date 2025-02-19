package com.fit.backend.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fit.backend.dtos.UserRegistrationDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {
    @Value("${application.security.jwt.secret-key}")
    private String secretKey;

    private final ObjectMapper objectMapper = new ObjectMapper();

    // Tạo JWT chứa thông tin từ UserRegistrationDTO
    public String generateVerificationToken(UserRegistrationDTO dto) throws JsonProcessingException {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userInfo", objectMapper.writeValueAsString(dto));
        return createToken(claims, dto.getEmail());
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 10 * 60 * 1000)) // 10 phút
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // Lấy thông tin UserRegistrationDTO từ JWT
    public UserRegistrationDTO extractUserInfo(String token) throws JsonProcessingException {
        String userInfoJson = extractAllClaims(token).get("userInfo", String.class);
        return objectMapper.readValue(userInfoJson, UserRegistrationDTO.class);
    }

    public Boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }
}
