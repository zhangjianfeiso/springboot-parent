package com.example.wechat.common.utils;

import cn.hutool.core.util.StrUtil;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.example.wechat.common.bean.AccessToken;
import com.example.wechat.common.bean.Constant;
import com.example.wechat.common.bean.WechatProperties;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * @author zhangjf
 * @Date 2018/7/30  11:23
 */
@Component
@Slf4j
public class GenerateAccessToken {

    private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={}&secret={}";

    @Autowired
    private WechatProperties wechatProperties;
    @Autowired
    private RedisUtil redisUtil;

    public synchronized AccessToken getAccessToken(){
        AccessToken accessToken = (AccessToken) redisUtil.get(Constant.ACCESS_TOKEN);
        if(null != accessToken){
            return accessToken;
        }
        return generate();
    }

    private AccessToken generate(){
        try {
            String result = HttpUtil.get(StrUtil.format(ACCESS_TOKEN_URL, wechatProperties.getAppid(), wechatProperties.getSecret()));
            if(StrUtil.isNotBlank(result)){
                AccessToken accessToken = JSONUtil.toBean(result, AccessToken.class);
                if(null != accessToken && StrUtil.isNotBlank(accessToken.getAccess_token())){
                    redisUtil.set(Constant.ACCESS_TOKEN,accessToken,7200);
                }
                log.info("获取到的access_token:{}",accessToken);
                return accessToken;
            }
        }catch (Exception e){
            log.error("获取access_token失败，{}",e.getMessage());
        }
        return null;
    }

    @Scheduled(fixedDelay = 7000 * 1000)
    private void init(){
        log.info("定时执行：获取access_token");
       // generate();
        log.info("执行定时完成：");
    }
}
