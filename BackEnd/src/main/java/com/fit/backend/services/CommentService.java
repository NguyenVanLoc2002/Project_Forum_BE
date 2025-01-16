package com.fit.backend.services;

import com.fit.backend.models.Comment;
import com.fit.backend.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment); // Lưu Comment vào MongoDB
    }

    public Comment getCommentById(String id) {
        return commentRepository.findById(id).orElse(null); // Lấy Comment theo ID
    }

    public void deleteComment(String id) {
        commentRepository.deleteById(id); // Xóa Comment theo ID
    }
}
