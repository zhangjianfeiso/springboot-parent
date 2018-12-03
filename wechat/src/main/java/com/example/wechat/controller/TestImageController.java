package com.example.wechat.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.thread.ThreadUtil;
import org.apache.catalina.connector.ClientAbortException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author zhangjf
 * @Date 2018/12/3  14:42
 */
@Controller
@RequestMapping("/img")
public class TestImageController {

    @RequestMapping("/download")
    public void download(HttpServletRequest request, HttpServletResponse response) {
        ThreadUtil.sleep(3000);

        File file = new File("C:\\Users\\DELL\\Desktop\\images\\8575840_114126243000_2.jpg");
        if (FileUtil.isFile(file) && FileUtil.exist(file)) {
            response.setHeader("content-type", "application/octet-stream");
            response.setContentType("image/jpeg");
            response.setHeader("Content-Disposition", "attachment;filename=" + file.getName());
            OutputStream os = null;
            BufferedInputStream bis = null;
            try {
                os = response.getOutputStream();
                bis = new BufferedInputStream(new FileInputStream(file));
                IoUtil.copy(bis, os, 1024);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                if(null != os){
                    try {
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(null != bis){
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println("=============>");
    }
}
