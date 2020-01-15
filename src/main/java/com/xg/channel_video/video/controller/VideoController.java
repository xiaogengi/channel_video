package com.xg.channel_video.video.controller;

import com.alibaba.fastjson.JSONObject;
import com.xg.channel_video.utils.ResultUtils;
import com.xg.channel_video.video.entity.AddVideoParamEntity;
import com.xg.channel_video.video.entity.Page;
import com.xg.channel_video.video.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @program: channel_video
 * @description: 视频
 * @author: gzk
 * @create: 2020-01-14 10:08
 **/
@RestController
@RequestMapping("video")
public class VideoController {

    @Autowired
    private IVideoService videoService;


    /**
     * 保存视频
     * @param paramEntity
     * @param request
     * @return
     */
    @RequestMapping("addVideo")
    public JSONObject addVideo(AddVideoParamEntity paramEntity, HttpServletRequest request){
        try {
            return videoService.addVideo(paramEntity,request);
        } catch (Exception e){
            return ResultUtils.resultErrorMsg(new JSONObject(), e);
        }
    }


    /**
     * 打开视频 播放
     */
    @RequestMapping("getVideoById")
    public ModelAndView getVideoById(Integer id,HttpServletRequest request){
        ModelAndView model = new ModelAndView();
        if(request.getSession().getAttribute("userId") == "" || request.getSession().getAttribute("userId") == null){
            model.setViewName("login/login");
            return model;
        }
        try {
            Map<String,String> resultMap = videoService.getVideoPath(id,request);

            // userId   userName   videoPath
            model.addObject("result",resultMap);
            model.setViewName("video/videoById");
            return model;
        } catch (Exception e){
            e.printStackTrace();
            model.setViewName("error/Error");
            return model;
        }
    }


    /**
     * 分页
     */
    @RequestMapping("pageHandler")
    public Page pageHandler(Page page){
        return videoService.pageHandler(page);
    }

}
