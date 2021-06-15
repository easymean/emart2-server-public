package com.emart2.redirect.auth.dto;

import lombok.*;

public class LoginDto {

  public static class Response {

  }

  @Getter
  @Builder
  public static class Login {
    private final String ID;
    private final String password;

    public Login(String ID, String password) {
      this.ID = ID;
      this.password = password;
    }
  }
}
