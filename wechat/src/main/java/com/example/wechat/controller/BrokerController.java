package com.example.wechat.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.ObjectId;
import cn.hutool.core.util.RandomUtil;
import com.example.common.bean.Response;
import com.example.wechat.vo.BrokerVo;
import com.sun.corba.se.pept.broker.Broker;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjf
 * @Date 2018/12/12  10:32
 */
@RestController
@RequestMapping("/broker")
@CrossOrigin
public class BrokerController {

    String[] names = new String[]{"张xxx","李xxx","王xxx","黄xxx","刘xxx"};

    @GetMapping("/list")
    public Response<List<BrokerVo>> list(){
        List<BrokerVo> list = new ArrayList<>();
        for(int x=0; x<15; x++){
            BrokerVo vo = new BrokerVo();
            vo.setId(ObjectId.next());
            vo.setMobile("185xxxxxxxx");
            vo.setCustoms(RandomUtil.randomLong(20,2000) + "个");
            vo.setDate(DateUtil.now());
            vo.setHouses(RandomUtil.randomLong(200,2000) + "套");
            vo.setName(names[RandomUtil.randomInt(0,5)]);
            vo.setImg("../../../static/images/t"+ RandomUtil.randomInt(1,7) +".jpg");
            list.add(vo);
        }
        return Response.ok(list);
    }
}
