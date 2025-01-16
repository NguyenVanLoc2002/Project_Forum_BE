package com.fit.backend.controllers;

import com.fit.backend.models.UserSocketMapping;
import com.fit.backend.services.UserSocketMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-socket-mappings")
public class UserSocketMappingController {

    @Autowired
    private UserSocketMappingService userSocketMappingService;

    @PostMapping("/create")
    public UserSocketMapping createUserSocketMapping(@RequestBody UserSocketMapping userSocketMapping) {
        return userSocketMappingService.saveUserSocketMapping(userSocketMapping); // Tạo mới UserSocketMapping
    }

    @GetMapping("/{id}")
    public UserSocketMapping getUserSocketMapping(@PathVariable String id) {
        return userSocketMappingService.getUserSocketMappingById(id); // Lấy UserSocketMapping theo ID
    }

    @DeleteMapping("/{id}")
    public void deleteUserSocketMapping(@PathVariable String id) {
        userSocketMappingService.deleteUserSocketMapping(id); // Xóa UserSocketMapping theo ID
    }

}
