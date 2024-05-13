package com.springboot.backend.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    /**
     * 插入时自动填充
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("公共字段自动填充[insert]...");
        log.info(metaObject.toString());
        metaObject.setValue("createTime", LocalDateTime.now());
        metaObject.setValue("updateTime", LocalDateTime.now());
        metaObject.setValue("createBy", BaseContext.getCurrentId());     // 从 ThreadLocal 中获取当前用户的 id
        metaObject.setValue("updateBy", BaseContext.getCurrentId());     // 从 ThreadLocal 中获取当前用户的 id
    }


    /**
     * 更新时自动填充
     *
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
//        log.info("公共字段自动填充[update]...");
//        log.info(metaObject.toString());
//
//        long id = Thread.currentThread().getId(); // 获取当前线程的id
//        log.info("当前线程id={}", id);                                        // Slf4j的日志输出
//
        metaObject.setValue("updateTime", LocalDateTime.now());
        metaObject.setValue("updateBy", BaseContext.getCurrentId());
    }
}
