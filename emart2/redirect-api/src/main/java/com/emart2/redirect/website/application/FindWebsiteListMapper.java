package com.emart2.redirect.website.application;

import com.emart2.redirect.common.CommonMapper;
import com.emart2.redirect.website.dto.WebsiteListDto;
import com.emart2.redirect.website.entity.WebsiteEntity;

import java.util.List;


public interface FindWebsiteListMapper extends CommonMapper {
  List<WebsiteListDto.Response> toDto(List<WebsiteEntity> list);
}
