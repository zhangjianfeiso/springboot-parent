package com.example.wechat.controller;


import cn.hutool.core.util.RandomUtil;
import com.example.common.bean.HttpStatus;
import com.example.common.bean.Response;
import com.example.wechat.service.HouseService;
import com.example.wechat.vo.HouseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@Controller
@RequestMapping("/home")
@CrossOrigin
public class HomeController {

    @Autowired
    private HouseService houseService;

    @GetMapping("/list")
    @ResponseBody
    public Response<List<HouseVo>> index(){
        return Response.ok(houseService.list());
    }
    String url = "C:\\Users\\ZHANG_JIAN_FEI\\Desktop\\图片\\";
    @GetMapping("/download")
    public void download(HttpServletRequest request, HttpServletResponse response){
        String fileUrl = url + RandomUtil.randomInt(1,4) + ".jpg";
        if (fileUrl != null) {
            File file = new File(fileUrl);
            if (file.exists()) {
                response.setContentType("image/png");// 设置强制下载不打开
                response.addHeader("Content-Disposition",
                        "attachment;fileName=" + file.getName());// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;

                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
