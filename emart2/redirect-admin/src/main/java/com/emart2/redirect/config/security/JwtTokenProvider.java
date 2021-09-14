package com.emart2.redirect.config.security;

import com.emart2.redirect.auth.service.AuthService;
import com.emart2.redirect.exception.TokenException;
import com.emart2.redirect.type.ErrorType;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
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
  public String generateToken(UserDetails user) {
    Date now = new Date();
    logger.info("token created");
    return Jwts.builder()
        .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
        .setIssuedAt(now) // 발급 시간 현재
        .setExpiration(new Date(now.getTime() + JWT_TOKEN_VALIDITY)) // 만료시간 1주일 뒤
        .setSubject(user.getUsername()) // claim에 subject가 저장된다.
        .setClaims(createClaims(user))//클레임 설정(유저 정보)
        .signWith(SignatureAlgorithm.HS256, this.secret) //암호화 키, 암호화 방법
        .compact();
  }

  /**
   * claim 생성
   **/
  private static Map<String, Object> createClaims(UserDetails user) {
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
   * token에서 subject 사져오기
   **/
  public String getUsernameFromToken(String token) {
    try {
      return getClaimFromToken(token, Claims::getSubject);
    } catch (Exception ex) {
      throw new TokenException("cannot get username from token", ErrorType.INVALID_TOKEN);
    }
  }

  public Boolean isTokenExpired(String token) {
    final Date expiration = getClaimFromToken(token, Claims::getExpiration);
    return expiration.before(new Date());
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

    logger.info("=============================");
    logger.info(claims.get("role").toString());

    if (claims.get("role") == null) {
      throw new TokenException("권한이 없습니다.", ErrorType.INVALID_TOKEN);
    }
    final String username = getUsernameFromToken(token);
    UserDetails userAccount = authService.loadUserByUsername(username);
    return new UsernamePasswordAuthenticationToken(userAccount, "", userAccount.getAuthorities());
  }


}
