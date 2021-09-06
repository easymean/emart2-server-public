package com.emart2.redirect.exception;

import com.emart2.redirect.common.CommonException;
import com.emart2.redirect.type.ErrorType;

public class TokenException extends CommonException {
  public TokenException(String message, ErrorType errorType) {
    super(message, errorType);
  }
}
