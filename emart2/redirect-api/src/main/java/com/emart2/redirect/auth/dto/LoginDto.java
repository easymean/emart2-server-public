package com.emart2.redirect.auth.dto;

import lombok.*;

public class LoginDto {

  public static class Response {

  }

  @Getter
  @Builder
  public static class Login {
    private final String email;
    private final String password;

    public Login(String email, String password) {
      this.email = email;
      this.password = password;
    }
  }
}
