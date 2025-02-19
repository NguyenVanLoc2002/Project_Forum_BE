package com.fit.backend.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fit.backend.dtos.UserRegistrationDTO;
import com.fit.backend.enums.Gender;
import com.fit.backend.models.User;
import com.fit.backend.repositories.UserRepository;
import com.fit.backend.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private EmailService mailService;

    @Autowired
    private UserRepository userRepository;

    public String register(UserRegistrationDTO dto) throws JsonProcessingException {
        // Tạo JWT chứa thông tin người dùng
        String token = jwtUtil.generateVerificationToken(dto);

        // Gửi email xác thực
        mailService.sendVerificationEmail(dto, token);
        return "Vui lòng kiểm tra email để xác thực tài khoản.";
    }

    public String verifyAccount(String token) throws JsonProcessingException {
        if (jwtUtil.isTokenExpired(token)) {
            throw new IllegalArgumentException("Token đã hết hạn");
        }

        UserRegistrationDTO dto = jwtUtil.extractUserInfo(token);
        if (dto != null) {
            return "Xác thực thành công. Vui lòng cập nhật mật khẩu.";
        }
        throw new IllegalArgumentException("Token không hợp lệ");
    }

    public User updatePassword(String token, String password) throws JsonProcessingException {
        UserRegistrationDTO dto = jwtUtil.extractUserInfo(token);
        if (dto == null) {
            throw new IllegalArgumentException("Token không hợp lệ");
        }

        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setDayOfBirth(dto.getDayOfBirth());
        user.setGender(Gender.valueOf(dto.getGender().toUpperCase())); // Chắc chắn đúng enum
        user.setActive(true);
        user.setCreatedAt(new Date());

        return userRepository.save(user);
    }
}
