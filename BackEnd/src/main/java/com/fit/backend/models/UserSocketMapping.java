package com.fit.backend.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "user_socket_mapping")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserSocketMapping {

    @Id
    private String id;

    private String userId; // ID người dùng
    private String socketId; // ID kết nối WebSocket
    private Date connectedAt; // Thời gian kết nối

}
