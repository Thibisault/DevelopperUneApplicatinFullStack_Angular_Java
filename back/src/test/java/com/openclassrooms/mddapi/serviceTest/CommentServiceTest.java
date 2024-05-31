/*
package com.openclassrooms.mddapi.serviceTest;

import com.openclassrooms.mddapi.dto.ArticleDto;
import com.openclassrooms.mddapi.dto.CommentDto;
import com.openclassrooms.mddapi.services.ArticleService;
import com.openclassrooms.mddapi.services.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class CommentServiceTest {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ArticleService articleService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testCreateComment() {
        ArticleDto articleDto = new ArticleDto();
        articleDto.setId(1);
        articleDto.setTitle("First Article my guys");
        articleDto.setContent("Content of the first article");
        //articleDto.setPublicationDate("2024-05-20");
        articleDto.setAuthor("John Doe");
        //ArticleDto savedArticle = articleService.createArticle(articleDto);

        CommentDto commentDto = new CommentDto();
        commentDto.setId(1);
        commentDto.setContent("This is a comment");
        commentDto.setCreatedDate(new Date());
        commentDto.setAuthor("Jane Doe");
        //commentDto.setArticleId(savedArticle.getId());

        commentService.createComment(commentDto);

        CommentDto comment = commentService.getCommentByContent("This is a comment");
        System.out.println(comment);

        List<CommentDto> commentDtoList = commentService.getAllComments();
        System.out.println(commentDtoList);
        System.out.println(commentDtoList.size());
    }
}
*/