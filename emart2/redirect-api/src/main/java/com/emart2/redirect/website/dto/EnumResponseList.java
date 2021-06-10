package com.emart2.redirect.website.dto;

import com.emart2.redirect.common.EnumMapperValue;
import lombok.Getter;

import java.util.List;

@Getter
public class EnumResponseList {

  private List<EnumMapperValue> enumValueList;

  public EnumResponseList(List<EnumMapperValue> enumValueList) {
    this.enumValueList = enumValueList;
  }
}
