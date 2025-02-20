package com.fit.backend.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fit.backend.dtos.UserRegistrationDTO;
import com.fit.backend.models.User;
import com.fit.backend.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

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
    public RedirectView verify(@RequestParam String token) {
        try {
            authService.verifyAccount(token); // Xác thực tài khoản

            // Chuyển hướng về trang chủ + báo hiệu mở modal đổi mật khẩu
            return new RedirectView("http://localhost:3000/?openChangePassword=true&token=" + token);
        } catch (JsonProcessingException e) {
            return new RedirectView("http://localhost:3000/error?message=Lỗi khi xác thực tài khoản");
        } catch (IllegalArgumentException e) {
            return new RedirectView("http://localhost:3000/error?message=" + e.getMessage());
        }
    }

    @PostMapping("/update-password")
    public ResponseEntity<User> updatePassword(@RequestParam String resetToken, @RequestBody String password) {
        try {
            User user = authService.updatePassword(resetToken, password);
            return ResponseEntity.ok(user);
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(500).body(null);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(400).body(null);
        }
    }
}
