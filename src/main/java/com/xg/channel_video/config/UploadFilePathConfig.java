package com.xg.channel_video.config;

import com.xg.channel_video.video.service.impl.VideoServiceImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @program: channel_video
 * @description: 设置虚拟路径 访问静态文件
 * @author: gzk
 * @create: 2020-01-14 19:57
 **/
@Configuration
public class UploadFilePathConfig  extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/getFile/**").addResourceLocations("file:" + VideoServiceImpl.SYSTEM_URL);
    }
}
