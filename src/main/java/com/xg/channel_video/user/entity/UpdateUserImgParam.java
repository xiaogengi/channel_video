package com.xg.channel_video.user.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.pattern.PathPattern;

/**
 * @program: channel_video
 * @description: 修改头像实体
 * @author: gzk
 * @create: 2020-01-16 11:24
 **/
@Data
@ToString
public class UpdateUserImgParam {

    private MultipartFile userImg;
    private String userId;


}
