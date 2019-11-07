package com.aaa.store08.controller;
import com.aaa.store08.entity.Home;
import com.aaa.store08.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("Test")
public class HomeController {
    @Autowired
    private HomeService ts;
    @RequestMapping("findTest")
    @ResponseBody
    public List<Map> findTest(String oDate) {//传过来的值int型是可以的
        System.out.println(oDate);
        SimpleDateFormat 格式=new SimpleDateFormat("yyyy-MM-dd",Locale.CHINA);
        Calendar 日历=Calendar.getInstance(Locale.CHINA);
//其余的行不变只加入这一行即可，设定每周的起始日。
        日历.setFirstDayOfWeek(Calendar.MONDAY);
        日历.setTimeInMillis(System.currentTimeMillis());//当前时间
        System.out.println("当前时间:"+格式.format(日历.getTime()));
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        System.out.println(year + " 年 " + month + " 月");
        System.out.println(oDate);
        if(oDate==null){
            oDate=格式.format(日历.getTime());
        }else {
            oDate=year + "-" + month + "-" +oDate;
        }

        List<Map> maps=ts.findArea();
        System.out.println("测试前"+maps);
        System.out.println("现在开始测试");
        for (int i=0;i<maps.size();i++){
            Home test=new Home();
            test.setaName((String) maps.get(i).get("aName"));
            test.setoDate(oDate);
            Map map = ts.findTest(test);
            System.out.println(map);
            if (map==null) {
                maps.get(i).put("oprice",0);
            }else {
                maps.get(i).put("oprice",map.get("oprice"));
            }
            System.out.println("测试"+maps);
        }
        return maps;
    }
    @RequestMapping("monthly")
    @ResponseBody
    public List<Map> monthly() {//传过来的值int型是可以的
        System.out.println("运行了1");
        List<Map> maps = ts.monthly();
        System.out.println(maps);
        return maps;
    }
    @RequestMapping("findOrders")
    @ResponseBody
    public List<Map> findOrders(String payment) {//传过来的值int型是可以的
        System.out.println("运行了2");
        List<Map> maps = ts.findOrders(payment);
        System.out.println(maps);
        return maps;
    }
    @RequestMapping("findMonth")
    @ResponseBody
    public List<Map> findMonth() {//传过来的值int型是可以的
        System.out.println("运行了3");
        List<Map> maps = ts.findMonth();
        System.out.println(maps);

        return maps;
    }
    @RequestMapping("MonthTest")
    @ResponseBody
    public List<Map> MonthTest() {//传过来的值int型是可以的
        System.out.println("运行了4" + "测试");
        List<Map> maps = ts.MonthTest();
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        System.out.println(year + " 年 " + month + " 月");

        // System.out.println(maps.size());
        for (int i = 0; i < maps.size(); i++) {
            String days = year + "-" + month + "-" + maps.get(i).get("days");
            Home to = ts.OpriceTest(days);
            if (to==null) {
                maps.get(i).put("oprice", 0);
            } else {
                maps.get(i).put("oprice", to.getOprice());
            }
           // System.out.println(maps);
        }
        //每天的收入
        return maps;
    }
}
