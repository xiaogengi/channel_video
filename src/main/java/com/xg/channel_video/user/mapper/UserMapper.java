package com.xg.channel_video.user.mapper;

import com.xg.channel_video.user.entity.UpdateUserImgParam;
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

    /**
     * 修改用户头像路径
     */
    void updateUserImg(@Param("userId") String userId, @Param("userImgPath") String userImgPath);
}
