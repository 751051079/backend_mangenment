package com.springboot.backend.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 步骤实体类
 */
@Data
public class Step implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 步骤ID
     */
    private Long id;

    /**
     * 关联的菜谱ID
     */
    private Long recipeId;

    /**
     * 步骤编号
     */
    private Integer stepNumber;

    /**
     * 步骤描述
     */
    private String description;

    /**
     * 步骤图片URL
     */
    private String imageUrl;

    /**
     * 创建者
     */
    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新者
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
