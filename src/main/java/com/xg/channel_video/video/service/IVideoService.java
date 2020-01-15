package com.xg.channel_video.video.service;

import com.alibaba.fastjson.JSONObject;
import com.xg.channel_video.video.entity.AddVideoParamEntity;
import com.xg.channel_video.video.entity.Page;
import com.xg.channel_video.video.entity.VideoEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface IVideoService {

    /**
     * 保存视频  存数据
     */
    JSONObject addVideo(AddVideoParamEntity paramEntity, HttpServletRequest request);

    /**
     * 查询所有视频数据
     * @return
     */
    List<VideoEntity> videoList();

    /**
     * 展示图片
     */
    void getImg(Integer id, HttpServletRequest request, HttpServletResponse response);

    /**
     *
     * param  视频id
     * return   userId   userName   videoPath
     */
    Map<String, String> getVideoPath(Integer id,HttpServletRequest request);

    /**
     * 分页
     * @param page
     * @return
     */
    Page pageHandler(Page page);
}
