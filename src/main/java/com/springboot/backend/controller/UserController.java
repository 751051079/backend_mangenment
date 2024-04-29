package com.springboot.backend.controller;


import com.springboot.backend.common.R;
import com.springboot.backend.dto.LoginRequest;
import com.springboot.backend.entity.User;
import com.springboot.backend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param request
     * @return
     */
    @PostMapping("login")
    public R<String> login(@RequestBody LoginRequest request){
        log.info(request.toString());
        R<String> result = userService.login(request);
        return result;
    }

    /**
     * 注册用户账号
     * @param request
     * @param user
     * @return
     */
    @PostMapping("create")
    public R<String> createUser(HttpServletRequest request,@RequestBody User user) {
        R<String> result = userService.createUser(user);
        return result;
    }


}
