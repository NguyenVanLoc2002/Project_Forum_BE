package com.fit.backend.controllers;

import com.fit.backend.models.Conversation;
import com.fit.backend.services.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/conversations")
public class ConversationController {

    @Autowired
    private ConversationService conversationService;

    // Endpoint để lưu Conversation mới
    @PostMapping
    public ResponseEntity<Conversation> createConversation(@RequestBody Conversation conversation) {
        Conversation savedConversation = conversationService.saveConversation(conversation);
        return ResponseEntity.ok(savedConversation); // Trả về Conversation sau khi lưu
    }

    // Endpoint để lấy Conversation theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Conversation> getConversationById(@PathVariable String id) {
        Optional<Conversation> conversation = Optional.ofNullable(conversationService.getConversationById(id));

        if (conversation.isPresent()) {
            return ResponseEntity.ok(conversation.get()); // Trả về Conversation nếu tìm thấy
        } else {
            return ResponseEntity.notFound().build(); // Trả về 404 nếu không tìm thấy Conversation
        }
    }

    // Endpoint để xóa Conversation theo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConversation(@PathVariable String id) {
        conversationService.deleteConversation(id);
        return ResponseEntity.noContent().build(); // Trả về 204 nếu xóa thành công
    }
}
