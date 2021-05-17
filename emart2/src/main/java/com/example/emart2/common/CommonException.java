package com.example.emart2.common;

import com.example.emart2.type.ErrorCode;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class CommonException extends RuntimeException{
  @Enumerated(value = EnumType.STRING)
  private ErrorCode errorCode;

  public CommonException(String message, ErrorCode errorCode){
    super(message);
    this.errorCode = errorCode;
  }

  public String getErrorCode(){
    return errorCode.getMessage();
  }
}
