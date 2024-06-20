package com.springboot.backend.controller;

import com.springboot.backend.entity.Category;
import com.springboot.backend.service.CategoryService;
import com.springboot.backend.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/categories")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    // 创建分类
    @PostMapping
    public R<Category> createCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    // 获取单个分类信息
    @GetMapping("/{id}")
    public R<Category> getCategory(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    // 获取所有分类列表
    @GetMapping
    public R<List<Category>> getAllCategories() {
        return categoryService.getCategoryList();
    }

    // 更新分类信息
    @PostMapping("/update/{id}")
    public R<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        return categoryService.updateCategoryById(id,category);
    }

    // 删除分类
    @PostMapping("/delete/{id}")
    public R<String> deleteCategory(@PathVariable Long id) {
        return categoryService.removeCategoryById(id);
    }
}
