package com.xg.channel_video.login.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.xg.channel_video.login.entity.LoginParamEntity;
import com.xg.channel_video.login.entity.RegisterParamEntity;
import com.xg.channel_video.login.mapper.LoginMapper;
import com.xg.channel_video.login.service.ILoginService;
import com.xg.channel_video.utils.Md5Utils;
import com.xg.channel_video.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

/**
 * @program: channel_video
 * @description: 用户
 * @author: gzk
 * @create: 2020-01-13 11:22
 **/
@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private LoginMapper loginMapper;

    /**
     * 注册用户
     * @param param
     * @return
     */
    @Override
    public JSONObject registerUser(RegisterParamEntity param) {
        JSONObject jsonResult = new JSONObject();
        //随机生成账号
        Integer account = accountUtil();

        //验证账号是否存在
        while (loginMapper.getUserByAccount(account) != 0){
            account = accountUtil();
        }
        try {

            //加密
            String Md5Pass = Md5Utils.encode(param.getUserPass());
            param.setUserPass(Md5Pass);

            int register = loginMapper.registerUser(param,account);
            if(register == 0){
                jsonResult = ResultUtils.resultErrorMsg(jsonResult,"注册失败，请稍后重试！！");
            }else{
                JSONObject data = new JSONObject();
                data.put("pass",Md5Pass);
                data.put("account",account);
                jsonResult = ResultUtils.resultSuccessDataMsg(jsonResult,"注册成功！", data);
            }
            return jsonResult;
        } catch (Exception e){
            e.printStackTrace();
            return ResultUtils.resultErrorMsg(jsonResult,"111");
        }
    }

    /**
     * 登陆
     * @param param
     * @return
     */
    @Override
    public JSONObject login(LoginParamEntity param, HttpServletRequest request) {
        JSONObject jsonResult = new JSONObject();

        if(param.getType() == 2){
            param.setUserPass(Md5Utils.encode(param.getUserPass()));
        }

        String pass = loginMapper.getUserByUserAccount(param.getUserAccount());
        if(pass == null || pass == "" || !pass.equals(param.getUserPass())){
            jsonResult = ResultUtils.resultErrorMsg(jsonResult,"密码错误！！！");
        }else{
            request.getSession().setAttribute("userId",param.getUserAccount());
            JSONObject data = new JSONObject();
            data.put("user",param);
            jsonResult = ResultUtils.resultSuccessDataMsg(jsonResult, "登陆成功！！", data);
        }
        return jsonResult;
    }




    //随机生成账号
    private static  Integer accountUtil() {
        return new Random().nextInt(9999999) + 1234567;
    }

}
