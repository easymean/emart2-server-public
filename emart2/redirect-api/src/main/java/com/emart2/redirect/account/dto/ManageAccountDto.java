package com.emart2.redirect.account.dto;

import com.emart2.redirect.type.AccountType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class ManageAccountDto {

  @Getter @Setter @Builder
  public static class Response{
    private Long id;
    private String accountId;
    private String accountPassword;
    private Date updatedAt;
    private String info;
  }

  @Getter @Setter @Builder
  public static class Request{
    private String accountId;
    private String accountPassword;
    private String info;
    private AccountType gubun;
  }
}
