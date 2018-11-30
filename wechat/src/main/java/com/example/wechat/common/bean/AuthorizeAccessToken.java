package com.example.wechat.common.bean;

import lombok.Data;

/**
 * @author zhangjf
 * @Date 2018/11/30  11:19
 */
@Data
public class AuthorizeAccessToken extends BaseRequest {
    private String access_token;
    private String refresh_token;
    private Long expires_in;
    private String openid;  //用户唯一标识，请注意，在未关注公众号时，用户访问公众号的网页，也会产生一个用户和公众号唯一的OpenID
    private String scope;  //用户授权的作用域，使用逗号（,）分隔
}
