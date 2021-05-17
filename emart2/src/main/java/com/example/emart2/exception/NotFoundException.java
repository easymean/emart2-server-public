package com.example.emart2.exception;

import com.example.emart2.common.CommonException;
import com.example.emart2.type.ErrorCode;

public class NotFoundException extends CommonException {

  public NotFoundException(String message, ErrorCode errorCode) {
    super(message, errorCode);
  }
}
