package com.springboot.backend.common;

/**
 * 基于ThreadLocal封装的工具类，用于获取当前线程的用户信息
 */
public class BaseContext {
    private static final ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void setCurrentId(Long id) {
        threadLocal.set(id);
    }

    public static Long getCurrentId() {
        return threadLocal.get();
    }
}
