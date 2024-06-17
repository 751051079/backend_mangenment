package com.springboot.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.backend.entity.Recipe;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RecipeMapper extends BaseMapper<Recipe> {
}
