package com.xg.channel_video.login.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: channel_video
 * @description: 注册用户入参
 * @author: gzk
 * @create: 2020-01-13 11:26
 **/
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RegisterParamEntity {

    private String userName;

    private String userPass;

    private Integer userSex;

    private MultipartFile userImg;



}
