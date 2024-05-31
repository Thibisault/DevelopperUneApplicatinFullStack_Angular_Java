/*
package com.openclassrooms.mddapi.serviceTest;

import com.openclassrooms.mddapi.dto.ArticleDto;
import com.openclassrooms.mddapi.model.Article;
import com.openclassrooms.mddapi.services.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ArticleServiceTest {

    @Autowired
    private ArticleService articleService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testCreateArticle() {
        ArticleDto articleDto = new ArticleDto();
        articleDto.setId(1);
        articleDto.setTitle("title");
        articleDto.setContent("content");
        //articleDto.setPublicationDate("publicationDate");
        articleDto.setAuthor("author");
        //articleService.createArticle(articleDto);
        ArticleDto article = articleService.getArticleById(1);
        System.out.println(article);

        List<ArticleDto> articleDtoList = articleService.getAllArticles();
        System.out.println(articleDtoList);
        System.out.println(articleDtoList.size());
    }

    @Test
    public void testGetAllArticles() {
        List<ArticleDto> articleDtoList = articleService.getAllArticles();
        System.out.println(articleDtoList);
        System.out.println(articleDtoList.size());
    }
}
 */
