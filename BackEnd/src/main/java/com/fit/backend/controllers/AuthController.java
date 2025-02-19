package com.fit.backend.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fit.backend.dtos.UserRegistrationDTO;
import com.fit.backend.models.User;
import com.fit.backend.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserRegistrationDTO dto) {
        try {
            String response = authService.register(dto);
            return ResponseEntity.ok(response);
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(500).body("Lỗi khi xử lý đăng ký: " + e.getMessage());
        }
    }

    @GetMapping("/verify")
    public ResponseEntity<String> verify(@RequestParam String token) {
        try {
            String response = authService.verifyAccount(token);
            return ResponseEntity.ok("Chuyển hướng đến trang cập nhật mật khẩu");
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(500).body("Lỗi khi xác thực tài khoản: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PostMapping("/update-password")
    public ResponseEntity<User> updatePassword(@RequestParam String token, @RequestBody String password) {
        try {
            User user = authService.updatePassword(token, password);
            return ResponseEntity.ok(user);
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(500).body(null);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(400).body(null);
        }
    }
}
