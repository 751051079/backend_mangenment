package com.springboot.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.backend.common.R;
import com.springboot.backend.entity.Users;
import com.springboot.backend.mapper.UsersMapper;
import com.springboot.backend.service.UsersService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

    @Transactional(rollbackFor = Exception.class)
    @Override
    public R<Users> createUser(Users user) {
        if(user.getUsername() == null){
            return R.error("用户名不能为空！");
        }
        if(user.getPassword() == null){
            return R.error("密码不能为空！");
        }
        if(user.getEmail() == null){
            return R.error("邮箱不能为空！");
        }
        save(user);
        return R.success(user,"创建账号成功！");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public R<Users> getUser(Long id) {
        LambdaQueryWrapper<Users> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapper.eq(Users::getId,id);

        Users user = getOne(queryWrapper);
        return R.success(user,"查询成功！");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public R<List<Users>> getAllUsers() {
        List<Users> list = list();
        return R.success(list,"查询成功");
    }

    @Override
    public R<Users> updateUser(Long id, Users users) {

        updateById(users);

        return R.success(users,"更新成功！");
    }

    @Override
    public R<Users> deleteUser(Long id) {
        LambdaQueryWrapper<Users> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapper.eq(Users::getId,id);

        Users user = getOne(queryWrapper);
        removeById(id);
        return R.success(user,"删除成功！");
    }
}
