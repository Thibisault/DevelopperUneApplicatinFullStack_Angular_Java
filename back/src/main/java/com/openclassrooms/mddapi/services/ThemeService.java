// path: src/main/java/com/openclassrooms/mddapi/services/ThemeService.java
package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.dto.ThemeDto;
import com.openclassrooms.mddapi.dto.ThemeMapper;
import com.openclassrooms.mddapi.model.Article;
import com.openclassrooms.mddapi.model.DBUser;
import com.openclassrooms.mddapi.model.Theme;
import com.openclassrooms.mddapi.repository.ArticleRepository;
import com.openclassrooms.mddapi.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThemeService {

    private final ThemeRepository themeRepository;
    private final ThemeMapper themeMapper;

    @Autowired
    private ArticleRepository articleRepository;

    public ThemeService(ThemeRepository themeRepository, ThemeMapper themeMapper) {
        this.themeRepository = themeRepository;
        this.themeMapper = themeMapper;
    }

    public List<ThemeDto> getAllThemes() {
        List<Theme> themes = themeRepository.findAll();
        return themeMapper.toDtoList(themes);
    }

    public ThemeDto getThemeById(Integer id) {
        Optional<Theme> theme = themeRepository.findById(id);
        return theme.map(themeMapper::toDto).orElse(null);
    }

    public ThemeDto createTheme(ThemeDto themeDto) {
        Theme theme = themeMapper.toEntity(themeDto);
        Theme savedTheme = themeRepository.save(theme);
        return themeMapper.toDto(savedTheme);
    }

    public ThemeDto updateTheme(Integer id, ThemeDto themeDto) {
        Optional<Theme> optionalTheme = themeRepository.findById(id);
        if (optionalTheme.isPresent()) {
            Theme themeToUpdate = optionalTheme.get();
            themeToUpdate.setName(themeDto.getName());
            themeToUpdate.setDescription(themeDto.getDescription());
            Theme updatedTheme = themeRepository.save(themeToUpdate);
            return themeMapper.toDto(updatedTheme);
        }
        return null;
    }

    public void deleteTheme(Integer id) {
        themeRepository.deleteById(id);
    }

    // s'abonner à un thème
    public void subscribeToTheme(Integer themeId, DBUser dbUser) {
        // Logique pour abonner l'utilisateur au thème
    }

    // se désabonner d'un thème
    public void unsubscribeFromTheme(Integer themeId, String username) {
        // Logique pour désabonner l'utilisateur du thème
    }

    public void addArticleToTheme(Integer themeId, Integer articleId) {
        Theme theme = themeRepository.findById(themeId).orElseThrow((null));
        Article article = articleRepository.findById(articleId).orElseThrow((null));
        theme.getArticles().add(article);
        themeRepository.save(theme);
    }
}