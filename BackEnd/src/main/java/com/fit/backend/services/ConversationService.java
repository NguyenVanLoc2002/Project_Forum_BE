package com.fit.backend.services;

import com.fit.backend.models.Conversation;
import com.fit.backend.repositories.ConversationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversationService {
    @Autowired
    private ConversationRepository ConversationRepository;

    public Conversation saveConversation(Conversation Conversation) {
        return ConversationRepository.save(Conversation); // Lưu Conversation vào MongoDB
    }

    public Conversation getConversationById(String id) {
        return ConversationRepository.findById(id).orElse(null); // Lấy Conversation theo ID
    }

    public void deleteConversation(String id) {
        ConversationRepository.deleteById(id); // Xóa Conversation theo ID
    }
}
