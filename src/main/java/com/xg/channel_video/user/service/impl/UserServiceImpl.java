package com.xg.channel_video.user.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.xg.channel_video.login.service.impl.LoginServiceImpl;
import com.xg.channel_video.user.entity.UpdateUserImgParam;
import com.xg.channel_video.user.mapper.UserMapper;
import com.xg.channel_video.user.service.IUserService;
import com.xg.channel_video.utils.DownloadFileUtils;
import com.xg.channel_video.utils.ResultUtils;
import com.xg.channel_video.video.service.impl.VideoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: channel_video
 * @description: 用户
 * @author: gzk
 * @create: 2020-01-13 11:22
 **/
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public JSONObject updateUserImg(UpdateUserImgParam param) {

        //保存头像
        String userImgPath = VideoServiceImpl.USER_IMG_ + DownloadFileUtils.downloadFileUtils(param.getUserImg(), VideoServiceImpl.USER_IMG_FILE_URL, param.getUserId());

        //修改数据库
        userMapper.updateUserImg(param.getUserId(),userImgPath);

        //修改图片缓存
        LoginServiceImpl.USER_IMG.put(param.getUserId(),userImgPath);

        return ResultUtils.resultSuccessMsg(new JSONObject(), "修改头像成功！！");
    }
}
