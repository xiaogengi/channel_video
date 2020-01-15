package com.xg.channel_video.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.util.Base64;

/**
 * @program: channel_video
 * @description: 加密 解密
 * @author: gzk
 * @create: 2020-01-13 17:24
 **/
public class Md5Utils {

    public static void main(String[] args) {
        System.out.println(encode("gogogo"));
    }

    /**
     * 加密
     * @param code
     * @return
     */
    public static String encode(String code) {
        try {
            BASE64Encoder base64 = new BASE64Encoder();
            return base64.encode(code.getBytes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 解密
     * @param code
     * @return
     */
    public static String decode(String code){
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            return new String(decoder.decodeBuffer(code),"UTF-8");
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
