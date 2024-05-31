package com.openclassrooms.mddapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Lob // Permet de stocker de longs textes sans limite de taille
    private String content;

    private String author;
    private Date createdDate;

}
