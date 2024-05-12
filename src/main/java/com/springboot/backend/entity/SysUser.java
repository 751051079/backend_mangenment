package com.springboot.backend.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户账号实体类
 */
@Data
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 用户账号id
     */
    private Long id;

    /** 用户账号 */
    private String username;

    /** 用户密码 */
    private String password;

    /** 账号使用状态 */
    private Integer status;

    /** 账号创建时间 */
    @TableField(fill = FieldFill.INSERT) //插入时填充字段
    private LocalDateTime createTime;

    /** 账号修改时间 */
    @TableField(fill = FieldFill.INSERT_UPDATE) //插入和更新时填充字段
    private LocalDateTime updateTime;

}
