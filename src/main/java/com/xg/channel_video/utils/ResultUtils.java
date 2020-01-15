package com.xg.channel_video.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * @program: channel_video
 * @description: 错误返回
 * @author: gzk
 * @create: 2020-01-13 11:31
 **/
public class ResultUtils {


    public static JSONObject resultErrorMsg(JSONObject param, Exception e){
        param.put("code",500);
        param.put("msg",e);
        return param;
    }

    public static JSONObject resultErrorMsg(JSONObject param, String errorMessage){
        param.put("code",500);
        param.put("msg",errorMessage);
        return param;
    }


    public static JSONObject resultSuccessMsg(JSONObject param, String successMessage){
        param.put("code",200);
        param.put("msg",successMessage);
        return param;
    }

    public static JSONObject resultSuccessDataMsg(JSONObject param, String successMessage, String data){
        param.put("code",200);
        param.put("msg",successMessage);
        param.put("data", data);
        return param;
    }

    public static JSONObject resultSuccessDataMsg(JSONObject param, String successMessage, JSONObject data){
        param.put("code",200);
        param.put("msg",successMessage);
        param.put("data", data);
        return param;
    }





    public static JSONObject resultSuccessMsg(JSONObject param, String code, String successMessage){
        param.put("code",code);
        param.put("msg",successMessage);
        return param;
    }
}
