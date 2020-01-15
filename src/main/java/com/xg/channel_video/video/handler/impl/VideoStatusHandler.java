package com.xg.channel_video.video.handler.impl;

import com.alibaba.fastjson.JSONObject;
import com.xg.channel_video.utils.SendHandlerUtils;
import com.xg.channel_video.config.StrategyConfig;
import com.xg.channel_video.video.handler.Handler;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.websocket.Session;
import java.net.SocketTimeoutException;

/**
 * @program: vodeowebsocket
 * @description: 播放状态处理
 * @author: gzk
 * @create: 2020-01-09 14:14
 **/
@Component
public class VideoStatusHandler implements Handler, InitializingBean {


    //public static  Map<Integer , String> CHANNEL_VIDEO_STATUS = new ConcurrentHashMap<>();



    @Override
    public void handler(JSONObject content, Session session, Integer videoId) {
        String status = content.getString("status");
        //CHANNEL_VIDEO_STATUS.put(videoId,status);
        SendHandlerUtils.sendHandler("videoStatus",status,videoId);
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        StrategyConfig.HANDLER_STRATEGY.put("video",this);
    }

    public static void main(String[] args) {
        try {
            if(false){
                throw new SocketTimeoutException();
            }
            System.out.println("正常处理");
        } catch (SocketTimeoutException e) {
            System.out.println("超时处理");
        }
    }

}
