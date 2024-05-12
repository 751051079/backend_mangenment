package com.springboot.backend.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long menuId;

    private String menuName;

    private Long parentId;

    private int orderNum;

    private String path;

    private String component;

    private String query;

    private int isFrame;

    private int isCache;

    private char menuType;

    private char visible;

    private char status;

    private String perms;

    private String icon;

    private String createBy;

    @TableField(fill = FieldFill.INSERT) //插入时填充字段
    private LocalDateTime createTime;

    private String updateBy;

    @TableField(fill = FieldFill.INSERT_UPDATE) //插入和更新时填充字段
    private LocalDateTime updateTime;

    private String remark;

}
