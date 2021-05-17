package com.example.emart2.type;

import lombok.Getter;

@Getter
public enum ErrorCode {
  ACCESS_DENIED(1004, "ACCESS_DENIED"),
  ;
  private String message;
  private int code;

  ErrorCode(int code, String message){
    this.code = code;
    this.message = message;
  }

}
