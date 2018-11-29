package com.example.wechat.controller;

import com.example.common.bean.Response;
import com.example.wechat.common.bean.AccessToken;
import com.example.wechat.common.bean.JsapiTicket;
import com.example.wechat.common.bean.WechatProperties;
import com.example.wechat.common.utils.AccessTokenUtil;
import com.example.wechat.common.utils.JsapiTicketUtil;
import com.example.wechat.common.utils.Sign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/wechat")
@CrossOrigin
public class JsSdkConfigController {

    @Autowired
    private AccessTokenUtil accessTokenUtil;
    @Autowired
    private JsapiTicketUtil jsapiTicketUtil;
    @Autowired
    private WechatProperties wechatProperties;

    @PostMapping("/config")
    @ResponseBody
    public Response config(String url){
        //url = "zhangjf.iask.in";
        AccessToken accessToken = accessTokenUtil.getAccessToken();
        JsapiTicket jsapiTicket = jsapiTicketUtil.getJsapiTicket(accessToken.getAccess_token());
        return Response.ok(Sign.sign(jsapiTicket.getTicket(),wechatProperties.getAppid(),url));
    }
}
