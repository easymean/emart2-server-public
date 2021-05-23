package com.example.emart2.type;

import lombok.Getter;

@Getter
public enum StageCode {
  WEB_FRONT("프론트", "WEB_FRONT"),
  WEB_BOS("보스", "WEB_BOS"),
  DEPLOY("배포", "DEPLOY"),
  ADMIN("관리","ADMIN"),
  MONITORING("모니터링","MONITORING"),
  ;

  private final String title;
  private final String code;

  StageCode(String title, String code){
    this.title = title;
    this.code = code;
  }

}
