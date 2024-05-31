// path: src/main/java/com/openclassrooms/mddapi/dto/CommentDto.java
package com.openclassrooms.mddapi.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CommentDto {
    private Integer id;
    private String content;
    private String author;
    private Date createdDate;
}
