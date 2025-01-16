package com.fit.backend.controllers;

import com.fit.backend.models.User;
import com.fit.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user); // Tạo mới User
    }

    @GetMapping("/get/{email}")
    public User getUserByEmail(@PathVariable String name) {
        return userService.findByUserName(name); // Lấy User theo email
    }
}
