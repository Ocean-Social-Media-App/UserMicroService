package com.revature.ocean.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Zimi Li
 */
@Component
public class JwtUtility {
    public static final String SECRET = "Ocean-Kevin-Child";
    public static final Algorithm algorithm = Algorithm.HMAC256(SECRET);
    public static final JWTVerifier verifier = JWT.require(algorithm).build();
    public static final Integer timeLength = 60*60*1000;

    public String genToken(Integer userId) {
        try {
//            Map<String, String> payloads = new HashMap<>();
//            payloads.put("userId", "12312");
//            payloads.put("uesrName", "username");
//            String token = JWT.create().withPayload(payloads).sign(algorithm);
//            return token;
            return JWT.create().withClaim("userId", userId)
                    .withExpiresAt(new Date(System.currentTimeMillis() + timeLength))
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            exception.printStackTrace();
        }
        return null;
    }

    public DecodedJWT verify(String token) {
        try {
            return verifier.verify(token);
        } catch (JWTVerificationException exception){
            exception.printStackTrace();
        }
        return null;
    }

}
