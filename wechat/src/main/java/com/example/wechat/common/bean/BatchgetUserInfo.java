package com.example.wechat.common.bean;

import lombok.Data;

import java.util.List;

/**
 * @author zhangjf
 * @Date 2018/11/28  11:02
 */
@Data
public class BatchgetUserInfo {
    private List<UserInfo> user_info_list;
}
