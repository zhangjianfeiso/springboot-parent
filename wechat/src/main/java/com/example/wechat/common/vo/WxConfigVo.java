package com.example.wechat.common.vo;

import lombok.Data;

@Data
public class WxConfigVo {

    private String appId;
    private String timestamp;
    private String nonceStr;
    private String signature;

}
