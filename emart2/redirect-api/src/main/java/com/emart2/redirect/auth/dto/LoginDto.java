package com.emart2.redirect.auth.dto;

import lombok.*;

public class LoginDto {

  public static class Response {

  }

  @Getter
  public static class Signup {
    private final String username;
    private final String email;
    private final String password;

    @Builder
    public Signup(String username, String email, String password) {
      this.username = username;
      this.email = email;
      this.password = password;
    }
  }

  @Getter
  public static class Login {
    private final String username;
    private final String password;

    @Builder
    public Login(String username, String password) {
      this.username = username;
      this.password = password;
    }
  }
}
