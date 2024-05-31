// path: src/main/java/com/openclassrooms/mddapi/dto/CommentMapper.java
package com.openclassrooms.mddapi.dto;

import com.openclassrooms.mddapi.model.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "content", target = "content")
    @Mapping(source = "author", target = "author")
    @Mapping(source = "createdDate", target = "createdDate")
    CommentDto toDto(Comment comment);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "content", target = "content")
    @Mapping(source = "author", target = "author")
    @Mapping(source = "createdDate", target = "createdDate")
    Comment toEntity(CommentDto dto);

    List<CommentDto> toDtoList(List<Comment> comments);

    List<Comment> toEntityList(List<CommentDto> dtos);

}