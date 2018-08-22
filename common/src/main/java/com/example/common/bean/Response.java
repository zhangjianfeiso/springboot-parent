package com.example.common.bean;

import lombok.Data;
import java.util.Map;
/**
 * @author zhangjf
 * @Date 2018/8/22  14:34
 */
@Data
public class Response<T> {

    private int code;
    private String message;
    private T data;

    private Map<String, Object> ext;

    /**
     * 默认调用成功
     */
    public Response() {
        this.code = HttpStatus.SUCCESS.getCode();
        this.message = HttpStatus.SUCCESS.getMessage();
    }

    /**
     * 成功返回的数据
     *
     * @param data
     */
    public Response(T data) {
        this.code = HttpStatus.SUCCESS.getCode();
        this.message = HttpStatus.SUCCESS.getMessage();
        this.data = data;
    }

    /**
     * 成功返回扩展数据
     *
     * @param ext
     */
    public Response(Map<String, Object> ext) {
        this.code = HttpStatus.SUCCESS.getCode();
        this.message = HttpStatus.SUCCESS.getMessage();
        this.ext = ext;
    }

    /**
     * 自定义返回
     *
     * @param code
     * @param message
     */
    public Response(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 自定义返回
     *
     * @param code
     * @param message
     * @param ext
     */
    public Response(int code, String message, Map<String, Object> ext) {
        this.code = code;
        this.message = message;
        this.ext = ext;
    }

    /**
     * 成功返回 数据和扩展数据
     *
     * @param ext
     * @param data
     */
    public Response(T data, Map<String, Object> ext) {
        this.code = HttpStatus.SUCCESS.getCode();
        this.message = HttpStatus.SUCCESS.getMessage();
        this.data = data;
        this.ext = ext;
    }

    /**
     * 全部返回
     *
     * @param code
     * @param message
     * @param data
     */
    public Response(int code, String message, T data, Map<String, Object> ext) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.ext = ext;
    }

    public static <T> Response<T> ok() {
        return new Response<>();
    }

    public static <T> Response<T> ok(T data) {
        return new Response<>(data);
    }

    public static <T> Response<T> ok(T data, Map<String, Object> ext) {
        return new Response<>(data, ext);
    }

    public static <T> Response<T> ok(int code, String message, T data, Map<String, Object> ext) {
        return new Response<>(code, message, data, ext);
    }

    public static <T> Response<T> ok(Map<String, Object> ext) {
        return new Response<>(ext);
    }


    public static <T> Response<T> error(int code, String message) {
        return new Response<>(code, message);
    }

    public static <T> Response<T> error(int code, String message, Map<String, Object> ext) {
        return new Response<>(code, message, ext);
    }
}
