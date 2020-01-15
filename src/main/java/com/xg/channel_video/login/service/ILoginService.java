package com.xg.channel_video.login.service;

import com.alibaba.fastjson.JSONObject;
import com.xg.channel_video.login.entity.LoginParamEntity;
import com.xg.channel_video.login.entity.RegisterParamEntity;

import javax.servlet.http.HttpServletRequest;

public interface ILoginService {

    //注册用户
    JSONObject registerUser(RegisterParamEntity param);

    //登陆
    JSONObject login(LoginParamEntity param, HttpServletRequest request);
}
