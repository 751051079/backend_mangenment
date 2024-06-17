package com.springboot.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.backend.common.R;
import com.springboot.backend.entity.Step;

import java.util.List;

public interface StepService extends IService<Step> {

    public R<Step> saveStep(Step step);

    public R<List<Step>> getStepsByRecipeId(Long recipeId);

    public R<Step> updateStepById(Long id,Step step);

    public R<String> removeStepById(Long id);

}
