package com.example.wechat.vo;


import lombok.Data;

@Data
public class HouseVo {
    private String id;
    private String img;
    private String name;
    private String area;
    private String type;
    private String mobile;
    private boolean collect;
}
