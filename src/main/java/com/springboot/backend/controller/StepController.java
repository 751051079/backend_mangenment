package com.springboot.backend.controller;

import com.springboot.backend.entity.Step;
import com.springboot.backend.service.StepService;
import com.springboot.backend.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/steps")
public class StepController {

    @Autowired
    private StepService stepService;

    // 添加步骤到菜谱
    @PostMapping
    public R<Step> createStep(@RequestBody Step step) {

        return stepService.saveStep(step);
    }

    // 获取菜谱的所有步骤
    @GetMapping("/recipe/{recipeId}")
    public R<List<Step>> getStepsByRecipeId(@PathVariable Long recipeId) {
        return stepService.getStepsByRecipeId(recipeId);
    }

    // 更新步骤信息
    @PutMapping("/{id}")
    public R<Step> updateStep(@PathVariable Long id, @RequestBody Step step) {
        return stepService.updateStepById(id,step);
    }

    // 删除步骤
    @DeleteMapping("/{id}")
    public R<String> deleteStep(@PathVariable Long id) {
        return stepService.removeStepById(id);
    }
}
