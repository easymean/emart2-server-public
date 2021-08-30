package com.emart2.redirect.account.dto;

import com.emart2.redirect.type.AccountType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

public class ManageAccountDto {

  @Getter
  @Setter
  @NoArgsConstructor
  public static class Response {
    private Long id;
    private String accountId;
    private String accountPassword;
    private LocalDateTime updatedAt;
    private String info;

    @Builder
    public Response(Long id, String accountId, String accountPassword, LocalDateTime updatedAt, String info) {
      this.id = id;
      this.accountId = accountId;
      this.accountPassword = accountPassword;
      this.updatedAt = updatedAt;
      this.info = info;
    }
  }

  @Getter
  @Setter
  @Builder
  public static class Request {
    private String accountId;
    private String accountPassword;
    private String info;
    private AccountType gubun;
  }
}
