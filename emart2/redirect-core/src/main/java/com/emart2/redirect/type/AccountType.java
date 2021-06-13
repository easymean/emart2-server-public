package com.emart2.redirect.type;

import lombok.Getter;

@Getter
public enum AccountType implements EnumMapperType {
  PRIVATE("PRIVATE", 0),
  PUBLIC("PUBLIC", 1),
  ;

  private String code;
  private int num;

  AccountType(String code, int num) {
    this.code = code;
    this.num = num;
  }

  @Override
  public String getTitle() {
    return null;
  }
}
