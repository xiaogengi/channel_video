package com.xg.channel_video.login.mapper;

import com.xg.channel_video.login.entity.RegisterParamEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginMapper {

    /**
     * 查询用没有当前账号
     * @param account
     * @return
     */
    int getUserByAccount(@Param("account") Integer account);

    /**
     * 注册用户
     * @param param
     * @param account
     * @return
     */
    int registerUser(@Param("register") RegisterParamEntity param, @Param("account") Integer account);

    /**
     * 根据账号 查询密码
     * @param userAccount
     * @return
     */
    String getUserByUserAccount(@Param("account") String userAccount);
}
