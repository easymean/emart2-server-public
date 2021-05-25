package com.example.emart2.exception;

import com.example.emart2.common.CommonException;
import com.example.emart2.type.ErrorType;

public class NotFoundException extends CommonException {

  public NotFoundException(String message, ErrorType errorType) {
    super(message, errorType);
  }
}
