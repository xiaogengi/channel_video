package com.xg.channel_video.video.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: channel_video
 * @description: 添加视频
 * @author: gzk
 * @create: 2020-01-14 10:29
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddVideoParamEntity {

    private String videoName;

    private MultipartFile imgFile;

    private MultipartFile videoFile;



}
