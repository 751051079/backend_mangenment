package com.springboot.backend.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class R<T> {
    /**
     * 编码：1成功，0和其它数字为失败
     */
    private Integer code;

    /**
     * 错误信息
     */
    private String msg;

    /**
     * 具体数据
     */
    private T data;

    /**
     * 动态数据
     */
    private Map map = new HashMap();

    /**
     * 成功即返回数据和成功代码
     *
     * @param object 成功的信息对象
     * @param <T>
     * @return 返回该类的泛型的结果R对象，包含有成功代码和数据
     */
    public static <T> R<T> success(T object, String msg) {
        R<T> r = new R<T>();
        r.data = object;
        r.code = 200;
        r.msg = msg;
        return r;
    }

    /**
     * 失败
     *
     * @param msg 错误信息
     * @param <T>
     * @return 返回该类的泛型的结果R对象，包含有失败代码和错误信息
     */
    public static <T> R<T> error(String msg) {
        R r = new R();
        r.msg = msg;
        r.code = 500;
        return r;
    }

    public R<T> add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }
}
