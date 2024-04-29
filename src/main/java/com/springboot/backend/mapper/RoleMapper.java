package com.springboot.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.backend.entity.Role;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {
}
