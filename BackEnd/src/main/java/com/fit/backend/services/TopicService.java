package com.fit.backend.services;

import com.fit.backend.models.Topic;
import com.fit.backend.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    public Topic saveTopic(Topic topic) {
        return topicRepository.save(topic); // Lưu Topic vào MongoDB
    }

    public Topic getTopicById(String id) {
        return topicRepository.findById(id).orElse(null); // Lấy Topic theo ID
    }

    public void deleteTopic(String id) {
        topicRepository.deleteById(id); // Xóa Topic theo ID
    }
}
