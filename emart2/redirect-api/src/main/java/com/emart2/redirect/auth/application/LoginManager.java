package com.emart2.redirect.auth.application;

import com.emart2.redirect.auth.dto.LoginDto;
import com.emart2.redirect.user.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class LoginManager {

  private final UserService userService;
  private final LoginMapper mapper;

  public LoginManager(UserService userService, LoginMapper mapper) {
    this.userService = userService;
    this.mapper = mapper;
  }

  public void Login(LoginDto.Login req) {
    userService.createUser(mapper.toEntity(req));
  }
}
