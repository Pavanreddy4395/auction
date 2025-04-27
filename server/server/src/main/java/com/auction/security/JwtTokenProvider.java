//package com.auction.security;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//@Component
//public class JwtTokenProvider {
//    private final String JWT_SECRET = "secret_key";
//    private final long EXPIRATION_TIME = 86400000; // 1 day
//
//    public String generateToken(String email) {
//        return Jwts.builder()
//                .setSubject(email)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
//                .compact();
//    }
//}
