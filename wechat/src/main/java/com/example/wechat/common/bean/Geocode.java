package com.example.wechat.common.bean;

import lombok.Data;

import java.util.List;

/**
 * @author zhangjf
 * @Date 2019/1/15  15:42
 */
@Data
public class Geocode {

    private String formatted_address;
    private String country;
    private String province;
    private String citycode;
    private String city;
    private String district;
    private List<String> township;
    private Neighborhood neighborhood;
    private Neighborhood building;
    private String adcode;
    private List<String> street;
    private List<String> number;
    private String location;
    private String level;
}
