//path: back/src/main/java/com/openclassrooms/mddapi/controller/TestController.java
package com.openclassrooms.mddapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping
    public ResponseEntity<String> test() throws JsonProcessingException {
        String message = "Hello World!";
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(message);
        return ResponseEntity.ok().body(json);
    }

    @GetMapping("/1")
    public ResponseEntity<String> route1() throws JsonProcessingException {
        String message = "Response for route 1";
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(message);
        return ResponseEntity.ok().body(json);
    }

    @GetMapping("/2")
    public ResponseEntity<String> route2() throws JsonProcessingException {
        String message = "Response for route 2";
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(message);
        return ResponseEntity.ok().body(json);
    }
}