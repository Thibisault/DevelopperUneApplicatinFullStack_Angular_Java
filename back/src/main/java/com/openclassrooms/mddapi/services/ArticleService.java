// path: src/main/java/com/openclassrooms/mddapi/services/ArticleService.java
package com.openclassrooms.mddapi.services;

import java.time.Instant;

import com.openclassrooms.mddapi.dto.ArticleDto;
import com.openclassrooms.mddapi.dto.ArticleMapper;
import com.openclassrooms.mddapi.model.Article;
import com.openclassrooms.mddapi.model.Comment;
import com.openclassrooms.mddapi.model.Theme;
import com.openclassrooms.mddapi.repository.ArticleRepository;
import com.openclassrooms.mddapi.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper;

    @Autowired
    CommentRepository commentRepository;

    public ArticleService(ArticleRepository articleRepository, ArticleMapper articleMapper) {
        this.articleRepository = articleRepository;
        this.articleMapper = articleMapper;
    }

    public List<ArticleDto> getAllArticles() {
        List<Article> articles = articleRepository.findAll();
        return articleMapper.toDtoList(articles);
    }

    public ArticleDto getArticleById(Integer id) {
        Optional<Article> article = articleRepository.findById(id);
        return article.map(articleMapper::toDto).orElse(null);
    }

    public ArticleDto createArticle(ArticleDto articleDto, Principal principal) {
        if (articleDto.getPublicationDate() == null) {
            articleDto.setPublicationDate(Date.from(Instant.now()));
        }
        articleDto.setAuthor(principal.getName());
        Article article = articleMapper.toEntity(articleDto);
        Article savedArticle = articleRepository.save(article);
        return articleMapper.toDto(savedArticle);
    }

    public ArticleDto updateArticle(Integer id, ArticleDto articleDto) {
        Optional<Article> optionalArticle = articleRepository.findById(id);
        if (optionalArticle.isPresent()) {
            Article articleToUpdate = optionalArticle.get();
            articleToUpdate.setTitle(articleDto.getTitle());
            articleToUpdate.setContent(articleDto.getContent());
            articleToUpdate.setPublicationDate(articleDto.getPublicationDate());
            articleToUpdate.setAuthor(articleDto.getAuthor());
            Article updatedArticle = articleRepository.save(articleToUpdate);
            return articleMapper.toDto(updatedArticle);
        }
        return null;
    }

    public void deleteArticle(Integer id) {
        articleRepository.deleteById(id);
    }

    public void addCommentToArticle(Integer articleId, Integer commentId) {
        Article article = articleRepository.findById(articleId).orElseThrow((null));
        Comment comment = commentRepository.findById(commentId).orElseThrow((null));
        article.getComments().add(comment);
        articleRepository.save(article);
    }
}