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
 * @author Zimi Li, authored the logic contained within this file.
 * This utility class specifies the data associated with the JSON Web Token authorization service.
 */
@Component
public class JwtUtility {
    public static final String SECRET = "Ocean-Kevin-Child";
    public static final Algorithm algorithm = Algorithm.HMAC256(SECRET);
    public static final JWTVerifier verifier = JWT.require(algorithm).build();
    public static final Integer timeLength = 60*60*1000;

    /**
     * Method used to generate the token that will be passed to the front end to validate the user
     * @param userId    user ID for the user being assigned the JWT
     * @return          returns a string representing the JWT
     */
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

    /**
     * Used to decode the JWT and verify the token matches
     * @param token     the token created from the genToken method is passed to this method for decoding
     * @return          returns a DecodedJWT object
     */
    public DecodedJWT verify(String token) {
        try {
            return verifier.verify(token);
        } catch (JWTVerificationException exception){
            exception.printStackTrace();
        }
        return null;
    }

}