package com.xg.channel_video.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    /**
     * 获取用户名称
     * @param userId
     * @return
     */
    String getUserNameById(@Param("id") String userId);
}
