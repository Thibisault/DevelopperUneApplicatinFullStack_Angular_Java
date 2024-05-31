// path: back/src/main/java/com/openclassrooms/mddapi/controller/DBUserController.java
package com.openclassrooms.mddapi.controller;

import com.openclassrooms.mddapi.dto.DBUserDTO;
import com.openclassrooms.mddapi.model.DBUser;
import com.openclassrooms.mddapi.model.Theme;
import com.openclassrooms.mddapi.repository.ThemeRepository;
import com.openclassrooms.mddapi.security.service.JWTService;
import com.openclassrooms.mddapi.services.AuthService;
import com.openclassrooms.mddapi.services.DBUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/DBUser")
public class DBUserController {

    private final DBUserService service;

    @Autowired
    ThemeRepository themeRepository;
    @Autowired
    AuthService authService;
    @Autowired
    JWTService jwtService;

    public DBUserController(DBUserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DBUserDTO> create(@RequestBody DBUserDTO dbUserDTO) {
        DBUserDTO created = service.create(dbUserDTO);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DBUserDTO> read(@PathVariable Integer id) {
        return service.read(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<DBUserDTO>> readAll() {
        List<DBUserDTO> dbUsers = service.readAll();
        return ResponseEntity.ok(dbUsers);
    }

    @PutMapping
    public ResponseEntity<DBUserDTO> update(@RequestBody DBUserDTO dbUserDTO) {
        DBUserDTO updated = service.update(dbUserDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/me")
    public ResponseEntity<DBUserDTO> getCurrentUser(Principal principal) {
        Optional<DBUserDTO> dbUserDTO = service.readByUsername(principal.getName());
        return service.readByUsername(principal.getName())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/me")
    public ResponseEntity<Map<String, String>> updateCurrentUser(@RequestBody DBUserDTO dbUserDTO, Principal principal) {
        System.out.println("principal.getName() = " + principal.getName());
        System.out.println("dbUserDTO = " + dbUserDTO);
        DBUserDTO updated = service.updateUserProfile(dbUserDTO, principal.getName());
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        String newToken = authService.generateTokenForUpdatedUser(updated.getUsername());
        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("token", newToken);
        return ResponseEntity.ok(response);
    }

}
