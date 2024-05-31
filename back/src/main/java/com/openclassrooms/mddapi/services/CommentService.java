package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.dto.CommentDto;
import com.openclassrooms.mddapi.dto.CommentMapper;
import com.openclassrooms.mddapi.model.Comment;
import com.openclassrooms.mddapi.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public CommentService(CommentRepository commentRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    public List<CommentDto> getAllComments() {
        List<Comment> comments = commentRepository.findAll();
        return commentMapper.toDtoList(comments);
    }

    public CommentDto getCommentById(Integer id) {
        Optional<Comment> comment = commentRepository.findById(id);
        return comment.map(commentMapper::toDto).orElse(null);
    }

    public CommentDto getCommentByContent(String content) {
        Optional<Comment> comment = commentRepository.findByContent(content);
        return comment.map(commentMapper::toDto).orElse(null);
    }

    public CommentDto createComment(CommentDto commentDto, Principal principal) {
        if (commentDto.getCreatedDate() == null) {
            commentDto.setCreatedDate(Date.from(Instant.now()));
        }
        commentDto.setAuthor(principal.getName());
        Comment comment = commentMapper.toEntity(commentDto);
        Comment savedComment = commentRepository.save(comment);
        return commentMapper.toDto(savedComment);
    }


    public CommentDto updateComment(Integer id, CommentDto commentDto) {
        Optional<Comment> optionalComment = commentRepository.findById(id);
        if (optionalComment.isPresent()) {
            Comment commentToUpdate = optionalComment.get();
            commentToUpdate.setContent(commentDto.getContent());
            commentToUpdate.setAuthor(commentDto.getAuthor());
            commentToUpdate.setCreatedDate(commentDto.getCreatedDate());
            Comment updatedComment = commentRepository.save(commentToUpdate);
            return commentMapper.toDto(updatedComment);
        }
        return null;
    }

    public void deleteComment(Integer id) {
        commentRepository.deleteById(id);
    }
}
