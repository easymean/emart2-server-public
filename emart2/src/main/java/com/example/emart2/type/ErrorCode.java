package com.example.emart2.type;

public enum ErrorCode {
  NOT_FOUND(1000, "NOT FOUND"),
  ACCESS_DENIED(1004, "ACCESS_DENIED"),
  ;
  private final String message;
  private final int code;

  ErrorCode(int code, String message){
    this.code = code;
    this.message = message;
  }

  public String getMessage(){
    return this.message;
  }

}
