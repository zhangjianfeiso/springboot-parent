package com.example.wechat.controller;

import com.example.common.bean.Response;
import com.example.wechat.service.CustomService;
import com.example.wechat.vo.CustomVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/custom")
@CrossOrigin
public class CustomController {
    @Autowired
    private CustomService customService;
    @GetMapping("/list")
    public Response<List<CustomVo>> index(){
        return Response.ok(customService.list());
    }

    @GetMapping("/detail")
    public Response<List> detail(){
        return Response.ok(customService.detail());
    }
}
