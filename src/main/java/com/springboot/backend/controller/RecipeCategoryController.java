package com.springboot.backend.controller;

import com.springboot.backend.entity.RecipeCategory;
import com.springboot.backend.service.RecipeCategoryService;
import com.springboot.backend.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/recipe-categories")
public class RecipeCategoryController {

    @Autowired
    private RecipeCategoryService recipeCategoryService;

    // 将菜谱添加到分类
    @PostMapping
    public R<RecipeCategory> addRecipeToCategory(@RequestBody RecipeCategory recipeCategory) {
        return recipeCategoryService.saveRecipeCategory(recipeCategory);
    }

    // 获取分类的所有菜谱
    @GetMapping("/category/{categoryId}")
    public R<List<RecipeCategory>> getRecipesByCategoryId(@PathVariable Long categoryId) {
        return recipeCategoryService.getRecipesByCategoryId(categoryId);
    }

    // 从分类中移除菜谱
    @DeleteMapping("/{id}")
    public R<String> removeRecipeFromCategory(@PathVariable Long id) {
        return recipeCategoryService.removeRecipesCategoryById(id);
    }
}
