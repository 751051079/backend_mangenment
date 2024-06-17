package com.springboot.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.backend.common.R;
import com.springboot.backend.entity.Step;
import com.springboot.backend.mapper.StepMapper;
import com.springboot.backend.service.StepService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StepServiceImpl extends ServiceImpl<StepMapper, Step> implements StepService {


    @Override
    @Transactional(rollbackFor = Exception.class)
    public R<Step> saveStep(Step step) {
        save(step);
        return R.success(step,"保存成功！");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public R<List<Step>> getStepsByRecipeId(Long recipeId) {
        List<Step> steps = baseMapper.selectList(new QueryWrapper<Step>().eq("recipe_id", recipeId));;
        return R.success(steps,"查询成功！");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public R<Step> updateStepById(Long id, Step step) {
        step.setId(id);
        updateById(step);
        return R.success(step,"修改成功！");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public R<String> removeStepById(Long id) {
        removeById(id);
        return R.success("","删除成功！");
    }
}
