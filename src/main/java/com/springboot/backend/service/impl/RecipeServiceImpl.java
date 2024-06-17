package com.springboot.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.backend.common.R;
import com.springboot.backend.entity.Recipe;
import com.springboot.backend.mapper.RecipeMapper;
import com.springboot.backend.service.RecipeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RecipeServiceImpl extends ServiceImpl<RecipeMapper, Recipe> implements RecipeService {


    @Override
    @Transactional(rollbackFor = Exception.class)
    public R<Recipe> saveRecipe(Recipe recipe) {
        save(recipe);
        return R.success(recipe,"保存成功！");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public R<Recipe> getRecipeById(Long id) {
        Recipe recipe = getById(id);
        return R.success(recipe,"查询成功！");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public R<List<Recipe>> getRecipeList() {
        List<Recipe> recipes = list();
        return R.success(recipes,"查询成功！");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public R<Recipe> updateRecipeById(Long id, Recipe recipe) {
        recipe.setId(id);
        updateById(recipe);
        return R.success(recipe,"修改成功！");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public R<String> removeRecipeById(Long id) {
        removeById(id);
        return R.success("","删除成功！");
    }
}
