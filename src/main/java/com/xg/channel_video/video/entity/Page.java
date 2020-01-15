package com.xg.channel_video.video.entity;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @program: channel_video
 * @description: 分页
 * @author: gzk
 * @create: 2020-01-15 10:54
 **/
@Data
@ToString
public class Page {

    private Integer page = 1;//当前页
    private Integer pageSize = 8;//每页条数
    private Integer pageCount;//总页数
    private Integer dataSize;//总条数
    private List<VideoEntity> data; //数据体


}
