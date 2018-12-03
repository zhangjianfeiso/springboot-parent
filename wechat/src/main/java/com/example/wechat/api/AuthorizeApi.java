package com.example.wechat.api;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.example.wechat.common.bean.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * 网页授权api
 * @author zhangjf
 * @Date 2018/11/30  11:13
 */
@Component
@Slf4j
public class AuthorizeApi {
    private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid={}&secret={}&code={}&grant_type=authorization_code";

    private static final String  REFRESH_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid={}&grant_type=refresh_token&refresh_token={}";

    private static final String USER_INFO_URL = "https://api.weixin.qq.com/sns/userinfo?access_token={}&openid={}&lang=zh_CN";

    private static final String AUTH_CHECK_URL = "https://api.weixin.qq.com/sns/auth?access_token={}&openid={}";
    @Autowired
    private WechatProperties wechatProperties;

    /**
     * 根据code获取access_token
     * @param code
     * @return
     */
    public AuthorizeAccessToken getAccessToken(String code){
        try {
            String result = HttpUtil.get(StrUtil.format(ACCESS_TOKEN_URL, wechatProperties.getAppid(), wechatProperties.getSecret(), code));
            return JSONObject.parseObject(result,AuthorizeAccessToken.class);
        }catch (Exception e){
            e.printStackTrace();
            log.error("网页授权获取openid失败！{}",e.getMessage());
        }
        return null;
    }

    /**
     * 刷新token
     * @param refreshToken
     * @return
     */
    public AuthorizeAccessToken refreshToken(String refreshToken){
        try {
            String result = HttpUtil.get(StrUtil.format(REFRESH_TOKEN_URL, wechatProperties.getAppid(), refreshToken));
            return JSONObject.parseObject(result,AuthorizeAccessToken.class);
        }catch (Exception e){
            e.printStackTrace();
            log.error("网页授权,刷新token失败，获取openid失败！{}",e.getMessage());
        }

        return null;
    }

    /**
     * 获取用户信息
     * @param accessToken
     * @param openid
     * @return
     */
    public UserInfo getUserInfo(String accessToken, String openid){
        try {
            String result = HttpUtil.get(StrUtil.format(USER_INFO_URL, accessToken, openid));
            return JSONObject.parseObject(result,UserInfo.class);
        }catch (Exception e){
            e.printStackTrace();
            log.error("网页授权,获取用户信息失败！{}",e.getMessage());
        }
        return null;
    }

    /**
     * 检验授权凭证（access_token）是否有效
     * @param accessToken
     * @param openid
     * @return
     */
    public boolean check(String accessToken,String openid){
        try {
            String result = HttpUtil.get(StrUtil.format(AUTH_CHECK_URL, accessToken, openid));
            BaseRequest baseRequest = JSONObject.parseObject(result, BaseRequest.class);
            return RequestCode.SUCCESS.getCode().equals(baseRequest.getErrcode());
        }catch (Exception e){
            e.printStackTrace();
            log.error("验证授权凭证失败！{}",e.getMessage());
        }
        return false;
    }
}
