package com.example.user.modules.user.controller;

import cn.hutool.core.util.RandomUtil;
import com.example.common.bean.Response;
import com.example.user.modules.user.vo.UserVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjf
 * @Date 2018/8/22  15:03
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/list")
    public Response<List<UserVo>> selectList(){
        UserVo vo = new UserVo();
        vo.setId(RandomUtil.randomString(32));
        vo.setName("张三");
        List<UserVo> list = new ArrayList<>();
        list.add(vo);
        return Response.ok(list);
    }
}
