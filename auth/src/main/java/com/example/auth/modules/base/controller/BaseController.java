package com.example.auth.modules.base.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangjf
 * @Date 2018/8/21  14:50
 */
@RestController
@RequestMapping("/base")
public class BaseController {

    @GetMapping("/index")
    public String index(){
        return "hello world !";
    }
}
