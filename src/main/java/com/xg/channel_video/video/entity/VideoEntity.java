package com.xg.channel_video.video.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: channel_video
 * @description: 视频实体
 * @author: gzk
 * @create: 2020-01-14 11:43
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VideoEntity {

    private Integer id;
    private String videoName;
    private String videoFile;
    private String imgFile;
    private Integer userId;


}
