package com.example.wechat.vo;

import lombok.Data;

@Data
public class CustomVo {
    private String id;
    private String name;
    private String mobile;
    private String addr;
    private String img;


    private long subscribe;
    private long visit;
    private long recognition;
    private long buy;

}
