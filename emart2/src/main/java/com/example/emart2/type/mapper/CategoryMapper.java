package com.example.emart2.type.mapper;

import com.example.emart2.common.GenericMapper;
import com.example.emart2.dto.CategoryDto;
import com.example.emart2.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends GenericMapper<CategoryDto.Request, CategoryDto.Response, Category> {

  CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

  @Mapping(target="id", constant = "0L")
  Category toEntity(CategoryDto.Request categoryDto);

  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "updatedAt", ignore = true)
  @Mapping(target = "isActive", ignore = true)
  CategoryDto.Response toDto(Category category);
}
