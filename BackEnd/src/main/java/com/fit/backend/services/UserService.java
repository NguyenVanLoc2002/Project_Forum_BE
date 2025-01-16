package com.fit.backend.services;

import com.fit.backend.models.User;
import com.fit.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user); // Lưu User vào MongoDB
    }

    public User findByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }
}
