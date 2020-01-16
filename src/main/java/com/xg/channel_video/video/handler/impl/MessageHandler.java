package com.xg.channel_video.video.handler.impl;

import com.alibaba.fastjson.JSONObject;
import com.xg.channel_video.login.service.impl.LoginServiceImpl;
import com.xg.channel_video.utils.SendHandlerUtils;
import com.xg.channel_video.config.StrategyConfig;
import com.xg.channel_video.video.handler.Handler;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import javax.websocket.Session;
import java.time.LocalDateTime;

/**
 * @program: vodeowebsocket
 * @description: 消息处理
 * @author: gzk
 * @create: 2020-01-09 11:49
 **/
@Component
@EnableScheduling
public class MessageHandler implements Handler, InitializingBean {


    @Override
    public void handler(JSONObject content, Session session, Integer videoId) {
        String msg = content.getString("msg");
        String userName = content.getString("userName");
        String userId = content.getString("userId");
        String s = "<img src = '/getFile/"+ LoginServiceImpl.USER_IMG.get(userId) +"' width='30px' height='30px'>&nbsp;&nbsp;[ " +
                LocalDateTime.now() +" ] <font color = 'red'>"+ userName + "</font> : " + msg;
        //可以选择存库
        SendHandlerUtils.sendHandler("message", s, videoId,session);
    }




    @Override
    public void afterPropertiesSet() throws Exception {
        StrategyConfig.HANDLER_STRATEGY.put("message",this);
    }

}
