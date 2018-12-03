package com.example.wechat.api;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.example.wechat.common.bean.Constant;
import com.example.wechat.common.bean.JsapiTicket;
import com.example.wechat.common.bean.RequestCode;
import com.example.wechat.common.utils.RedisUtil;
import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * jssdk  api
 * @author zhangjf
 * @Date 2018/11/30  11:14
 */
@Component
@Slf4j
public class JsapiTicketApi {

    private static final String JSAPI_TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token={}&type=jsapi";
    @Autowired
    private RedisUtil redisUtil;


    public synchronized JsapiTicket getJsapiTicket(String accessToken){
        JsapiTicket jsapiTicket = (JsapiTicket) redisUtil.get(Constant.JSAPI_TICKET);
        if(null != jsapiTicket){
            return jsapiTicket;
        }
        return generate(accessToken);
    }

    public JsapiTicket generate(String accessToken){
        try {
            String result = HttpUtil.get(StrUtil.format(JSAPI_TICKET_URL, accessToken));
            if(StringUtils.isNotBlank(result)){
                JsapiTicket jsapiTicket = JSONObject.parseObject(result, JsapiTicket.class);
                if(null != jsapiTicket && jsapiTicket.getErrcode() == RequestCode.SUCCESS.getCode()){
                    redisUtil.set(Constant.JSAPI_TICKET,jsapiTicket,jsapiTicket.getExpires_in());
                    return jsapiTicket;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("生成jsapi_ticket失败！{}",e.getMessage());
        }
        return null;
    }
}
