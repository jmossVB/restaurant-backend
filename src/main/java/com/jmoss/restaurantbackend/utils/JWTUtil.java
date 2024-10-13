package com.jmoss.restaurantbackend.utils;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


@Component
public class JWTUtil {

    private static String SECRET_KEY = "restaurant-backend";

    private static Algorithm ALGORITHM = Algorithm.HMAC256(SECRET_KEY);

    public String createToken(String username) {
        return JWT.create()
                .withSubject(username)
                .withIssuer("auth-restaurant")
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() * TimeUnit.MINUTES.toMillis(15)))
                .sign(ALGORITHM);
    }

    public boolean validToken(String token) {
        try {
            JWT.require(ALGORITHM)
                    .build()
                    .verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getusername(String token) {
        return JWT.require(ALGORITHM)
                .build()
                .verify(token)
                .getSubject();
    }
}