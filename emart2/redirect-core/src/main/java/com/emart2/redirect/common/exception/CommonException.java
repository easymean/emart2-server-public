package com.emart2.redirect.common.exception;

import com.emart2.redirect.type.ErrorType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class CommonException extends RuntimeException {
  @Enumerated(value = EnumType.STRING)
  private final ErrorType errorType;

  public CommonException(String message, ErrorType errorType) {
    super(message);
    this.errorType = errorType;
  }

  public String getErrorCode() {
    return errorType.getMessage();
  }
  public ErrorType getErrorType() { return this.errorType;}
}
