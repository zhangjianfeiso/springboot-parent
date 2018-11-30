package com.example.wechat.common.vo;

import lombok.Data;

/**
 * @author zhangjf
 * @Date 2018/11/30  9:02
 */
@Data
public class QrConfigVo {

    private String timestamp; //时间戳
    private String nonceStr;  //随机字符串
    private String signature; //加密后的字符串
}
