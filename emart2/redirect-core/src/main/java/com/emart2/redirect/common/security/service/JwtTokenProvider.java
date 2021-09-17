package com.emart2.redirect.common.security.service;

import com.emart2.redirect.auth.entity.UserAccount;
import com.emart2.redirect.auth.service.AuthService;
import com.emart2.redirect.common.security.exception.NotFoundExpirationFromTokenException;
import com.emart2.redirect.common.security.exception.NotFoundRoleFromTokenException;
import com.emart2.redirect.common.security.exception.NotFoundUsernameFromTokenException;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtTokenProvider implements Serializable {
  private static final long serialVersionUID = -123456789L;
  private static final long JWT_TOKEN_VALIDITY = 24 * 60 * 60 * 7 * 1000;
  private final AuthService authService;
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  private JwtTokenProvider(AuthService authService) {
    this.authService = authService;
  }

  @Value("${jwt.secret}")
  private String secret;

  /**
   * 토큰 생성
   **/
  public String generateToken(UserAccount user) {
    Date now = new Date();
    logger.info("token created");
    return Jwts.builder()
        .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
        .setClaims(createClaims(user)) // 공개 클레임 설정(유저 정보) * 가장 먼저 설정해야함 뒤에 두면 덮어쓰기 된다. *
        .setSubject(user.getUsername()) // 토큰 제목: 유일한 키값(유저 아이디)
        .setIssuedAt(now) // 발급 시간: 현재
        .setExpiration(new Date(now.getTime() + JWT_TOKEN_VALIDITY)) // 만료 시점: 1주일 뒤
        .signWith(SignatureAlgorithm.HS256, this.secret) //암호화 키, 암호화 방법
        .compact();
  }

  /**
   * claim 생성
   **/
  private static Map<String, Object> createClaims(UserAccount user) {
    Map<String, Object> claims = new HashMap<>();
    claims.put("role", user.getAuthorities());
    return claims;
  }

  /**
   * secret 키를 통해 token에 있는 모든 claims 조회
   **/
  private Claims getAllClaimsFromToken(String token) {
    return Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
  }

  /**
   * claim에 claimsResolver 함수를 적용한다.
   **/
  public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = getAllClaimsFromToken(token);
    return claimsResolver.apply(claims);
  }

  /**
   * token에서 subject 가져오기
   **/
  public String getUsernameFromToken(String token) {
    try {
      return getClaimFromToken(token, Claims::getSubject);
    } catch (Exception ex) {
      throw new NotFoundUsernameFromTokenException();
    }
  }

  /**
   * token에서 expiration 가져오기
   **/
  public Date getExpirationDate(String token){
    try{
      return getClaimFromToken(token, Claims::getExpiration);
    } catch(Exception ex){
      throw new NotFoundExpirationFromTokenException();
    }
  }

  public Boolean isTokenExpired(String token) {
    return getExpirationDate(token).before(new Date());
  }

  /**
   * 토큰 유효성 체크
   **/
  public Boolean validateToken(String token) {
    try {
      return !isTokenExpired(token);
    } catch (Exception ex) {
      return false;
    }
  }

  public Authentication getAuthentication(String token) {
    Claims claims = getAllClaimsFromToken(token);

    if (claims.get("role") == null) {
      throw new NotFoundRoleFromTokenException();
    }
    final String username = getUsernameFromToken(token);
    UserDetails userAccount = authService.loadUserByUsername(username);
    return new UsernamePasswordAuthenticationToken(userAccount, "", userAccount.getAuthorities());
  }


}
