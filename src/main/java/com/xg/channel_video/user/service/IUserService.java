package com.xg.channel_video.user.service;

import com.alibaba.fastjson.JSONObject;
import com.xg.channel_video.user.entity.UpdateUserImgParam;

public interface IUserService {

    /**
     * 用户修改头像
     */
    JSONObject updateUserImg(UpdateUserImgParam param);
}
