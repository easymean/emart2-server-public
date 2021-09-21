package com.emart2.redirect.auth.exception;

import com.emart2.redirect.common.exception.CommonException;
import com.emart2.redirect.type.ErrorType;

public class WrongPasswordException extends CommonException {
  public WrongPasswordException() {
    super("비밀번호가 틀렸습니다.", ErrorType.LOGIN_ERROR);
  }
}
