package com.example.common.bean;

/**
 * @author zhangjf
 * @Date 2018/8/22  14:16
 */
public enum  HttpStatus {

    SUCCESS(200,"调用成功！"),
    ERROR_REQUEST(400,"错误请求！"),
    UNAUTHORIZED(401,"未经授权！"),
    FORBIDDEN(403,"禁止访问！"),
    NOT_FOUND(404,"未找到页面！"),
    METHOD_NOT_ALLOWED(405,"不允许的方法！"),
    REQUEST_TIMEOUT(408,"请求超时！"),
    ERROR(500,"内部服务器错误！");

    private int code;
    private String message;


    HttpStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
