package com.springboot.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.backend.common.R;
import com.springboot.backend.entity.RecipeCategory;
import com.springboot.backend.mapper.RecipeCategoryMapper;
import com.springboot.backend.service.RecipeCategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RecipeCategoryServiceImpl extends ServiceImpl<RecipeCategoryMapper, RecipeCategory> implements RecipeCategoryService {


    @Override
    @Transactional(rollbackFor = Exception.class)
    public R<RecipeCategory> saveRecipeCategory(RecipeCategory recipeCategory) {
        save(recipeCategory);
        return R.success(recipeCategory,"保存成功！");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public R<List<RecipeCategory>> getRecipesByCategoryId(Long categoryId) {
        List<RecipeCategory> recipeCategories = baseMapper.selectList(new QueryWrapper<RecipeCategory>().eq("category_id", categoryId));
        return R.success(recipeCategories,"获取成功！");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public R<String> removeRecipesCategoryById(Long id) {
        removeById(id);
        return R.success("","菜谱从分类中移除成功！");
    }
}
