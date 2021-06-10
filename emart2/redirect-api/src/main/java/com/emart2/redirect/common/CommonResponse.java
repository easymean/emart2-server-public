package com.emart2.redirect.common;

import lombok.Getter;

@Getter
public class CommonResponse<T> {
  private final String message;
  private final T data;

  public CommonResponse(String message, T data) {
    this.message = message;
    this.data = data;
  }

  public static <T> CommonResponse<T> ok(String message, T data) {
    return new CommonResponse<>(message, data);
  }

  public static <T> CommonResponse<T> ok(T data) {
    return new CommonResponse<>("", data);
  }

  public static <T> CommonResponse<T> fail(String message) {
    return new CommonResponse<>(message, null);
  }

  public static CommonResponse<Void> ok() {
    return new CommonResponse<>(null, null);
  }


}
