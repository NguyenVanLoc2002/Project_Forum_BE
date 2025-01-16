package com.fit.backend.models;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "comments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Comment {

    @Id
    private String id;

    private String threadId; // Thread chứa comment
    private String parentCommentId; // ID comment cha (nếu là comment trong comment)
    private String content; // Nội dung comment
    private String createdBy; // Người đăng comment
    private Date createdAt; // Ngày đăng
    private Date updatedAt; // Ngày chỉnh sửa

    private Votes votes; // Thống kê lượt vote
    private List<String> replies; // Danh sách các comment con
    private Report report; // Báo cáo vi phạm

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
