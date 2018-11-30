package com.example.wechat.api;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.example.wechat.common.bean.*;
import com.example.wechat.common.utils.AccessTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhangjf
 * @Date 2018/11/30  8:58
 */
@Component
@Slf4j
public class WechatUserApi {

    /**
     * 获取关注用户接口url
     */
    private static final String WECHAT_FOCUSES_ON_USERS_URL = "https://api.weixin.qq.com/cgi-bin/user/get?access_token={}&next_openid={}";
    /**
     * 获取用户详细信息接口url
     */
    private static final String WECHAT_USER_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token={}&openid={}&lang=zh_CN";
    /**
     * 批量获取微信用户信息接口url
     */
    private static final String WECHAT_USER_INFO_BATCHGET_URL = "https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token={}";

    @Autowired
    private AccessTokenUtil accessTokenUtil;

    /**
     * 获取微信关注用户列表
     * @param nextOpenid    从哪个openid开始，空为默认从第一个开始
     * @return
     */
    public FocusesUser getWechatFocusesOnUsers(String nextOpenid) {
        try {
            AccessToken accessToken = accessTokenUtil.getAccessToken();
            String result = HttpUtil.get(StrUtil.format(WECHAT_FOCUSES_ON_USERS_URL, accessToken.getAccess_token(), nextOpenid));
            return JSONObject.parseObject(result, FocusesUser.class);
        }catch (Exception e){
            e.printStackTrace();
            log.error("获取微信关注用户列表失败！{}",e.getMessage());
        }
        return null;
    }

    /**
     * 获取微信用户详情信息
     * @param openid 用户openid
     * @return
     */
    public UserInfo getWechatUserInfo(String openid) {
       try {
           AccessToken accessToken = accessTokenUtil.getAccessToken();
           String result = HttpUtil.get(StrUtil.format(WECHAT_USER_INFO_URL, accessToken.getAccess_token(), openid));
           return JSONObject.parseObject(result, UserInfo.class);
       }catch (Exception e){
           e.printStackTrace();
           log.error("获取微信用户详情信息失败！{}",e.getMessage());
       }
       return null;
    }

    /**
     * 批量获取用户详情信息
     * @return
     */
    public BatchgetUserInfo getBatchgetUserInfo(BatchgetUserInfoRes batchgetRes) {
        try {
            AccessToken accessToken = accessTokenUtil.getAccessToken();
            String result = HttpUtil.post(StrUtil.format(WECHAT_USER_INFO_BATCHGET_URL, accessToken.getAccess_token()), JSONObject.toJSONString(batchgetRes));
            return JSONObject.parseObject(result,BatchgetUserInfo.class);
        }catch (Exception e){
            e.printStackTrace();
            log.error("批量获取用户详情信息失败！{}",e.getMessage());
        }
        return null;
    }
}
