package com.emart2.redirect.website.exception;

import com.emart2.redirect.common.exception.CommonException;
import com.emart2.redirect.type.ErrorType;

public class SiteNotFoundException extends CommonException {

  public SiteNotFoundException() {
    super("id에 해당하는 페이지가 없습니다.", ErrorType.NOT_FOUND);
  }
}
