package com.emart2.redirect.auth.application;

import com.emart2.redirect.auth.AuthService;
import com.emart2.redirect.auth.UserAccount;
import com.emart2.redirect.auth.dto.LoginDto;
import org.springframework.stereotype.Component;

@Component
public class LoginManager {

  private final AuthService authService;
  private final LoginMapper mapper;

  public LoginManager(AuthService authService, LoginMapper mapper) {
    this.authService = authService;
    this.mapper = mapper;
  }

  public void signUp(LoginDto.Login req) {
    authService.createUser(mapper.toEntity(req));
  }

  public void login(LoginDto.Login req) {
    authService.login(req.getUsername(), req.getPassword());
  }
}
