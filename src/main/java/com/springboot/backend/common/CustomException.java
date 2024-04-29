package com.springboot.backend.common;

/**
 * CustomException 自定义异常类
 */
public class CustomException extends RuntimeException {
    /**
     * 这个异常将会被{@link GlobalExceptionHandler}捕获，然后返回给前端。
     * @param message 异常信息
     */
    public CustomException(String message) {
        super(message);
    }

}
