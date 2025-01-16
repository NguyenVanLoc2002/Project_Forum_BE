package com.fit.backend.services;

import com.fit.backend.models.Session;
import com.fit.backend.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {
    @Autowired
    private SessionRepository sessionRepository;

    public Session saveSession(Session session) {
        return sessionRepository.save(session); // Lưu Session vào MongoDB
    }

    public Session getSessionById(String id) {
        return sessionRepository.findById(id).orElse(null); // Lấy Session theo ID
    }

    public void deleteSession(String id) {
        sessionRepository.deleteById(id); // Xóa Session theo ID
    }
}
