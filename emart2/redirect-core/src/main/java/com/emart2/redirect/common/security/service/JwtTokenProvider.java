package com.emart2.redirect.common.security.service;

import com.emart2.redirect.common.security.exception.NotFoundExpirationFromTokenException;
import com.emart2.redirect.common.security.exception.NotFoundUsernameFromTokenException;
import com.emart2.redirect.user.entity.User;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtTokenProvider implements Serializable {
  private static final long serialVersionUID = -123456789L;
  private static final long JWT_TOKEN_VALIDITY = 24 * 60 * 60 * 7 * 1000;

  @Value("${jwt.secret}")
  private String secret;

  /**
   * 토큰 생성
   **/
  public String generateToken(User user) {
    Date now = new Date();
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
  private static Map<String, Object> createClaims(User user) {
    Map<String, Object> claims = new HashMap<>();
    claims.put("id", user.getId());
    return claims;
  }




}
