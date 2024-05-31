package com.openclassrooms.mddapi.controller;

import com.openclassrooms.mddapi.model.Article;
import com.openclassrooms.mddapi.services.DBUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/feed")
public class FeedController {

    @Autowired
    private DBUserService dbUserService;


    @GetMapping("/all")
    public Map<String, List<Article>> getAllArticlesFromThemeSuscribed(Principal principal) {
        return dbUserService.getListArticlesByThemeFromUser(principal);
    }

}
