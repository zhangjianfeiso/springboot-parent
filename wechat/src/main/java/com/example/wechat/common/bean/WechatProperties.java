package com.example.wechat.common.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangjf
 * @Date 2018/7/30  11:27
 */
@Configuration
@ConfigurationProperties(prefix = "wechat")
@Data
public class WechatProperties {

    private String ip;
    private String appid;
    private String secret;
    private String token;

}
