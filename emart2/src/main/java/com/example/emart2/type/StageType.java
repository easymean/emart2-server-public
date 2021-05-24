package com.example.emart2.type;

public enum StageType {
  WEB_FRONT("웹프론트"),
  WEB_BOS("웹보스"),
  DEPLOY("배포"),
  ADMIN("관리"),
  MONITOR("모니터링"),
  ;

  private final String title;

  StageType(String title) {
    this.title = title;
  }

  public String getTitle() {
    return this.title;
  }

}
