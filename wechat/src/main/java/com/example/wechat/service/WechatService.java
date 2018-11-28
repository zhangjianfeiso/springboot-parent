package com.example.wechat.service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhangjf
 * @Date 2018/11/28  14:47
 */
public interface WechatService {

    String processRequest(HttpServletRequest request);
}
