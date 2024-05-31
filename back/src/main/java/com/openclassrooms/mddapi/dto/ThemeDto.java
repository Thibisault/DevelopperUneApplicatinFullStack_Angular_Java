package com.openclassrooms.mddapi.dto;

import com.openclassrooms.mddapi.model.Article;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ThemeDto {
    private Integer id;
    private String name;
    private String description;

    @ManyToMany
    private List<Article> articles = new ArrayList<>();

}
