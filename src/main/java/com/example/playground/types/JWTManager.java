package com.example.playground.types;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;


public class JWTManager {
    private Algorithm algo;
    private String secret;
    private JWTVerifier verifier;

    public JWTManager(){
        //TODO: HIDE SECRET
        this.secret = "secret";
        this.algo = Algorithm.HMAC256(secret.getBytes());
        this.verifier = JWT.require(algo).build();
    }

    public UsernamePasswordAuthenticationToken verifyToken(String token) throws Exception{
        DecodedJWT decodedJWT = verifier.verify(token);
        String username = decodedJWT.getSubject();
        String[] roles = decodedJWT.getClaim("roles").asArray(String.class);
        Collection<SimpleGrantedAuthority> userRoles = new ArrayList();
        Arrays.stream(roles).forEach(role-> userRoles.add(new SimpleGrantedAuthority(role)));

        return new UsernamePasswordAuthenticationToken(username, userRoles);
    }

    public Map<String, String> getTokens(UserDetails userDetails){
        Map<String, String> tokens = new HashMap();
        tokens.put("access_token", getAccessToken(userDetails));
        tokens.put("refresh_token", getRefreshToken(userDetails));

        return tokens;
    }

    public String getAccessToken(UserDetails userDetails){
        String accessToken = JWT.create()
                .withSubject(userDetails.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() * 2 * 60 * 1000))
                .withClaim("roles", userDetails.getAuthorities().stream().map(role-> role.getAuthority()).collect(Collectors.toList()))
                .sign(algo);
        return accessToken;
    }

    public String getRefreshToken(UserDetails userDetails){
        String refreshToken = JWT.create()
                .withSubject(userDetails.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() * 3 * 60 * 1000))
                .sign(algo);
        return refreshToken;
    }
}
