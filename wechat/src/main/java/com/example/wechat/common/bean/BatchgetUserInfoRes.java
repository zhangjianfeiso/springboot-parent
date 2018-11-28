package com.example.wechat.common.bean;

import lombok.Data;

import java.util.List;

/**
 * @author zhangjf
 * @Date 2018/11/28  11:00
 */
@Data
public class BatchgetUserInfoRes {

    private List<Data> user_list;

    @lombok.Data
    public static class Data{
        private String openid;
        private String lang;

        public Data() {
        }

        public Data(String openid, String lang) {
            this.openid = openid;
            this.lang = lang;
        }
    }
}
