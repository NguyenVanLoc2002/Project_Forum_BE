package com.fit.backend.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "threads")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Thread {
    @Id
    private String id;

    private String title; // Tiêu đề thread
    private String content; // Nội dung thread (hỗ trợ rich text - markdown)
    private String topicId; // Topic mà thread thuộc về
    private String createdBy; // Người tạo thread
    private Date createdAt; // Ngày đăng
    private Date updatedAt; // Ngày cập nhật

    private Votes votes; // Thống kê lượt vote
    private Report report; // Báo cáo vi phạm
    private List<String> comments; // Danh sách ID các comment trong thread
    private List<String> subscriptions; // Danh sách người dùng theo dõi thread
    private List<String> bookmarkedBy; // Người dùng đã bookmark thread
    private int shares; // Số lần thread được chia sẻ
    private int views; // Số lượt xem thread
    private int replies; // Số lượt trả lời (comment)

    // Lớp con để mô phỏng thống kê lượt vote
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class Votes {
        private List<String> up; // Người dùng đã vote up
        private List<String> down; // Người dùng đã vote down
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class Report {
        private int count; // Số lần bị báo cáo
        private List<ReportDetail> details; // Chi tiết các báo cáo

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        @ToString
        public static class ReportDetail {
            private String reportedBy; // Người báo cáo
            private String reason; // Lý do báo cáo
            private Date timestamp; // Thời gian báo cáo

        }
    }
}
