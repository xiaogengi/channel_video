package com.xg.channel_video.config;


import com.xg.channel_video.video.handler.Handler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: vodeowebsocket
 * @description: 策略配置类
 * @author: gzk
 * @create: 2020-01-09 11:47
 **/
public class StrategyConfig {


    public final static Map<String, Handler> HANDLER_STRATEGY = new ConcurrentHashMap<>();


    public static Handler getBean(String key){
        return HANDLER_STRATEGY.get(key);
    }


}
