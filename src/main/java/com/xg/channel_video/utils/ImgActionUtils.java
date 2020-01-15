package com.xg.channel_video.utils;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @program: channel_video
 * @description: 查看图片
 * @author: gzk
 * @create: 2020-01-14 14:49
 **/
public class ImgActionUtils {

    public static void getImg(String imgPath, HttpServletResponse response) throws Exception{
        //读取本地图片输入流
        FileInputStream inputStream = new FileInputStream(imgPath);
        int i = inputStream.available();
        //byte数组用于存放图片字节数据
        byte[] buff = new byte[i];
        inputStream.read(buff);
        //记得关闭输入流
        inputStream.close();
        //设置发送到客户端的响应内容类型
        response.setContentType("image/*");
        OutputStream out = response.getOutputStream();
        out.write(buff);
        //关闭响应输出流
        out.close();
    }



}
