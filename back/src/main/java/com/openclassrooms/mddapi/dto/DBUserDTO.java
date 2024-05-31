//path: src/main/java/com/openclassrooms/mddapi/dto/DBUserDTO.java
package com.openclassrooms.mddapi.dto;

import com.openclassrooms.mddapi.model.Theme;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DBUserDTO {
    private Integer id;
    private String username;
    private String password;
    private String role;
    private List<Theme> subscribedThemes = new ArrayList<>();
}
