package com.ll.chatApp.global.jwt;

import com.ll.chatApp.domain.member.member.entity.Member;
import com.ll.chatApp.global.util.Ut;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtProvider {
    @Value("${custom.jwt.secretKey}")
    private String secretKeyOrigin;

    @Value("${custom.accessToken.expirationSeconds}")
    private int accessTokenExpirationSeconds;

    private SecretKey cachedSecretKey;

    public SecretKey getSecretKey() {
        if (cachedSecretKey == null) {
            cachedSecretKey = cachedSecretKey = _getSecretKey();
        }
        return cachedSecretKey;
    }

    private SecretKey _getSecretKey() {
        String keyBase64Encoded = Base64.getEncoder().encodeToString(secretKeyOrigin.getBytes());
        return Keys.hmacShaKeyFor(keyBase64Encoded.getBytes());
    }

    public String genAccessToken(Member member) {
        return genToken(member, accessTokenExpirationSeconds);
    }

    public String genRefreshToken(Member member) {
       return genToken(member, 60 * 60 * 24 * 365 * 1);
    }

    public String genToken(Member member, int seconds) {
        Map<String, Object> claims = new HashMap<>();

        claims.put("id", member.getId());
        claims.put("username", member.getUsername());
        long now = new Date().getTime();
        Date accessTokenExpiresIn = new Date(now + 1000L * seconds);
        return Jwts.builder()
                .claim("body", Ut.json.toStr(claims))
                .setExpiration(accessTokenExpiresIn)
                .signWith(getSecretKey(), SignatureAlgorithm.HS512)
                .compact();
    }

    // 클레임 정보 받아오기
    public Map getClaims(String token) {
        String body = Jwts.parserBuilder()
                .setSigningKey(getSecretKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("body", String.class);
        return Ut.toMap(body);
    }

    // 유효성 검증
    public boolean verify (String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSecretKey())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
