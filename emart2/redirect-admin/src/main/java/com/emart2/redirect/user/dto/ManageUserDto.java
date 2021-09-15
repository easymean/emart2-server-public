package com.emart2.redirect.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class ManageUserDto {

  @Getter
  @Setter
  @NoArgsConstructor
  public static class Response {
    private Long id;
    private String name;


    @Builder
    public Response(Long id, String name) {
      this.id = id;
      this.name = name;

    }
  }

  @Getter
  public static class Create {
    private final String name;
    private final String description;

    public Create(String name, String description) {
      this.name = name;
      this.description = description;
    }
  }

  @Getter
  public static class Update {
    private final String name;
    private final String description;

    public Update(String name, String description) {
      this.name = name;
      this.description = description;
    }
  }
}
