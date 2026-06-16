package com.chloe.homework.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {

    private static final String SECRET =
            "homeworkSystemJwtSecretKey2026homework";

    private static final Key KEY =
            Keys.hmacShaKeyFor(SECRET.getBytes());

    private static final long EXPIRE =
            24 * 60 * 60 * 1000;

    public static String createToken(Long userId,
                                     String username,
                                     String role) {

        return Jwts.builder()
                .subject(username)
                .claim("userId", userId)
                .claim("role", role)
                .issuedAt(new Date())
                .expiration(new Date(
                        System.currentTimeMillis() + EXPIRE))
                .signWith(KEY)
                .compact();
    }

    public static Claims parseToken(String token) {

        return Jwts.parser()
                .verifyWith((javax.crypto.SecretKey) KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload();

    }

}