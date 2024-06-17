package com.springboot.backend.controller;

import com.springboot.backend.entity.Recipe;
import com.springboot.backend.service.RecipeService;
import com.springboot.backend.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    // 创建菜谱
    @PostMapping
    public R<Recipe> createRecipe(@RequestBody Recipe recipe) {

        return recipeService.saveRecipe(recipe);
    }

    // 获取单个菜谱信息
    @GetMapping("/{id}")
    public R<Recipe> getRecipe(@PathVariable Long id) {
        return recipeService.getRecipeById(id);
    }

    // 获取所有菜谱列表
    @GetMapping
    public R<List<Recipe>> getAllRecipes() {
        return recipeService.getRecipeList();
    }

    // 更新菜谱信息
    @PutMapping("/{id}")
    public R<Recipe> updateRecipe(@PathVariable Long id, @RequestBody Recipe recipe) {
        return recipeService.updateRecipeById(id,recipe);
    }

    // 删除菜谱
    @DeleteMapping("/{id}")
    public R<String> deleteRecipe(@PathVariable Long id) {

        return recipeService.removeRecipeById(id);
    }
}
