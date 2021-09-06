package com.emart2.redirect.type;

public enum ErrorType {
  NOT_FOUND(1000, "NOT FOUND"),
  ACCESS_DENIED(1004, "ACCESS_DENIED"),
  INVALID_PARAM(1005, "INVALID_PARAM"),
  INVALID_TOKEN(1006, "INVALID_TOKEN")
  ;
  private final String message;
  private final int code;

  ErrorType(int code, String message){
    this.code = code;
    this.message = message;
  }

  public String getMessage(){
    return this.message;
  }

}
