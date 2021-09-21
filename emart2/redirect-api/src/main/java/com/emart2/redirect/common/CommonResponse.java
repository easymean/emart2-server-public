package com.emart2.redirect.common;

import com.emart2.redirect.type.ErrorType;
import lombok.Getter;

@Getter
public class CommonResponse<T> {
  private final String message;
  private final T data;
  private final ErrorType errorType;


  public CommonResponse(String message, T data, ErrorType errorType) {
    this.message = message;
    this.data = data;
    this.errorType = errorType;
  }

  public static <T> CommonResponse<T> ok(String message, T data) {
    return new CommonResponse<>(message, data, null);
  }

  public static <T> CommonResponse<T> ok(T data) {
    return new CommonResponse<>("", data, null);
  }

  public static <T> CommonResponse<T> fail(String message, ErrorType err) {
    return new CommonResponse<>(message, null, err);
  }

  public static CommonResponse<Void> ok() {
    return new CommonResponse<>(null, null, null);
  }


}
