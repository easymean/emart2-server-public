package com.emart2.redirect.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class MyInfoDto {


  @Getter @Setter
  public static class Response{
    private final Long id;
    private final String userId;
    private final String email;

    @Builder
    public Response(Long id, String userId, String email){
      this.id = id;
      this.userId = userId;
      this.email = email;
    }
  }
}
