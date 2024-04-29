package com.springboot.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.backend.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
