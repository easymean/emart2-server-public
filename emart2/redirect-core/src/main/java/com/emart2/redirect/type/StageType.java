package com.emart2.redirect.type;

public enum StageType implements EnumMapperType {
  WEB_FRONT("웹프론트", "WEB_FRONT"),
  WEB_BOS("웹보스", "WEB_BOS"),
  DEPLOY("배포", "DEPLOY"),
  ADMIN("관리", "ADMIN"),
  MONITOR("모니터링", "MONITOR"),
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
