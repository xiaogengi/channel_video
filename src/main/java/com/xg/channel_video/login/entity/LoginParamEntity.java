package com.xg.channel_video.login.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @program: channel_video
 * @description: 登陆
 * @author: gzk
 * @create: 2020-01-13 17:47
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginParamEntity {


    private String userAccount;
    private String userPass;
    private Integer type; //1  加密中   2为加密


}
