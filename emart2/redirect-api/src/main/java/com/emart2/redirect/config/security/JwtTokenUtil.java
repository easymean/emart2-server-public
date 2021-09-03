package com.emart2.redirect.config.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class JwtTokenUtil implements Serializable {
  private static final long serialVersionUID = -123456789L;
  private static final long  JWT_TOKEN_VALIDITY = 24 * 60 * 60 * 7;

  @Value("${jwt.secret}")
  private String secret;
}
