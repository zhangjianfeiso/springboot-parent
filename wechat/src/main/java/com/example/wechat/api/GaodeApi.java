package com.example.wechat.api;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.example.wechat.common.bean.AddrInfo;

/**
 * @author zhangjf
 * @Date 2019/1/15  15:34
 */
public class GaodeApi {

    private static final String GEO_URL = "http://restapi.amap.com/v3/geocode/geo?address={}&output=JSON&key={}";

    /**
     * 根据地址获取经纬度
     * @param addr  具体地址
     * @param key   高德key  0c013be0b4a7c35e747ed980b06f7e90
     * @return
     */
    public static AddrInfo getAddrInfo(String addr,String key){
        String result = HttpUtil.get(StrUtil.format(GEO_URL,addr,key));
        AddrInfo addrInfo = JSONObject.parseObject(result, AddrInfo.class);
        return addrInfo;
    }

}
