package com.emart2.redirect.website.exception;

import com.emart2.redirect.common.exception.CommonException;
import com.emart2.redirect.type.ErrorType;

public class CategoryNotFoundException extends CommonException {

  public CategoryNotFoundException() {
    super("id에 해당하는 카테고리가 없습니다.", ErrorType.NOT_FOUND);
  }
}
