package com.springboot.backend.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long roleId;

    private String roleName;

    private String roleKey;

    private int roleSort;

    private char dataScope;

    private char status;

    private String delFlag;

    private String createBy;

    @TableField(fill = FieldFill.INSERT) //插入时填充字段
    private LocalDateTime createTime;

    private String updateBy;

    @TableField(fill = FieldFill.INSERT_UPDATE) //插入和更新时填充字段
    private LocalDateTime updateTime;

    private String remark;

}
