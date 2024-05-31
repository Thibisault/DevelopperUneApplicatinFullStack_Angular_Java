// path: back/src/main/java/com/openclassrooms/mddapi/dto/ArticleMapper.java
package com.openclassrooms.mddapi.dto;

import com.openclassrooms.mddapi.model.Article;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArticleMapper {

    ArticleMapper INSTANCE = Mappers.getMapper(ArticleMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "content", target = "content")
    @Mapping(source = "publicationDate", target = "publicationDate")
    @Mapping(source = "author", target = "author")
    ArticleDto toDto(Article article);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "content", target = "content")
    @Mapping(source = "publicationDate", target = "publicationDate")
    @Mapping(source = "author", target = "author")
    Article toEntity(ArticleDto dto);

    List<ArticleDto> toDtoList(List<Article> articles);

    List<Article> toEntityList(List<ArticleDto> dtos);
}