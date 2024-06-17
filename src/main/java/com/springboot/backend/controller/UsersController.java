package com.springboot.backend.controller;

import com.springboot.backend.common.R;
import com.springboot.backend.entity.Users;
import com.springboot.backend.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    // 创建用户
    @PostMapping
    public R<Users> createUser(@RequestBody Users user) {
        return usersService.createUser(user);
    }

    // 获取单个用户信息
    @GetMapping("/{id}")
    public R<Users> getUser(@PathVariable Long id) {
        return usersService.getUser(id);
    }

    // 获取所有用户列表
    @GetMapping
    public R<List<Users>> getAllUsers() {
        return usersService.getAllUsers();
    }

    // 更新用户信息
    @PutMapping("/{id}")
    public R<Users> updateUser(@PathVariable Long id, @RequestBody Users user) {
        return usersService.updateUser(id, user);
    }

    // 删除用户
    @DeleteMapping("/{id}")
    public R<Users> deleteUser(@PathVariable Long id) {

        return usersService.deleteUser(id);
    }
}
