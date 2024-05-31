//path: src/main/java/com/openclassrooms/mddapi/dto/ArticleDto.java
package com.openclassrooms.mddapi.dto;

import com.openclassrooms.mddapi.model.Comment;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class ArticleDto {

    private Integer id;
    private String title;
    private String content;
    private Date publicationDate;
    private String author;

    private List<Comment> comments = new ArrayList<>();

}
