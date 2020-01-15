package com.xg.channel_video.user.service.impl;

import com.xg.channel_video.user.mapper.UserMapper;
import com.xg.channel_video.user.service.IUserService;
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


}
