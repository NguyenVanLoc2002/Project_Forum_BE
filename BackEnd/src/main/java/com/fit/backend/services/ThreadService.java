package com.fit.backend.services;

import com.fit.backend.models.Thread;
import com.fit.backend.repositories.ThreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThreadService {
    @Autowired
    private ThreadRepository threadRepository;

    public Thread saveThread(Thread thread) {
        return threadRepository.save(thread); // Lưu Thread vào MongoDB
    }

    public Thread getThreadById(String id) {
        return threadRepository.findById(id).orElse(null); // Lấy Thread theo ID
    }

    public void deleteThread(String id) {
        threadRepository.deleteById(id); // Xóa Thread theo ID
    }
}
