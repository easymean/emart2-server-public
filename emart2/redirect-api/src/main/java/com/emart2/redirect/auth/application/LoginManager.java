package com.emart2.redirect.auth.application;

import com.emart2.redirect.auth.service.AuthService;
import com.emart2.redirect.auth.entity.UserAccount;
import com.emart2.redirect.auth.dto.LoginDto;
import com.emart2.redirect.common.security.service.JwtTokenProvider;
import org.springframework.stereotype.Component;

@Component
public class LoginManager {

  private final AuthService authService;
  private final JwtTokenProvider jwtTokenProvider;
  private final LoginMapper mapper;

  public LoginManager(AuthService authService, JwtTokenProvider jwtTokenProvider, LoginMapper mapper) {
    this.authService = authService;
    this.jwtTokenProvider = jwtTokenProvider;
    this.mapper = mapper;
  }

  public LoginDto.Response signUp(LoginDto.Signup req) {
    return mapper.toDto(authService.createUser(mapper.toEntity(req)));
  }

  public String login(LoginDto.Login req) {
    UserAccount user = authService.login(req.getUsername(), req.getPassword());
    return jwtTokenProvider.generateToken(user);
  }

  public Boolean checkId(LoginDto.Signup req) {
    return authService.checkId(req.getUsername());
  }
}
