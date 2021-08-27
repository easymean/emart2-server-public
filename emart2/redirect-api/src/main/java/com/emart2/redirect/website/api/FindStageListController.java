package com.emart2.redirect.website.api;

import com.emart2.redirect.common.CommonResponse;
import com.emart2.redirect.website.application.mapper.EnumMapper;
import com.emart2.redirect.website.dto.EnumResponseList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindStageListController {
  private final EnumMapper enumMapper;

  public FindStageListController(EnumMapper enumMapper) {
    this.enumMapper = enumMapper;
  }

  @GetMapping("/v1/stages")
  public CommonResponse<EnumResponseList> getAllStage() {
    return CommonResponse.ok("success", new EnumResponseList(enumMapper.get("StageType")));
  }

}
