package com.fit.backend.services;

import com.fit.backend.dtos.UserRegistrationDTO;
import com.fit.backend.models.Email;
import com.fit.backend.utils.JwtUtil;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    @Qualifier("webApplicationContext")
    private ResourceLoader resourceLoader;

    @Autowired
    private JwtUtil jwtUtils;

    @Value("${spring.mail.username}")
    private String sender;

    public void sendVerificationEmail(UserRegistrationDTO userRegistrationDTO, String token) {
        try {
            // Tải mẫu HTML và thay thế nội dung động
            String htmlContent = loadVerifyEmailTemplate();
            htmlContent = htmlContent.replace("${username}", userRegistrationDTO.getUsername());
            htmlContent = htmlContent.replace("${email}", userRegistrationDTO.getEmail());
            htmlContent = htmlContent.replace("${verificationLink}", token);

            // Tạo đối tượng Email và gửi
            Email emailDetails = new Email(userRegistrationDTO.getEmail(), htmlContent, "Xác nhận đặt tour", "");
            sendVerifyEmail(emailDetails);
        } catch (Exception e) {
            log.error("Lỗi khi gửi email xác thực: {}", e.getMessage());
            throw new RuntimeException("Lỗi khi gửi email xác thực", e);
        }
    }

    public void sendVerifyEmail(Email email) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setFrom(sender);
            helper.setTo(email.getRecipient());
            helper.setText(email.getMsgBody(), true);
            helper.setSubject(email.getSubject());

            mailSender.send(mimeMessage);
        } catch (Exception e) {
            log.error("Lỗi khi gửi email: {}", e.getMessage());
            throw new RuntimeException("Lỗi khi gửi email", e);
        }
    }

    public String loadVerifyEmailTemplate() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:templates/VerifyEmail.html");
        return StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
    }
}
