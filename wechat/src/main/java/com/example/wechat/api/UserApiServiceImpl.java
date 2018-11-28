package com.example.wechat.api;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.example.wechat.api.service.UserApiService;
import com.example.wechat.common.bean.*;
import com.example.wechat.common.utils.AccessTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangjf
 * @Date 2018/11/28  9:28
 */
@Service
public class UserApiServiceImpl implements UserApiService {
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

    @Override
    public FocusesUser getWechatFocusesOnUsers(String nextOpenid) {
        AccessToken accessToken = accessTokenUtil.getAccessToken();
        String result = HttpUtil.get(StrUtil.format(WECHAT_FOCUSES_ON_USERS_URL, accessToken.getAccess_token(), nextOpenid));
        return JSONObject.parseObject(result, FocusesUser.class);
    }

    @Override
    public UserInfo getWechatUserInfo(String openid) {
        AccessToken accessToken = accessTokenUtil.getAccessToken();
        String result = HttpUtil.get(StrUtil.format(WECHAT_USER_INFO_URL, accessToken.getAccess_token(), openid));
        return JSONObject.parseObject(result, UserInfo.class);
    }

    @Override
    public BatchgetUserInfo getBatchgetUserInfo(BatchgetUserInfoRes batchgetRes) {
        AccessToken accessToken = accessTokenUtil.getAccessToken();
        String result = HttpUtil.post(StrUtil.format(WECHAT_USER_INFO_BATCHGET_URL, accessToken.getAccess_token()), JSONObject.toJSONString(batchgetRes));
        return JSONObject.parseObject(result,BatchgetUserInfo.class);
    }


}
