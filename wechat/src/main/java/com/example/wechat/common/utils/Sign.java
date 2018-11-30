package com.example.wechat.common.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.thread.ThreadUtil;
import com.example.wechat.common.vo.QrConfigVo;
import com.example.wechat.common.vo.WxConfigVo;
import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.UUID;

public class Sign {

    private static final String QR_CONFIG_TICKET = "acb8c5d8a82886fec742e8df1d9422a9dad823fe";
    /**
     * 过期时间
     */
    private static final Long EXPIRES_IN = 60L;

    /**
     * 验证是否过期
     * @param signature
     * @param noncestr
     * @param timestamp
     * @return  true为过期，false未过期
     */
    public static boolean qrSignIsExpires(String signature,String noncestr,String timestamp){
        if(StringUtils.isBlank(signature) || StringUtils.isBlank(noncestr) || StringUtils.isBlank(timestamp)){
            return true;
        }
        if(!signature.equals(qrConfigSign(noncestr,timestamp))){
            return true;
        }
        if(EXPIRES_IN.compareTo(DateUtil.currentSeconds() - Long.valueOf(timestamp)) < 0){
            return true;
        }
        return false;
    }


    public static QrConfigVo qrConfigSign(){
        QrConfigVo vo = new QrConfigVo();
        String nonce_str = create_nonce_str();
        String timestamp = create_timestamp();
        String signature = qrConfigSign(nonce_str, timestamp);
        vo.setNonceStr(nonce_str);
        vo.setSignature(signature);
        vo.setTimestamp(timestamp);
        return vo;
    }

    public static String qrConfigSign(String nonce_str, String timestamp) {
        String string1;
        String signature = "";
        // 注意这里参数名必须全部小写，且必须有序
        string1 = "qr_config_ticket=" + QR_CONFIG_TICKET + "&noncestr=" + nonce_str
                + "&timestamp=" + timestamp + "&expires_in=" + EXPIRES_IN;
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(string1.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return signature;
    }


    public static WxConfigVo wxConfigSign(String jsapi_ticket, String appId, String url) {
        WxConfigVo vo = new WxConfigVo();
        String nonce_str = create_nonce_str();
        String timestamp = create_timestamp();
        String string1;
        String signature = "";
        // 注意这里参数名必须全部小写，且必须有序
        string1 = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + nonce_str
                + "&timestamp=" + timestamp + "&url=" + url;
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(string1.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //注意这里 要加上自己的appId
        vo.setAppId(appId);
        vo.setNonceStr(nonce_str);
        vo.setSignature(signature);
        vo.setTimestamp(timestamp);
        return vo;
    }

    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
    private static String create_nonce_str() {
        return UUID.randomUUID().toString();
    }
    private static String create_timestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);

    }
}
