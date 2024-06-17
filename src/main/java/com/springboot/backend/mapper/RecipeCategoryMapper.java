package com.springboot.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.backend.entity.RecipeCategory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RecipeCategoryMapper extends BaseMapper<RecipeCategory> {
}
