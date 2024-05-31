//path: back/src/main/java/com/openclassrooms/mddapi/dto/AuthRequest.java
package com.openclassrooms.mddapi.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}
