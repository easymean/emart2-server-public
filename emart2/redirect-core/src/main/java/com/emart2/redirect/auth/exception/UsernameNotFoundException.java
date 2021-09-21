package com.emart2.redirect.auth.exception;

import com.emart2.redirect.common.exception.CommonException;
import com.emart2.redirect.type.ErrorType;

public class UsernameNotFoundException extends CommonException {
  public UsernameNotFoundException() {
    super("username에 해당하는 유저가 존재하지 않습니다.", ErrorType.LOGIN_ERROR);
  }
}
