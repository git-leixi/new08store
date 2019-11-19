package com.aaa.store08.controller;


import com.aaa.store08.entity.UJob;
import com.aaa.store08.entity.Users;
import com.aaa.store08.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    //访问登陆页面
    @RequestMapping("login")
    public String login(){
        return "page/login/login";
    }


    //获取输入的账号、密码
    @RequestMapping("hello")
    public String Hello(String username, String password, Users users, Model model, HttpServletRequest request){
        //依据输入的账号密码  查询数据库值是否存在
        Users up = loginService.findUP(username, password);

        if(up!=null){
            //如果输入正确，则 拿到输入的账号去查询他的职位
            UJob ujob = loginService.findJob(username);
            model.addAttribute("jName",ujob.getjName());
            HttpSession session = request.getSession();
            session.setAttribute("username",username);
            if(ujob.getjPermission() == 2){
                return "page/index2";
            }
            return "page/index";
        }else {
            return "page/login/login";
        }

    }


}

