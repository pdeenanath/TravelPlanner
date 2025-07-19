package com.travelplanner.config;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.crypto.SecretKey;

@Configuration
public class JwtConfig {


//    public SecretKey jwtSecretKey() {
//        // Generates a secure HS512 key
//        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
//        String base64Key = Encoders.BASE64.encode(key.getEncoded());
//        System.out.println("Generated Base64 secret key: " + base64Key);
//        return key;
//    }
    @Bean
    public SecretKey jwtSecretKey(@Value("${jwt.secret}") String base64Key) {
        byte[] bytes = Decoders.BASE64.decode(base64Key);
        return Keys.hmacShaKeyFor(bytes);
    }

}
