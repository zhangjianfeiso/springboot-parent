package com.example.common.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjf
 * @Date 2018/8/21  15:08
 */
@Slf4j
public class JwtUtil {

    private static final String JWT_SECRET = "springboot-parent";

    public static String generateToken(String uid,String username) {
        return generateToken(uid,username,null);
    }
    public static String generateToken(String uid,String username,Long expire) {
        Map<String, Object> heads = new HashMap<>();
        heads.put("alg", "HS256");
        heads.put("type", "JWT");
        LocalDateTime localDateTime = LocalDateTime.now();
        Date createDate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        Date expDate = null;
        if(null == expire) {//默认24小时
             expDate = Date.from(localDateTime.plusHours(24).atZone(ZoneId.systemDefault()).toInstant());
        }else{
             expDate = DateUtil.date(createDate.getTime() + expire * 1000);
        }
        String token = "";
        try {
            token = JWT.create().withHeader(heads)
                    .withClaim("uid", uid)
                    .withClaim("key", RandomUtil.randomString(32))
                    .withIssuedAt(createDate)
                    .withExpiresAt(expDate)
                    .withIssuer("zhangjianfeiso@163.com")
                    .withSubject(username)
                    .sign(Algorithm.HMAC256(JWT_SECRET));

        } catch (UnsupportedEncodingException e) {
            log.error("签名发生错误，无法进入系统");
        } catch (Exception e){
            log.error("签名发生错误，无法进入系统");
        }
        return token;
    }


    public static boolean isExpire(String token) {
        DecodedJWT decodedJWT = parseToken(token);
        if(decodedJWT!=null){
            Date now = new Date();
            if (now.after(decodedJWT.getExpiresAt())) {
                return true;
            }
            return false;
        }
        return true;
    }


    public static DecodedJWT parseToken(String token) {
        return parseToken(null,token);
    }

    public static DecodedJWT parseToken(String secret,String token) {
        try {
            if(StrUtil.isBlank(secret)){
                secret = JWT_SECRET;
            }
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret)).build();
            return verifier.verify(token);
        } catch (UnsupportedEncodingException e) {
            log.error("无法验证签名的正确性");
        } catch (TokenExpiredException e){
            log.error("token过期");
        } catch (Exception e){
            log.error("无法验证签名的正确性");
        }
        return null;
    }

    public static String getKey(DecodedJWT decodedJWT) {
        if(decodedJWT!=null){
            Map<String, Claim> c = decodedJWT.getClaims();
            return c.get("key").asString();
        }
        return "";
    }
    public static String getUid(DecodedJWT decodedJWT){
        if(decodedJWT!=null){
            Map<String, Claim> c = decodedJWT.getClaims();
            return c.get("uid").asString();
        }
        return "";
    }
    public static String getUsername(DecodedJWT decodedJWT) {
        if(decodedJWT!=null){
            return decodedJWT.getSubject();
        }
        return "";
    }

}
