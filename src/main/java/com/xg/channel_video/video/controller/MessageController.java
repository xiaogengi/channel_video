package com.xg.channel_video.video.controller;

import com.alibaba.fastjson.JSONObject;
import com.xg.channel_video.utils.SendHandlerUtils;
import com.xg.channel_video.config.StrategyConfig;
import com.xg.channel_video.video.entity.RequestMessageEntity;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: vodeowebsocket
 * @description: 消息层
 * @author: gzk
 * @create: 2020-01-09 10:45
 **/
@Component
@ServerEndpoint("/MessageWebsocket/{videoId}")
public class MessageController {

    //public static List<Session> SESSION_LIST  = new ArrayList<>();
    public static Map<Integer, List<Session>> VIDEO_SESSION_MAP = new ConcurrentHashMap<>();


    // 收到消息调用的方法
    @OnMessage
    public void onMessage(@PathParam("videoId") Integer videoId, String message,Session session){
        RequestMessageEntity param = JSONObject.parseObject(message, RequestMessageEntity.class);
        StrategyConfig.getBean(param.getKey()).handler(param.getContent(), session, videoId);
    }



    // 建立连接调用的方法
    @OnOpen
    public void onOpen(@PathParam("videoId") Integer videoId, Session session) throws IOException {
        //如果所有直播间中有 当前直播间  那么直接添加session
        if(VIDEO_SESSION_MAP.containsKey(videoId)){
            VIDEO_SESSION_MAP.get(videoId).add(session);
            List<Session> sessions = VIDEO_SESSION_MAP.get(videoId);
            SendHandlerUtils.sendHandler("syncUserCount", sessions.size() + "", videoId);
        }else{
            //如果没有 自己手动创建
            List<Session> sessions = new ArrayList<>();
            sessions.add(session);
            VIDEO_SESSION_MAP.put(videoId,sessions);
            SendHandlerUtils.sendHandler("syncUserCount", "1", session);
        }
    }

    // 关闭连接调用的方法
    @OnClose
    public void onClose(@PathParam("videoId") Integer videoId, Session session) {
        if(VIDEO_SESSION_MAP.containsKey(videoId)){
            VIDEO_SESSION_MAP.get(videoId).remove(session);
            List<Session> sessions = VIDEO_SESSION_MAP.get(videoId);
            SendHandlerUtils.sendHandler("syncUserCount", sessions.size() + "", videoId);
        }
    }

    // 传输消息错误调用的方法
    @OnError
    public void OnError(Throwable error) {
        System.out.println("Connection error");
    }

}
