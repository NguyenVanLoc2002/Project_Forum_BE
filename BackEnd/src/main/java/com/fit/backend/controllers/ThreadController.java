package com.fit.backend.controllers;

import com.fit.backend.models.Thread;
import com.fit.backend.services.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/threads")
public class ThreadController {

    @Autowired
    private ThreadService threadService;

    @PostMapping("/create")
    public Thread createThread(@RequestBody Thread thread) {
        return threadService.saveThread(thread); // Tạo mới Thread
    }

    @GetMapping("/{id}")
    public Thread getThread(@PathVariable String id) {
        return threadService.getThreadById(id); // Lấy Thread theo ID
    }

    @DeleteMapping("/{id}")
    public void deleteThread(@PathVariable String id) {
        threadService.deleteThread(id); // Xóa Thread theo ID
    }

}
