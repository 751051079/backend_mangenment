package com.springboot.backend.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long menuId;

    private String menuName;

    private String menuKey;

    private String component;

    private Long parentId;

    private String target;

    private int orderNum;

    private char menuType;

    private int visible;

    private String perms;

    private String path;

    private String redirect;

    private int hiddenChildren;

    private int hiddenHeader;

    private String createBy;

    @TableField(fill = FieldFill.INSERT) //插入时填充字段
    private LocalDateTime createTime;

    private String updateBy;

    @TableField(fill = FieldFill.INSERT_UPDATE) //插入和更新时填充字段
    private LocalDateTime updateTime;

    private String remark;

}
