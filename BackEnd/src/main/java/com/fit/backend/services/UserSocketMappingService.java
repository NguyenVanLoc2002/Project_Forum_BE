package com.fit.backend.services;

import com.fit.backend.models.UserSocketMapping;
import com.fit.backend.repositories.UserSocketMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSocketMappingService {
    @Autowired
    private UserSocketMappingRepository userSocketMappingRepository;

    public UserSocketMapping saveUserSocketMapping(UserSocketMapping userSocketMapping) {
        return userSocketMappingRepository.save(userSocketMapping); // Lưu UserSocketMapping vào MongoDB
    }

    public UserSocketMapping getUserSocketMappingById(String id) {
        return userSocketMappingRepository.findById(id).orElse(null); // Lấy UserSocketMapping theo ID
    }

    public void deleteUserSocketMapping(String id) {
        userSocketMappingRepository.deleteById(id); // Xóa UserSocketMapping theo ID
    }
}
