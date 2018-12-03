package com.example.wechat.common.bean;

/**
 * @author zhangjf
 * @Date 2018/7/30  11:15
 */
public enum RequestCode {
    SERVERBUSY(-1,"系统繁忙，此时请开发者稍候再试"),
    SUCCESS(0,"请求成功"),
    APPSECRET_ERROR(40001,"AppSecret错误或者AppSecret不属于这个公众号，请开发者确认AppSecret的正确性"),
    CLIENT_CREDENTIAL(40002,"请确保grant_type字段值为client_credential"),
    NOT_ON_THE_WHITE_LIST(40003,"调用接口的IP地址不在白名单中，请在接口IP白名单中进行设置。（小程序及小游戏调用不要求IP地址在白名单内。）");

    private Integer code;
    private String msg;

    RequestCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
