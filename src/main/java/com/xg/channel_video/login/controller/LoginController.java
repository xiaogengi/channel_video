package com.xg.channel_video.login.controller;

import com.alibaba.fastjson.JSONObject;
import com.xg.channel_video.login.entity.LoginParamEntity;
import com.xg.channel_video.login.entity.RegisterParamEntity;
import com.xg.channel_video.login.service.ILoginService;
import com.xg.channel_video.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: channel_video
 * @description: 登陆
 * @author: gzk
 * @create: 2020-01-13 17:39
 **/
@RestController
@RequestMapping("login")
public class LoginController {


    @Autowired
    private ILoginService loginService;

    @RequestMapping("register")
    public JSONObject register(RegisterParamEntity param){
        JSONObject result = new JSONObject();
        try {
            result = loginService.registerUser(param);
        } catch (Exception e){
            e.printStackTrace();
            result = ResultUtils.resultErrorMsg(result,e);
        }
        return result;
    }


    @RequestMapping("login")
    public JSONObject login(LoginParamEntity param, HttpServletRequest request){
        JSONObject result = new JSONObject();
        try {
            result = loginService.login(param, request);
        } catch (Exception e){
            e.printStackTrace();
            result = ResultUtils.resultErrorMsg(result,e);
        }
        return result;
    }




}
