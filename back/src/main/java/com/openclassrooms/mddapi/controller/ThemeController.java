// path: src/main/java/com/openclassrooms/mddapi/controller/ThemeController.java
package com.openclassrooms.mddapi.controller;

import com.openclassrooms.mddapi.dto.DBUserDTO;
import com.openclassrooms.mddapi.dto.ThemeDto;
import com.openclassrooms.mddapi.services.ArticleService;
import com.openclassrooms.mddapi.services.DBUserService;
import com.openclassrooms.mddapi.services.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/theme")
public class ThemeController {

    @Autowired
    private ThemeService themeService;

    @Autowired
    private DBUserService dbUserService;

    @Autowired
    private ArticleService articleService;


    @GetMapping
    public List<ThemeDto> getAllThemes() {
        return themeService.getAllThemes();
    }

    @GetMapping("/{id}")
    public ThemeDto getThemeById(@PathVariable Integer id) {
        return themeService.getThemeById(id);
    }

    @PostMapping
    public ThemeDto createTheme(@RequestBody ThemeDto themeDto) {
        return themeService.createTheme(themeDto);
    }

    @PutMapping("/{id}")
    public ThemeDto updateTheme(@PathVariable Integer id, @RequestBody ThemeDto themeDto) {
        return themeService.updateTheme(id, themeDto);
    }

    @DeleteMapping("/{id}")
    public void deleteTheme(@PathVariable Integer id) {
        themeService.deleteTheme(id);
    }

    @PostMapping("/subscribe/{id}")
    public ResponseEntity<DBUserDTO> subscribeToTheme(@PathVariable Integer id, Principal principal) {
        dbUserService.subscribeToTheme(id, principal.getName());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/unsubscribe/{id}")
    public ResponseEntity<?> unsubscribeFromTheme(@PathVariable Integer id, Principal principal) {
        dbUserService.unsubscribeFromTheme(id, principal.getName());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/addArticleToTheme")
    public ResponseEntity<?> addArticleToTheme(@RequestBody Map<String, Integer> payload) {
        Integer themeId = payload.get("themeId");
        Integer articleId = payload.get("articleId");
        themeService.addArticleToTheme(themeId, articleId);
        return ResponseEntity.ok().build();
    }

}

