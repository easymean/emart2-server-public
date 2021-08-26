package com.emart2.redirect.website.application;

import com.emart2.redirect.common.CommonMapper;
import com.emart2.redirect.website.dto.ManageWebsiteDto;
import com.emart2.redirect.website.entity.WebsiteEntity;


public interface ManageWebsiteMapper extends CommonMapper {

  WebsiteEntity toEntity(ManageWebsiteDto.Create dto);

  WebsiteEntity toEntity(ManageWebsiteDto.Update dto);

  ManageWebsiteDto.Response toDto(WebsiteEntity category);
}
