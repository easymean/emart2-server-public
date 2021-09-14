package com.emart2.redirect.user.exception;

import com.emart2.redirect.common.exception.CommonException;
import com.emart2.redirect.type.ErrorType;

public class UserNotFoundException extends CommonException {

  public UserNotFoundException() {
    super("id에 해당하는 유저가 없습니다.", ErrorType.NOT_FOUND);
  }
}
