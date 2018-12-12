package com.example.wechat.controller;

import cn.hutool.core.lang.ObjectId;
import cn.hutool.core.util.RandomUtil;
import com.example.common.bean.Response;
import com.example.wechat.vo.RecordsVo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjf
 * @Date 2018/12/12  9:40
 */
@RestController
@RequestMapping("/records")
@CrossOrigin
public class RecordsController {

    List<String> houses = new ArrayList<String>(){{
        add("xx金色领域");
        add("融xxx首府");
        add("豪xx尚城");
        add("云xxx海湾");
        add("利xxxxx湾半岛");
    }};

    List<String> addrs = new ArrayList<String>(){{
        add("-广州");
        add("-深圳");
        add("-东莞");
        add("-佛山");
        add("-上海");
        add("-北京");
        add("-武汉");
    }};

    @GetMapping("/list")
    public Response<List<RecordsVo>> list(){
        List<RecordsVo> list = new ArrayList<>();
        for(int x=0; x<20; x++){
            RecordsVo vo = new RecordsVo();
            vo.setId(ObjectId.next());
            vo.setName(houses.get(RandomUtil.randomInt(0,5)) + addrs.get(RandomUtil.randomInt(0,7)));
            list.add(vo);
        }
        return Response.ok(list);
    }
}
