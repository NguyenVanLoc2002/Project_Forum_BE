package com.fit.backend.controllers;

import com.fit.backend.models.Session;
import com.fit.backend.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sessions")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @PostMapping("/create")
    public Session createSession(@RequestBody Session session) {
        return sessionService.saveSession(session); // Tạo mới Session
    }

    @GetMapping("/{id}")
    public Session getSession(@PathVariable String id) {
        return sessionService.getSessionById(id); // Lấy Session theo ID
    }

    @DeleteMapping("/{id}")
    public void deleteSession(@PathVariable String id) {
        sessionService.deleteSession(id); // Xóa Session theo ID
    }

}
