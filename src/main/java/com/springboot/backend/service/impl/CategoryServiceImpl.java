package com.springboot.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.backend.common.R;
import com.springboot.backend.entity.Category;
import com.springboot.backend.mapper.CategoryMapper;
import com.springboot.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {


    @Transactional(rollbackFor = Exception.class)
    @Override
    public R<Category> saveCategory(Category category) {
        save(category);
        return R.success(category,"添加成功！");
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public R<Category> getCategoryById(Long id) {
        Category category = getById(id);
        return R.success(category,"查询成功！");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public R<List<Category>> getCategoryList() {
        List<Category> categories = list();
        return R.success(categories,"查询成功!");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public R<Category> updateCategoryById(Long id, Category category) {
        category.setId(id);
        updateById(category);
        return R.success(category,"修改成功!");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public R<String> removeCategoryById(Long id) {
        removeById(id);
        return R.success("","删除成功");
    }
}
