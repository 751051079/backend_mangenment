package com.springboot.backend.dto;

import lombok.Data;

@Data
public class LoginRequest {
    //用户名
    private String username;
    //用户密码
    private String password;
    //登录验证码
    private String captcha;
}
