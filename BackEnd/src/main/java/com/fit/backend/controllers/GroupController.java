package com.fit.backend.controllers;

import com.fit.backend.models.Group;
import com.fit.backend.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping("/create")
    public Group createGroup(@RequestBody Group group) {
        return groupService.saveGroup(group); // Tạo mới Group
    }

    @GetMapping("/{id}")
    public Group getGroup(@PathVariable String id) {
        return groupService.getGroupById(id); // Lấy Group theo ID
    }

    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable String id) {
        groupService.deleteGroup(id); // Xóa Group theo ID
    }

    @PutMapping("/{id}")
    public Group updateGroup(@PathVariable String id, @RequestBody Group group) {
        return groupService.updateGroup(id, group); // Cập nhật Group
    }
}
