package com.springboot.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.backend.common.R;
import com.springboot.backend.dto.LoginRequest;
import com.springboot.backend.entity.User;
import com.springboot.backend.utils.TokenResponse;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserService extends IService<User> {

    public R<String> login(@RequestBody LoginRequest request);

    public R<String> createUser(@RequestBody User user);
}
