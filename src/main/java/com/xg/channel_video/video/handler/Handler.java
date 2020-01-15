package com.xg.channel_video.video.handler;

import com.alibaba.fastjson.JSONObject;

import javax.websocket.Session;

/**
 * @program: vodeowebsocket
 * @description: 消息体顶层
 * @author: gzk
 * @create: 2020-01-09 14:13
 **/
public interface Handler {


    //方法处理
    void handler(JSONObject content, Session session, Integer videoId);

}
