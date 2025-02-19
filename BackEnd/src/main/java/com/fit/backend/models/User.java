package com.fit.backend.models;

import com.fit.backend.enums.Gender;
import com.fit.backend.enums.Role;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Document(collation = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Id
    private String id;

    private String username;
    private String email;
    private String password; // Hashed password
    private LocalDate dayOfBirth;
    private Gender gender;

    private Role role;
    private boolean isActive;
    private Date createdAt;
    private Date lastLogin;

    private Profile profile;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class Profile {
        private String bio;
        private String avatar;
        private List<String> followers; // List of userIds
        private List<String> following; // List of userIds
        private List<String> bookmarks; // List of threadIds
        private List<String> blockedUsers; // List of userIds

    }
}
