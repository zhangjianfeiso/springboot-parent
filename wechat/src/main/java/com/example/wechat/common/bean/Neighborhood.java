package com.example.wechat.common.bean;

import lombok.Data;

import java.util.List;

/**
 * @author zhangjf
 * @Date 2019/1/15  15:43
 */
@Data
public class Neighborhood {
    private List<String> name;
    private List<String> type;
}
