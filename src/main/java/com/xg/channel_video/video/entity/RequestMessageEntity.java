package com.xg.channel_video.video.entity;

import com.alibaba.fastjson.JSONObject;

/**
 * @program: vodeowebsocket
 * @description: 请求消息实体
 * @author: gzk
 * @create: 2020-01-09 14:26
 **/
public class RequestMessageEntity {

    private String key;

    private JSONObject content;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public JSONObject getContent() {
        return content;
    }

    public void setContent(JSONObject content) {
        this.content = content;
    }
}
