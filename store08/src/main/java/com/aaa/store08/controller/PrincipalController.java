package com.aaa.store08.controller;


import com.aaa.store08.entity.Area;
import com.aaa.store08.service.PrincipalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("principal")
//  窗口负责
public class PrincipalController {

    @Autowired
    private PrincipalService principalService;

    @RequestMapping("selAid")
    public String selAid(String username, Model model){
        int i = principalService.selAid(username);
        if(i==0){
            List<Area> areas = principalService.selAreaAll();
            model.addAttribute("list",areas);
            return "page/test3";
        }
        return "page/test2";
    }
}
