package com.emart2.redirect.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class MyInfoDto {


  @Getter @Setter
  public static class Response{
    private final Long id;
    private final String username;
    private final String email;

    @Builder
    public Response(Long id, String username, String email){
      this.id = id;
      this.username = username;
      this.email = email;
    }
  }
}
