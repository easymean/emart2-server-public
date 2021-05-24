package com.example.emart2.type;

import lombok.Getter;

@Getter
public enum StageCode {
  WEB_FRONT("프론트", "WEB_FRONT", 3),
  WEB_BOS("보스", "WEB_BOS", 4),
  DEPLOY("배포", "DEPLOY", 5),
  ADMIN("관리", "ADMIN", 6),
  MONITORING("모니터링", "MONITORING", 7),
  DEV("개발", "DEV", 0),
  PROD("운영", "PROD", 1);

  private final String title;
  private final String code;
  private final int num;

  StageCode(String title, String code, int num) {
    this.title = title;
    this.code = code;
    this.num = num;
  }

}
