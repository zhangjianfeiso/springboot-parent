package com.example.wechat.api.service;

import com.example.wechat.common.bean.BatchgetUserInfoRes;
import com.example.wechat.common.bean.BatchgetUserInfo;
import com.example.wechat.common.bean.FocusesUser;
import com.example.wechat.common.bean.UserInfo;

/**
 * @author zhangjf
 * @Date 2018/11/28  9:11
 */
public interface UserApiService {
    /**
     * 获取微信关注用户列表
     * @param nextOpenid    从哪个openid开始，空为默认从第一个开始
     * @return
     */
    FocusesUser getWechatFocusesOnUsers(String nextOpenid);

    /**
     * 获取微信用户详情信息
     * @param openid 用户openid
     * @return
     */
    UserInfo getWechatUserInfo(String openid);

    /**
     * 批量获取用户详情信息
     * @return
     */
    BatchgetUserInfo getBatchgetUserInfo(BatchgetUserInfoRes batchgetRes);
}
