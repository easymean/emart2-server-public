package com.emart2.redirect.config.security;

import com.emart2.redirect.common.security.service.JwtTokenProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtTokenFilter extends OncePerRequestFilter {
  private final String AUTHORIZATION_HEADER = "Authorization";
  private final String TOKEN_PREFIX = "Bearer";
  private final JwtTokenProvider tokenProvider;

  public JwtTokenFilter(JwtTokenProvider tokenProvider) {
    this.tokenProvider = tokenProvider;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
      throws IOException, ServletException{
    String token = resolveToken(req);
    if(StringUtils.hasText(token) && tokenProvider.validateToken(token)){
      Authentication authentication = tokenProvider.getAuthentication(token);
      SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    chain.doFilter(req, res);
  }

  /**
   * 헤더에서 토큰 가져오기
   **/
  private String resolveToken(HttpServletRequest req){

    String authorizationHeader = req.getHeader(AUTHORIZATION_HEADER);
    if(authorizationHeader == null || !authorizationHeader.startsWith(TOKEN_PREFIX)){
      return null;
    } //헤더 유효성 체크
    return authorizationHeader.substring(TOKEN_PREFIX.length()); //토큰 파싱
  }

}
