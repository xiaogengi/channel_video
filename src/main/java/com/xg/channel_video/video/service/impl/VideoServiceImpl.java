package com.xg.channel_video.video.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.xg.channel_video.user.mapper.UserMapper;
import com.xg.channel_video.utils.DownloadFileUtils;
import com.xg.channel_video.utils.ResultUtils;
import com.xg.channel_video.video.entity.AddVideoParamEntity;
import com.xg.channel_video.video.entity.Page;
import com.xg.channel_video.video.entity.VideoEntity;
import com.xg.channel_video.video.mapper.VideoMapper;
import com.xg.channel_video.video.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: channel_video
 * @description: 视频处理
 * @author: gzk
 * @create: 2020-01-14 10:10
 **/
@Service
public class VideoServiceImpl implements IVideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private UserMapper userMapper;

    private final static String VIDEO_FILE_URL = "/Users/didi/Desktop/video";

    private final static String IMG_FILE_URL = "/Users/didi/Desktop/img";

    private final static String VIDEO_ = "video/";

    private final static String IMG_ = "img/";

    private final static BigDecimal DEFAULT_BIG_DECIMAL = new BigDecimal("8");

    /**
     * 保存视频数据
     * @param paramEntity
     * @param request
     * @return
     */
    @Override
    public JSONObject addVideo(AddVideoParamEntity paramEntity, HttpServletRequest request) {
        JSONObject jsonResult = new JSONObject();
        String videoPath = "";
        String imgPath = "";
        String userId = (String) request.getSession().getAttribute("userId");
        try {
            //保存视频
            videoPath = VIDEO_ + DownloadFileUtils.downloadFileUtils(paramEntity.getVideoFile(),VIDEO_FILE_URL, userId);
            //保存图片
            imgPath = IMG_ + DownloadFileUtils.downloadFileUtils(paramEntity.getImgFile(),IMG_FILE_URL, userId);
            //保存数据
            videoMapper.addVideo(new VideoEntity(null,paramEntity.getVideoName(),videoPath,imgPath,Integer.parseInt(request.getSession().getAttribute("userId").toString())));
            return ResultUtils.resultSuccessMsg(jsonResult, "保存成功！");
        } catch (Exception e){
            e.printStackTrace();
            //删除视频 删除图片
            deleteFile(userId + videoPath);
            deleteFile(userId + imgPath);
            return ResultUtils.resultErrorMsg(jsonResult, "保存失败 ！");
        }
    }

    /**
     * 查询所有视频数据
     * @return
     */
    @Override
    public List<VideoEntity> videoList() {
        List<VideoEntity> list = null;
        try {
           list = videoMapper.videoList();
        }catch (Exception e){
            e.printStackTrace();
            list = new ArrayList<>();
        }
        return list;
    }

    /**
     * 打开图片
     */
    @Override
    public void getImg(Integer id, HttpServletRequest request, HttpServletResponse response) {
        String imgUrl = videoMapper.getImgFileById(id);
        try {
            //ImgActionUtils.getImg(imgUrl,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * param  视频id
     * return   userId   userName   videoPath
     */
    @Override
    public Map<String, String> getVideoPath(Integer id,HttpServletRequest request) {
        Map resultMap = new HashMap<String,String>();
        String userId = request.getSession().getAttribute("userId").toString();

        String videoPath = videoMapper.getVideoPath(id);

        String userName = userMapper.getUserNameById(userId);

        resultMap.put("userId",userId);
        resultMap.put("videoId",id);
        resultMap.put("videoPath",videoPath);
        resultMap.put("userName",userName);
        return resultMap;
    }

    @Override
    public Page pageHandler(Page page) {
        //数据体
        List<VideoEntity> list = videoMapper.pageVideoList((page.getPage()-1) * page.getPageSize(),page.getPageSize());
        //总条数
        int pageContent = videoMapper.pageVideoCount();
        page.setData(list);
        page.setDataSize(pageContent);//总页数
        page.setPageCount(dataSizeHandler(pageContent));//总条数
        return page;
    }

    public static int dataSizeHandler(int pageContent){
        String s = Math.ceil(new BigDecimal(pageContent).divide(DEFAULT_BIG_DECIMAL).doubleValue()) + "";
        return Integer.parseInt(s.substring(0,s.indexOf(".")));
    }



    /**
     * 删除文件
     * @param path
     */
    private static void deleteFile(String path){
        if(path != ""){
            File file = new File(path);
            if(file.isFile()){
                file.delete();
            }
        }
    }



}
