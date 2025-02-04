package com.gymclub.gym_club_service.service;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;

import java.util.function.Function;

public interface JwtService {

    String generateToken(String username);

    String extractUsername(String token);

    <T> T extractClaim(String token, Function<Claims, T> claimsResolver);

    String extractToken(HttpServletRequest request);

    boolean validateToken(String token);
}
