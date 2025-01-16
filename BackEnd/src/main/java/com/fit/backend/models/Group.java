package com.fit.backend.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "groups")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Group {
    @Id
    private String id;

    private String name; // Tên nhóm chủ đề
    private String description; // Mô tả nhóm chủ đề
    private List<String> topics; // Danh sách các topic thuộc nhóm (danh sách topicId)
    private Date createdAt; // Ngày tạo nhóm chủ đề
    private String createdBy; // Người quản lý nhóm (userId)
}
