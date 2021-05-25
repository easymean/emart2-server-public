package com.example.emart2.common;

import com.example.emart2.type.ErrorType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class CommonException extends RuntimeException{
  @Enumerated(value = EnumType.STRING)
  private ErrorType errorType;

  public CommonException(String message, ErrorType errorType){
    super(message);
    this.errorType = errorType;
  }

  public String getErrorCode(){
    return errorType.getMessage();
  }
}
