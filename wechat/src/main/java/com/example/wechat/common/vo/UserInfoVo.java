package com.example.wechat.common.vo;


import lombok.Data;

@Data
public class UserInfoVo {

    private String openid;	            //用户的标识，对当前公众号唯一
    private String nickname;	        //用户的昵称
    private int identity; //身份  1.普通会员  2.经纪人
}
