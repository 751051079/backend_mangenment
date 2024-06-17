package com.springboot.backend.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 菜谱实体类
 */
@Data
public class Recipe implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜谱ID
     */
    private Long id;

    /**
     * 菜谱标题
     */
    private String title;

    /**
     * 菜谱描述
     */
    private String description;

    /**
     * 菜谱图片URL
     */
    private String imageUrl;

    /**
     * 发布菜谱的用户ID
     */
    private Long userId;

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
