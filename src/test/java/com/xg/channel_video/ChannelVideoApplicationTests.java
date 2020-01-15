package com.xg.channel_video;

import com.xg.channel_video.user.mapper.UserMapper;
import com.xg.channel_video.user.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class ChannelVideoApplicationTests {


    @Autowired
    private IUserService userService;

    @Autowired
    private UserMapper userMapper;


    private static Map map = new HashMap();

    @Test
    void contextLoads() {
        for (int i = 0; i < 1000; i++) {
        }


        System.out.println("map: = "+ map);
    }

    @Test
    void testAccount(){


    }

}
