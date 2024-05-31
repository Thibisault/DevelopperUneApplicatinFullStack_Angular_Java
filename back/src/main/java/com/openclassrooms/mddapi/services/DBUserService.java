// path: back/src/main/java/com/openclassrooms/mddapi/services/DBUserService.java
package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.dto.DBUserDTO;
import com.openclassrooms.mddapi.dto.DBUserMapper;
import com.openclassrooms.mddapi.dto.ThemeDto;
import com.openclassrooms.mddapi.model.Article;
import com.openclassrooms.mddapi.model.DBUser;
import com.openclassrooms.mddapi.model.Theme;
import com.openclassrooms.mddapi.repository.DBUserRepository;
import com.openclassrooms.mddapi.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.*;

@Service
public class DBUserService {

    private final DBUserRepository repository;
    private final DBUserMapper mapper;

    @Autowired
    private ThemeRepository themeRepository;
    @Autowired
    private ThemeService themeService;

    public DBUserService(DBUserRepository repository, DBUserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public DBUserDTO create(DBUserDTO dbUserDTO) {
        DBUser dbUser = mapper.toEntity(dbUserDTO);
        dbUser = repository.save(dbUser);
        return mapper.toDTO(dbUser);
    }

    public Optional<DBUserDTO> read(Integer id) {
        Optional<DBUser> dbUser = repository.findById(id);
        return dbUser.map(mapper::toDTO);
    }

    public List<DBUserDTO> readAll() {
        List<DBUser> dbUsers = repository.findAll();
        return mapper.toDTOList(dbUsers);
    }

    public Optional<DBUserDTO> readByUsername(String username) {
        DBUser dbUser = repository.findByUsername(username);
        return Optional.ofNullable(mapper.toDTO(dbUser));
    }

    public DBUserDTO update(DBUserDTO dbUserDTO) {
        DBUser dbUser = mapper.toEntity(dbUserDTO);
        dbUser = repository.save(dbUser);
        return mapper.toDTO(dbUser);
    }

    public DBUserDTO updateUserProfile(DBUserDTO dbUserDTO, String username) {
        DBUser existingUser = repository.findByUsername(username);
        if (existingUser != null) {
            existingUser.setUsername(dbUserDTO.getUsername());
            existingUser.setPassword(dbUserDTO.getPassword());
            existingUser.setRole(dbUserDTO.getRole());
            existingUser.setSubscribedThemes(dbUserDTO.getSubscribedThemes());
            DBUser updatedUser = repository.save(existingUser);
            return mapper.toDTO(updatedUser);
        }
        return null;
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public void subscribeToTheme(Integer themeId, String userName) {
        this.readByUsername(userName)
                .ifPresent(dbUserDTO -> {
                    Theme theme = themeRepository.findById(themeId).orElse(null);
                    if (theme != null) {
                        DBUser dbUser = mapper.toEntity(dbUserDTO);
                        if (dbUser.getSubscribedThemes() == null) {
                            dbUser.setSubscribedThemes(new ArrayList<>());
                        }
                        dbUser.getSubscribedThemes().add(theme);
                        repository.save(dbUser);
                    }
                });
    }

    public void unsubscribeFromTheme(Integer themeId, String username) {
        this.readByUsername(username)
                .ifPresent(dbUserDTO -> {
                    Theme theme = themeRepository.findById(themeId).orElse(null);
                    if (theme != null) {
                        DBUser dbUser = mapper.toEntity(dbUserDTO);
                        dbUser.getSubscribedThemes().remove(theme);
                        repository.save(dbUser);
                    }
                });
    }

    public Map<String, List<Article>> getListArticlesByThemeFromUser(Principal principal) {
        DBUser dbUser = repository.findByUsername(principal.getName());
        List<Theme> themes = dbUser.getSubscribedThemes();
        Map<String, List<Article>> articlesByTheme = new HashMap<>();

        for (Theme theme : themes) {
            articlesByTheme.put(theme.getName(), theme.getArticles());
        }

        return articlesByTheme;
    }

}
