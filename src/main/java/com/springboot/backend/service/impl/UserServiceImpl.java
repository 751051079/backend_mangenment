package com.springboot.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.databind.DatabindContext;
import com.springboot.backend.common.R;
import com.springboot.backend.config.JwtTokenProvider;
import com.springboot.backend.dto.LoginRequest;
import com.springboot.backend.entity.User;
import com.springboot.backend.mapper.UserMapper;
import com.springboot.backend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestBody;
import javax.servlet.http.HttpSession;

@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public R<String> login(@RequestBody LoginRequest request) {

        String username = request.getUsername();
        String password = request.getPassword();
        String captcha = request.getCaptcha();

        String storedCaptcha = ((String) httpSession.getAttribute("captcha")).toLowerCase();
        if (!captcha.toLowerCase().equals(storedCaptcha)) {
            return R.error("验证码错误");
        }

        //1、将页面提交的密码password进行md5加密处理
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        //2、根据页面提交的用户名username查询数据库
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername,username);
        User user1 = getOne(queryWrapper);

        //3、如果没有查询到则返回登录失败结果
        if(user1 == null){
            return R.error("登录失败");
        }

        //4、密码比对，如果不一致则返回登录失败结果
        if(!user1.getPassword().equals(password)){
            return R.error("登录失败");
        }

        //5、查看用户状态，如果为已禁用状态，则返回员工已禁用结果
        if(user1.getStatus() == 0){
            return R.error("账号已禁用");
        }

        // 返回 Token
        String token = jwtTokenProvider.generateToken(username,password,captcha);
        return R.success(token);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public R<String> createUser(@RequestBody User user) {
        log.info(user.toString());
        if(user.getUsername() == null){
            R.error("没有输入用户名！");
        }

        if(user.getPassword() == null){
            R.error("没有输入密码！");
        }

        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapper.eq(User::getUsername,user.getUsername());

        User user1 = getOne(queryWrapper);

        if(user1!=null){
            return R.error("账号已存在，请重试！");
        }

        String password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());

        user.setPassword(password);

        save(user);

        return R.success("创建账号成功！");
    }
}
