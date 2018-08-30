package com.example.wechat.common.bean;


import lombok.Data;

/**
 * @author zhangjf
 * @Date 2018/7/30  11:14
 */
@Data
public class AccessToken extends BaseRequest {

    private String access_token;
    private Long expires_in;
}
