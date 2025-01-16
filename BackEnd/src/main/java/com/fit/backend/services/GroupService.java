package com.fit.backend.services;

import com.fit.backend.models.Group;
import com.fit.backend.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    public Group saveGroup(Group group) {
        return groupRepository.save(group); // Lưu Group vào MongoDB
    }

    public Group getGroupById(String id) {
        return groupRepository.findById(id).orElse(null); // Lấy Group theo ID
    }

    public void deleteGroup(String id) {
        groupRepository.deleteById(id); // Xóa Group theo ID
    }

    public Group updateGroup(String id, Group group) {
        if (groupRepository.existsById(id)) {
            group.setId(id);  // Cập nhật ID của group
            return groupRepository.save(group); // Cập nhật Group trong MongoDB
        }
        return null; // Nếu không tìm thấy group
    }
}
