package com.example.wechat.service.impl;

import cn.hutool.core.lang.ObjectId;
import cn.hutool.core.util.RandomUtil;
import com.example.wechat.service.CustomService;
import com.example.wechat.vo.CustomDetailVo;
import com.example.wechat.vo.CustomVo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomServiceImpl implements CustomService {

    String[] names = new String[]{"张xxx","李xxx","王xxx","黄xxx","刘xxx"};
    @Override
    public List<CustomVo> list() {
        List<CustomVo> list = new ArrayList<>();
        for(int x=0; x<15; x++){
            CustomVo vo = new CustomVo();
            vo.setId(ObjectId.next());
            vo.setAddr("广东省 广州市 天河区");
            vo.setMobile("1855xxxxxxx");
            vo.setName(names[RandomUtil.randomInt(0,5)]);
            vo.setImg("../../../static/images/t"+ RandomUtil.randomInt(1,7) +".jpg");
            vo.setSubscribe(RandomUtil.randomLong(0,100));
            vo.setRecognition(RandomUtil.randomLong(0,100));
            vo.setVisit(RandomUtil.randomLong(0,100));
            vo.setBuy(RandomUtil.randomLong(0,100));

            list.add(vo);
        }
        return list;
    }

    List<String> houses = new ArrayList<String>(){{
        add("xx金色领域");
        add("融xxx首府");
        add("豪xx尚城");
        add("云xxx海湾");
        add("利xxxxx湾半岛");
    }};
    List<String> areas = new ArrayList<String>(){{
        add("广州市");
        add("东莞市");
        add("深圳市");
        add("佛山市");
        add("肇庆市");
    }};
    List<String> types = new ArrayList<String>(){{
        add("公寓");
        add("住宅");
        add("别墅");
        add("商铺");
        add("车库");
    }};

    @Override
    public List<CustomDetailVo> detail() {
        List<CustomDetailVo> list = new ArrayList<>();
        for(int x=0; x<15; x++){
            CustomDetailVo vo = new CustomDetailVo();
            vo.setId(ObjectId.next());
            vo.setArea(areas.get(RandomUtil.randomInt(0,5)));
            vo.setHouseName(houses.get(RandomUtil.randomInt(0,5)));
            vo.setMobile("189xxxxxxxx");
            vo.setName(names[RandomUtil.randomInt(0,5)]);
            vo.setPrice(RandomUtil.randomLong(10000,20000) + "元/平米");
            vo.setType(types.get(RandomUtil.randomInt(0,5)));
            vo.setImg("../../../static/images/a"+ RandomUtil.randomInt(1,7) +".jpg");
            list.add(vo);
        }
        return list;
    }
}
