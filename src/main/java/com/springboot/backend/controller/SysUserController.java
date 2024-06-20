package com.springboot.backend.controller;


import com.springboot.backend.common.R;
import com.springboot.backend.dto.LoginRequest;
import com.springboot.backend.entity.SysUser;
import com.springboot.backend.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private SysUserService userService;

    /**
     * 用户登录
     * @param request
     * @return
     */
    @PostMapping("login")
    public R<SysUser> login(@RequestBody LoginRequest request, HttpSession session){
        log.info(request.toString());
        R<SysUser> result = userService.login(request,session);
        return result;
    }

    /**
     * 注册用户账号
     * @param request
     * @param user
     * @return
     */
    @PostMapping("create")
    public R<String> createUser(HttpServletRequest request,@RequestBody SysUser user) {
        R<String> result = userService.createUser(user);
        return result;
    }


}
