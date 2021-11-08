package com.emart2.redirect.common.security.service;

import com.emart2.redirect.common.security.exception.NotFoundExpirationFromTokenException;
import com.emart2.redirect.common.security.exception.NotFoundUsernameFromTokenException;
import com.emart2.redirect.user.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Date;
import java.util.function.Function;

@Service
public class JwtTokenResolver {
    private final String AUTHORIZATION_HEADER = "Authorization";
    private final String TOKEN_PREFIX = "Bearer";

    @Value("${jwt.secret}")
    private String secret;

    /**
     * secret 키를 통해 token에 있는 모든 claims 조회
     **/
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
    }

    /**
     * claim에 claimsResolver 함수를 적용한다.
     **/
    private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    /**
     * token에서 subject 가져오기
     **/
    private String getUsernameFromToken(String token) throws NotFoundUsernameFromTokenException{
        try {
            return getClaimFromToken(token, Claims::getSubject);
        } catch (Exception ex) {
            throw new NotFoundUsernameFromTokenException();
        }
    }
    /**
     * token에서 expiration 가져오기
     **/
    private Date getExpirationDate(String token){
        try{
            return getClaimFromToken(token, Claims::getExpiration);
        } catch(Exception ex){
            throw new NotFoundExpirationFromTokenException();
        }
    }

    private Boolean isTokenExpired(String token) {
        return getExpirationDate(token).before(new Date());
    }

    /**
     * 토큰 유효성 체크
     **/
    private Boolean validateToken(String token) {
        try {
            return !isTokenExpired(token);
        } catch (Exception ex) {
            return false;
        }
    }

    private String extractToken(NativeWebRequest req){
        String authorizationHeader = req.getHeader(AUTHORIZATION_HEADER);

        // check header
        if(!StringUtils.hasText(authorizationHeader) || !authorizationHeader.startsWith(TOKEN_PREFIX)){
            return null;
        }
        String token = authorizationHeader.substring(TOKEN_PREFIX.length()); //토큰 파싱

        // 토큰 유효성 체크
        if(!StringUtils.hasText(token) || !validateToken(token)){
            return null;
        }
        return token;
    }

    public String getUsername(NativeWebRequest req){
        try {
            String token = extractToken(req);
            return getUsernameFromToken(token);
        }catch(NotFoundUsernameFromTokenException ex) {
            return null;
        }
    }

}
