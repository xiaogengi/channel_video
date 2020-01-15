package com.xg.channel_video.video.mapper;

import com.xg.channel_video.video.entity.VideoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.websocket.server.PathParam;
import java.util.List;

@Mapper
public interface VideoMapper {


    /**
     * 保存数据
     * @param userId
     * @return
     */
    int addVideo(@Param("video") VideoEntity userId);

    /**
     * 查询所有视频数据
     * @return
     */
    List<VideoEntity> videoList();

    /**
     * 根据id  查询 img url
     * @param id
     * @return
     */
    String getImgFileById(@Param("id") Integer id);

    /**
     * 获取视频指定路径
     * @param id
     * @return
     */
    String getVideoPath(@Param("id") Integer id);


    /**
     * 分页
     * @param i
     * @param pageSize
     * @return
     */
    List<VideoEntity> pageVideoList(@Param("i") int i, @Param("pageSize") Integer pageSize);

    /**
     * 视频总条数
     * @return
     */
    int pageVideoCount();
}
