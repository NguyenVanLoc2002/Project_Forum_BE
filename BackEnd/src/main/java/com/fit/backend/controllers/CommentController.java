package com.fit.backend.controllers;

import com.fit.backend.models.Comment;
import com.fit.backend.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/create")
    public Comment createComment(@RequestBody Comment comment) {
        return commentService.saveComment(comment); // Tạo mới Comment
    }

    @GetMapping("/{id}")
    public Comment getComment(@PathVariable String id) {
        return commentService.getCommentById(id); // Lấy Comment theo ID
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable String id) {
        commentService.deleteComment(id); // Xóa Comment theo ID
    }


}
