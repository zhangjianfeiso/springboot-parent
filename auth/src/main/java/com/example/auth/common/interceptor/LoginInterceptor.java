package com.example.auth.common.interceptor;


import cn.hutool.core.util.CharsetUtil;
import cn.hutool.http.ContentType;

import com.example.common.bean.HttpStatus;
import com.example.common.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhangjf
 * @Date 2018/8/22  10:55
 */
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("LoginInterceptor.preHandle");
        String token = request.getHeader("token");
        if(StringUtils.isBlank(token) || JwtUtil.isExpire(token)){  //未找到token /token过期
            response.setStatus(HttpStatus.UNAUTHORIZED.getCode());
            response.setCharacterEncoding(CharsetUtil.UTF_8);
            response.setContentType(ContentType.JSON.name());
            log.error("token为空或token过期！{}",token);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("LoginInterceptor.postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("LoginInterceptor.afterCompletion");
    }
}
