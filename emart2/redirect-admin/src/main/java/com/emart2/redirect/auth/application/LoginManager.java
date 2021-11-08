package com.emart2.redirect.auth.application;

import com.emart2.redirect.auth.dto.LoginDto;
import com.emart2.redirect.auth.entity.AdminUserImpl;
import com.emart2.redirect.auth.service.AuthService;
import com.emart2.redirect.common.security.service.JwtTokenProvider;
import com.emart2.redirect.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class LoginManager {

  private final AuthService authService;
  private final JwtTokenProvider tokenProvider;
  private final LoginMapper mapper;

  public LoginManager(AuthService authService, JwtTokenProvider tokenProvider, LoginMapper mapper) {
    this.authService = authService;
    this.tokenProvider = tokenProvider;
    this.mapper = mapper;
  }

  public LoginDto.Response signUp(LoginDto.Signup req) {
    return mapper.toDto(authService.createUser(mapper.toEntity(req)));
  }

  public String login(LoginDto.Login req) {
    User user = authService.login(req.getUsername(), req.getPassword());
    return tokenProvider.generateToken(user);
  }

  public Boolean checkId(LoginDto.Signup req) {
    return authService.checkId(req.getUsername());
  }
}
