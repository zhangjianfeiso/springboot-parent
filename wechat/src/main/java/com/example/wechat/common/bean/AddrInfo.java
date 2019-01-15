package com.example.wechat.common.bean;

import lombok.Data;

import java.util.List;

/**
 * @author zhangjf
 * @Date 2019/1/15  15:41
 */
@Data
public class AddrInfo {
    private int status;
    private String info;
    private long infocode;
    private int count;
    private List<Geocode> geocodes;

}
