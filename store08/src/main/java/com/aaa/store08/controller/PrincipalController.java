package com.aaa.store08.controller;


import com.aaa.store08.entity.Area;
import com.aaa.store08.service.PrincipalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("principal")
//  窗口负责
public class PrincipalController {

    @Autowired
    private PrincipalService principalService;

    //根据登陆账号去判断该用户是否已绑定窗口
    @RequestMapping("selAid")
    public String selAid( Model model, HttpSession httpSession){
        String username = String.valueOf(httpSession.getAttribute("username"));
        System.out.println(httpSession.getAttribute("username"));
        int i = principalService.selAid(username);
        if(i==0){
            List<Area> areas = principalService.selAreaAll();
            model.addAttribute("list",areas);
            return "page/test3";
        }
        return "page/test2";
    }

    //根据未绑定账户  根据所选择绑定的窗口 进行绑定
    @ResponseBody
    @RequestMapping("updAid")
    public int updAid(int aId, HttpSession httpSession){
        System.out.println(aId);
        String username = String.valueOf(httpSession.getAttribute("username"));
        Map map = new HashMap<>();
        map.put("aid",aId);
        map.put("username",username);
        int i = principalService.updAid(map);
        return i;
    }
}
