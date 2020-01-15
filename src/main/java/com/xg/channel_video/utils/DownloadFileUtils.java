package com.xg.channel_video.utils;

import jdk.nashorn.internal.ir.ReturnNode;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @program: channel_video
 * @description: 下载文件到本地
 * @author: gzk
 * @create: 2020-01-14 11:37
 **/
public class DownloadFileUtils {


    public static synchronized String downloadFileUtils(MultipartFile file, String path,String userId){
        OutputStream os = null;
        InputStream inputStream = null;
        String fileName = null;
        String filePath = "";
        try {
            inputStream = file.getInputStream();
            fileName = file.getOriginalFilename();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            // 2、保存到临时文件
            // 100M的数据缓冲
            byte[] bs = new byte[1024 * 1024 * 10 * 10];
            // 读取到的数据长度
            int len;
            // 输出的文件流保存到本地文件
            File tempFile = new File(path);
            if (!tempFile.exists()) {
                tempFile.mkdirs();
            }
            fileName = userId + fileName;
            filePath = tempFile.getPath() + File.separator + fileName;
            os = new FileOutputStream(filePath);
            // 开始读取
            while ((len = inputStream.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 完毕，关闭所有链接
            try {
                os.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fileName;
    }

}
