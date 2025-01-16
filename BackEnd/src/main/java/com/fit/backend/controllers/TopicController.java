package com.fit.backend.controllers;

import com.fit.backend.models.Topic;
import com.fit.backend.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @PostMapping("/create")
    public Topic createTopic(@RequestBody Topic topic) {
        return topicService.saveTopic(topic); // Tạo mới Topic
    }

    @GetMapping("/{id}")
    public Topic getTopic(@PathVariable String id) {
        return topicService.getTopicById(id); // Lấy Topic theo ID
    }

    @DeleteMapping("/{id}")
    public void deleteTopic(@PathVariable String id) {
        topicService.deleteTopic(id); // Xóa Topic theo ID
    }
}
