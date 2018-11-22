package com.example.wechat.common.bean;


import lombok.Data;

@Data
public class JsapiTicket {
    private int errcode;
    private String errmsg;
    private String ticket;
    private long expires_in;
}
