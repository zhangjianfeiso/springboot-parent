package com.example.wechat.controller;

import cn.hutool.core.lang.ObjectId;
import com.example.common.bean.Response;
import com.example.wechat.common.bean.WechatProperties;
import com.example.wechat.common.utils.WechatUtil;
import com.example.wechat.common.vo.UserInfoVo;
import com.example.wechat.service.WechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhangjf
 * @Date 2018/11/28  14:46
 */
@Controller
@RequestMapping("/api")
@CrossOrigin
public class WechatController {

    @Autowired
    private WechatService wechatService;
    @Autowired
    private WechatProperties wechatProperties;

    /**
     * 处理微信服务器发来的get请求，进行签名的验证
     *
     * signature 微信端发来的签名
     * timestamp 微信端发来的时间戳
     * nonce     微信端发来的随机字符串
     * echostr   微信端发来的验证字符串
     */
    @GetMapping("/wx")
    @ResponseBody
    public String validate(@RequestParam(value = "signature") String signature,
                           @RequestParam(value = "timestamp") String timestamp,
                           @RequestParam(value = "nonce") String nonce,
                           @RequestParam(value = "echostr") String echostr) {
        return WechatUtil.checkSignature(wechatProperties.getToken(),signature, timestamp, nonce) ? echostr : null;

    }
    /**
     * 此处是处理微信服务器的消息转发的
     */
    @PostMapping("/wx")
    @ResponseBody
    public String processMsg(HttpServletRequest request) {
        // 调用核心服务类接收处理请求
        return wechatService.processRequest(request);
    }

    /**
     * 根据Code换取openid
     * @param code
     * @return
     */
    @PostMapping("/openid")
    @ResponseBody
    public Response getOpenid(String code){
        return Response.ok(wechatService.getOpenid(code));
    }

}
