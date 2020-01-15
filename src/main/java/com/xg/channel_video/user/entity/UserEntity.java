package com.xg.channel_video.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @program: channel_video
 * @description: 用户实体
 * @author: gzk
 * @create: 2020-01-13 11:17
 **/
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {


    private Integer userId;
    //用户姓名
    private String userName;
    //用户性别
    private String userSex;
    //用户密码
    private String userPass;
    //用户账号
    private String userAccount;


}
