package com.aaa.store08.controller;


import com.aaa.store08.service.PrincipalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("principal")
//  窗口负责
public class PrincipalController {

    @Autowired
    private PrincipalService principalService;

    @RequestMapping("selAid")
    public String selAid(String username){
        int i = principalService.selAid(username);
        if(i==0){
            return "page/test3";
        }
        return "page/test2";
    }
}
