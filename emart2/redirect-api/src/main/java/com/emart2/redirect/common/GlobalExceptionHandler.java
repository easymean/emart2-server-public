package com.emart2.redirect.common;

import com.emart2.redirect.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public CommonResponse<Object> handleException(NotFoundException ex) {
    logger.error(ex.getMessage());
    return CommonResponse.fail(ex.getMessage());
  }

  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public CommonResponse<Object> handleException(IllegalArgumentException ex) {
    logger.error(ex.getMessage());
    return CommonResponse.fail(ex.getMessage());
  }
}
