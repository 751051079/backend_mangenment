package com.springboot.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.backend.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
}
