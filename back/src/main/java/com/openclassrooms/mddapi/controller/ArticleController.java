// path: src/main/java/com/openclassrooms/mddapi/controller/ArticleController.java
package com.openclassrooms.mddapi.controller;

import com.openclassrooms.mddapi.dto.ArticleDto;
import com.openclassrooms.mddapi.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping
    public List<ArticleDto> getAllArticles() {
        return articleService.getAllArticles();
    }

    @GetMapping("/{id}")
    public ArticleDto getArticleById(@PathVariable Integer id) {
        return articleService.getArticleById(id);
    }

    @PostMapping
    public ArticleDto createArticle(@RequestBody ArticleDto articleDto, Principal principal) {
        ArticleDto savedArticle = articleService.createArticle(articleDto, principal);
        System.out.println("Date de l'article renvoyé: " + savedArticle.getPublicationDate());
        return savedArticle;
    }
    @PutMapping("/{id}")
    public ArticleDto updateArticle(@PathVariable Integer id, @RequestBody ArticleDto articleDto) {
        return articleService.updateArticle(id, articleDto);
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable Integer id) {
        articleService.deleteArticle(id);
    }

    @PostMapping("/addCommentToArticle")
    public ResponseEntity<?> addArticleToTheme(@RequestBody Map<String, Integer> payload) {
        Integer articleId = payload.get("articleId");
        Integer commentId = payload.get("commentId");
        articleService.addCommentToArticle(articleId, commentId);
        return ResponseEntity.ok().build();
    }
}