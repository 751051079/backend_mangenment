package com.springboot.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.backend.common.R;
import com.springboot.backend.entity.RecipeCategory;

import java.util.List;

public interface RecipeCategoryService extends IService<RecipeCategory> {

    public R<RecipeCategory> saveRecipeCategory(RecipeCategory recipeCategory);

    public R<List<RecipeCategory>> getRecipesByCategoryId(Long categoryId);

    public R<String> removeRecipesCategoryById(Long id);

}
