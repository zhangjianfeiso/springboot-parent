package com.example.user.modules.base.controller;

import cn.hutool.core.util.RandomUtil;
import com.example.common.bean.Response;
import com.example.common.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjf
 * @Date 2018/8/22  14:49
 */
@RestController
@Slf4j
public class LoginController {

    @PostMapping("/login")
    public Response login(String username,String password){
        String token = JwtUtil.generateToken(RandomUtil.randomString(32), username);
        log.info("token:{}",token);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("token",token);
        Response<Object> response = Response.ok();
        response.setExt(map);
        return response;
    }
}
