package com.springboot.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.backend.common.R;
import com.springboot.backend.dto.LoginRequest;
import com.springboot.backend.entity.SysUser;
import com.springboot.backend.mapper.SysUserMapper;
import com.springboot.backend.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestBody;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Slf4j
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private HttpSession httpSession;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public R<SysUser> login(@RequestBody LoginRequest request, HttpSession session) {

        String username = request.getUsername();
        String password = request.getPassword();
        String captcha = request.getCaptcha();

        //1、将页面提交的密码password进行md5加密处理
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        //2、根据页面提交的用户名username查询数据库
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getUserName,username);
        SysUser user1 = getOne(queryWrapper);

        //3、如果没有查询到则返回登录失败结果
        if(user1 == null){
            return R.error("没有找到该账号");
        }

        //4、密码比对，如果不一致则返回登录失败结果
        if(!user1.getPassword().equals(password)){
            return R.error("密码错误，请重新输入密码");
        }

        //5、查看用户状态，如果为已禁用状态，则返回员工已禁用结果
        if(user1.getStatus() != '0'){
            return R.error("账号已禁用");
        }
        String sessionCaptcha = (String) session.getAttribute("captcha");
        if (!Objects.equals(sessionCaptcha.toLowerCase(), captcha.toLowerCase())) {
            return R.error("验证码错误");
        }

        httpSession.setAttribute("user",user1.getId());

        return R.success(user1,"登陆成功");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public R<String> createUser(@RequestBody SysUser user) {
        log.info(user.toString());
        if(user.getUserName() == null){
            R.error("没有输入用户名！");
        }

        if(user.getPassword() == null){
            R.error("没有输入密码！");
        }

        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapper.eq(SysUser::getUserName,user.getUserName());

        SysUser user1 = getOne(queryWrapper);

        if(user1!=null){
            return R.error("账号已存在，请重试！");
        }

        String password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());

        user.setPassword(password);

        save(user);

        return R.success("创建账号成功！","成功");
    }
}
