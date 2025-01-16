package com.fit.backend.models;

import com.fit.backend.enums.MessageType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "conversations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Conversation {

    @Id
    private String id; // Id của cuộc trò chuyện

    private List<String> participants; // Danh sách người tham gia cuộc trò chuyện

    private List<Message> messages = new ArrayList<>(); // Mảng tin nhắn trong cuộc trò chuyện

    // Lớp con mô phỏng nội dung tin nhắn
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class Message {

        private String sender; // Người gửi
        private String receiver; // Người nhận
        private Content content; // Nội dung tin nhắn
        private Date timestamp; // Thời gian gửi tin nhắn

        // Lớp con mô phỏng nội dung tin nhắn
        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        @ToString
        public static class Content {
            private MessageType type; // Loại tin nhắn (text, image, video, etc.)
            private String data; // Dữ liệu tin nhắn (ví dụ: văn bản, URL, link, file)
        }
    }
}
