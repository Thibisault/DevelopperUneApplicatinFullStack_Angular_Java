//path: src/main/java/com/openclassrooms/mddapi/model/Article.java
package com.openclassrooms.mddapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @Lob // Permet de stocker de longs textes sans limite de taille
    private String content;

    private Date publicationDate;
    private String author;

    @ManyToMany
    private List<Comment> comments = new ArrayList<>();
}
