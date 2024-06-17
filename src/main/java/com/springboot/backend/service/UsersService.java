package com.springboot.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.backend.common.R;
import com.springboot.backend.entity.Category;
import com.springboot.backend.entity.Users;

import java.util.List;

public interface UsersService extends IService<Users> {

    R<Users> createUser(Users user);

    R<Users> getUser(Long id);

    R<List<Users>> getAllUsers();

    R<Users> updateUser(Long id, Users users);

    R<Users> deleteUser(Long id);
}
