package com.springboot.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.backend.common.R;
import com.springboot.backend.entity.Category;

import java.util.List;

public interface CategoryService extends IService<Category> {

    public R<Category> saveCategory(Category category);

    public R<Category> getCategoryById(Long id);

    public R<List<Category>> getCategoryList();

    public R<Category> updateCategoryById(Long id,Category category);

    public R<String> removeCategoryById(Long id);
}
