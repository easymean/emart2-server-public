package com.emart2.redirect.auth.exception;

import com.emart2.redirect.common.exception.CommonException;
import com.emart2.redirect.type.ErrorType;

public class UserAlreadyExistException extends CommonException {
  public UserAlreadyExistException() {
    super("이미 사용중인 아이디 입니다.", ErrorType.LOGIN_ERROR);
  }
}
