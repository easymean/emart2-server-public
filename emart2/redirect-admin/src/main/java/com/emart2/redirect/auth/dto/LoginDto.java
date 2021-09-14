package com.emart2.redirect.auth.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class LoginDto {

  @Getter
  @Setter
  public static class Response {
    private String username;
    private String email;
    private String password;
    private String role;

    @Builder
    public Response(String username, String email, String password, String role) {
      this.username = username;
      this.email = email;
      this.password = password;
      this.role = role;
    }

  }

  @Getter
  public static class Signup {
    private final String username;
    private final String email;
    private final String password;
    private final String role;

    @Builder
    public Signup(String username, String email, String password) {
      this.username = username;
      this.email = email;
      this.password = password;
      this.role = "ADMIN";
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
