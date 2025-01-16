package com.fit.backend.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "sessions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Session {

    @Id
    private String id;

    private String userId; // ID người dùng
    private String deviceId; // Mã thiết bị
    private boolean isLoggedIn; // Trạng thái đăng nhập
    private String refreshToken; // Refresh token
    private Date loggedInAt; // Thời gian đăng nhập

}
