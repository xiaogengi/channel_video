package com.xg.channel_video.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.xg.channel_video.user.entity.UpdateUserImgParam;
import com.xg.channel_video.user.service.IUserService;
import com.xg.channel_video.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: channel_video
 * @description: 用户
 * @author: gzk
 * @create: 2020-01-13 11:20
 **/
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 用户修改头像
     * @param param
     * @return
     */
    @RequestMapping("updateUserImg")
    public JSONObject updateUserImg(UpdateUserImgParam param, HttpServletRequest request){
        try {
            param.setUserId(request.getSession().getAttribute("userId").toString());
            return userService.updateUserImg(param);
        } catch (Exception e){
            e.printStackTrace();
            return ResultUtils.resultErrorMsg(new JSONObject(), e);
        }
    }




}
