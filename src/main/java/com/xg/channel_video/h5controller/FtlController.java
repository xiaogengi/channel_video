package com.xg.channel_video.h5controller;

import com.xg.channel_video.video.entity.Page;
import com.xg.channel_video.video.entity.VideoEntity;
import com.xg.channel_video.video.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @program: channel_video
 * @description: 页面控制器
 * @author: gzk
 * @create: 2020-01-13 16:15
 **/
@Controller
public class FtlController {

    @Autowired
    private IVideoService videoService;


    /**
     * 注册页面
     * @return
     */
    @RequestMapping("register")
    public String register(){
        return "register/register";
    }


    /**
     * 注册成功页面
     * @param account
     * @param pass
     * @return
     */
    @RequestMapping("registerSuccess")
    public ModelAndView registerSuccess(String account, String pass){
        ModelAndView model = new ModelAndView();
        model.setViewName("register/registerSuccess");
        model.addObject("account", account);
        model.addObject("userPass", pass);
        return model;
    }

    /**
     * 登陆页面
     * @return
     */
    @RequestMapping("login")
    public String login(){
        return "login/login";
    }


    /**
     * 视频大厅页面
     * @return
     */
    @RequestMapping("hi")
    public ModelAndView index(Page page, HttpServletRequest request){
        ModelAndView model = new ModelAndView();
        if(request.getSession().getAttribute("userId") == null || request.getSession().getAttribute("userId") == ""){
            model.setViewName("login/login");
            return model;
        }
        model.setViewName("index");

        //List<VideoEntity> list = videoService.videoList();
        page = videoService.pageHandler(page);

        model.addObject("page",page);
        return model;
    }


    /**
     * 添加视频页面
     * @param request
     * @return
     */
    @RequestMapping("addVideo")
    public String addVideo(HttpServletRequest request){
        if(request.getSession().getAttribute("userId") == null || request.getSession().getAttribute("userId") == ""){
            return "login/login";
        }
        return "video/addVideo";
    }




}
