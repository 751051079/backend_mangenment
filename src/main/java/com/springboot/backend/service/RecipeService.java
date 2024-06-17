package com.springboot.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.backend.common.R;
import com.springboot.backend.entity.Recipe;

import java.util.List;

public interface RecipeService extends IService<Recipe> {

    public R<Recipe> saveRecipe(Recipe recipe);

    public R<Recipe> getRecipeById(Long id);

    public R<List<Recipe>> getRecipeList();

    public R<Recipe> updateRecipeById(Long id,Recipe recipe);

    public R<String> removeRecipeById(Long id);

}
