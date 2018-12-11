package com.example.wechat.service;

import com.example.wechat.vo.CustomDetailVo;
import com.example.wechat.vo.CustomVo;

import java.util.List;

public interface CustomService {

    List<CustomVo> list();

    List<CustomDetailVo> detail();
}
