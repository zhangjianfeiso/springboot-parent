package com.example.wechat.service.impl;

import cn.hutool.core.lang.ObjectId;
import cn.hutool.core.util.RandomUtil;
import com.example.wechat.service.HouseService;
import com.example.wechat.vo.HouseVo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {

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
    public List<HouseVo> list() {
        List<HouseVo> list = new ArrayList<>();
        for(int x=0; x<10; x++){
            int random = RandomUtil.randomInt(0,5);
            HouseVo vo = new HouseVo();
            vo.setId(ObjectId.next());
            vo.setName(houses.get(random));
            vo.setArea(areas.get(random));
            vo.setCollect(random%2 == 0);
            vo.setImg("../../../static/images/a"+ RandomUtil.randomInt(1,7) +".jpg");
            vo.setMobile("400-xxx-xxxxxx");
            vo.setType(types.get(random));
            list.add(vo);
        }
        return list;
    }
}
