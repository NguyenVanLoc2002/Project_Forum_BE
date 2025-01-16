package com.fit.backend.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "topics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Topic {

    @Id
    private String id;

    private String groupId; // Nhóm chủ đề mà topic thuộc về
    private String name; // Tên topic
    private String description; // Mô tả topic
    private String createdBy; // Người tạo topic
    private Date createdAt; // Ngày tạo topic
    private Date updatedAt; // Ngày cập nhật cuối cùng

    private int totalThreads; // Số lượng thread trong topic
    private int totalComments; // Tổng số comment trong tất cả các thread

    private LatestThread latestThread; // Thread mới nhất
    private List<String> highlighted; // Danh sách user đã đọc (highlight)
    private List<String> subscribedBy; // Danh sách user theo dõi topic
    private List<String> tags; // Các tag liên quan đến topic
    private List<String> threads; // Danh sách ID của các thread trong topic

    // Lớp con mô tả thông tin về thread mới nhất trong topic
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class LatestThread {
        private String threadId; // ID của thread mới nhất
        private String title; // Tiêu đề của thread mới nhất
        private Date createdAt; // Ngày tạo của thread mới nhất
    }
}
