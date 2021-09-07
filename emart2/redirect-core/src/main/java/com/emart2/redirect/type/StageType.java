package com.emart2.redirect.type;

public enum StageType implements EnumMapperType {
  WEB("웹", "WEB"),
  DEPLOY("배포", "DEPLOY"),
  ADMIN("관리", "ADMIN"),
  MONITOR("모니터링", "MONITOR"),
  CONFIG("형상관리", "CONFIG"),
  ;

  private final String title;
  private final String code;

  StageType(String title, String code) {
    this.title = title;
    this.code = code;

  }

  @Override
  public String getCode() {
    return code;
  }

  @Override
  public String getTitle() {
    return title;
  }

}
