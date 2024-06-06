// path: back/src/main/java/com/openclassrooms/mddapi/model/DBUser.java
package com.openclassrooms.mddapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "dbuser", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class DBUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToMany
    private List<Theme> subscribedThemes = new ArrayList<>();

    @NotBlank(message = "Username cannot be empty")
    private String username;

    // Salut ma petite maison qui est dans la prairie; je suis un commentaire
    // tu as entendu parler de Natacha ?

    @NotBlank(message = "Password cannot be empty")
    private String password;

    private String role;
}
