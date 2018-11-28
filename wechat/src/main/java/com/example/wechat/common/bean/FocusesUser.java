package com.example.wechat.common.bean;

import lombok.Data;
import java.util.List;

/**
 * 微信关注用户
 * @author zhangjf
 * @Date 2018/11/28  9:13
 */
@Data
public class FocusesUser extends BaseRequest{
    private int total;
    private int count;
    private String next_openid;
    private List<Data> data;


    @lombok.Data
    public class Data{
        private List<String> openid;
    }
}
