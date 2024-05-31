// path: src/main/java/com/openclassrooms/mddapi/controller/CommentController.java
package com.openclassrooms.mddapi.controller;

import com.openclassrooms.mddapi.dto.CommentDto;
import com.openclassrooms.mddapi.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public List<CommentDto> getAllComments() {
        return commentService.getAllComments();
    }

    @GetMapping("/{id}")
    public CommentDto getCommentById(@PathVariable Integer id) {
        return commentService.getCommentById(id);
    }

    @PostMapping
    public CommentDto createComment(@RequestBody CommentDto commentDto, Principal principal) {
        return commentService.createComment(commentDto, principal);
    }

    @PutMapping("/{id}")
    public CommentDto updateComment(@PathVariable Integer id, @RequestBody CommentDto commentDto) {
        return commentService.updateComment(id, commentDto);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Integer id) {
        commentService.deleteComment(id);
    }
}