package com.aaa.store08.controller;

import com.aaa.store08.entity.*;
import com.aaa.store08.service.AreaService;
import com.aaa.store08.service.FoodService;
import com.aaa.store08.service.KindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("Food")
public class FoodController {
    @Value("${uploadFile.resourceHandler}")
    private String resourceHandler;//请求 url 中的资源映射，不推荐写死在代码中，最好提供可配置，如 /uploadFiles/**

    @Value("${uploadFile.location}")
    private String uploadFileLocation;
    @Autowired
    private FoodService fs;
    @Autowired
    private AreaService as;
    @Autowired
    private KindService ks;

    @ResponseBody
    @RequestMapping("SelFood")
    public Object SelFood(PageVo pageVo) {
        DataGrid dg = new DataGrid();
        int count = fs.findCount();
        List<Map> maps = fs.SelFoodAll(pageVo);
        dg.setCode(0);
        dg.setCount(count);
        dg.setData(maps);
        dg.setMsg("");
        return dg;

    }
    @RequestMapping("aaa")
    public String aaa(){
        return "page/Food-Manage/Food-index";
    }


        //按编号删除
    @RequestMapping("DelFood")
    public String DelStu(Integer mId){
        int i = fs.DelFood(mId);
        System.out.println(i);
        return "redirect:Food/SelFood";
    }

    @RequestMapping("ToAddFood")
    public String ToAddFood(Area area, Kind kind, Model model){
        List<Area> areas = as.SelArea();
        List<Kind> kinds = ks.SelKind();
        model.addAttribute("as",areas);
        model.addAttribute("ks",kinds);
        return "page/Food-Manage/Food-Add";
    }

    @RequestMapping("Add")
    public  String Add(){
        return "page/Food-Manage/Food-Add";
    }

    @RequestMapping("InsertFood")
    public String InsertFood(Food food, Area area, Kind kind,HttpServletRequest request){
           String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();

           System.out.println(food.getmPrice()+food.getmName()+food.getmImg());
           String fileName =basePath+"/uploadFiles/"+food.getmImg();
           System.out.println(fileName);
           food.setmImg(fileName);
           fs.InsertFood(food);


        System.out.println(food.getmName()+food.getmImg());
        return "redirect:aaa";
    }

    @RequestMapping("upload")
    public @ResponseBody Map<String, Object> image(@RequestBody MultipartFile file){

        Map<String, Object> map = new HashMap<String, Object>();
        try {
            String name = file.getOriginalFilename();//上传文件的真实名称
            File saveFile = new File(uploadFileLocation, name);
            file.transferTo(saveFile);
            map.put("path",name);
        } catch (Exception e) {
            map.put("code", 1);
            e.printStackTrace();
        }
        return map;
    }
    @RequestMapping("ToUpdateFood")
    public String ToUpdateFood(Area area, Kind kind, Model model,Integer mId){
        Food food = fs.UpdFoodId(mId);
        List<Area> areas = as.SelArea();
        List<Kind> kinds = ks.SelKind();
        model.addAttribute("upd",food);
        model.addAttribute("as",areas);
        model.addAttribute("ks",kinds);
        return "page/Food-Manage/Food-Update";
    }


    //修改
    @RequestMapping("Upd")
    public String Upd(Food food,@RequestBody MultipartFile upload,HttpServletRequest request){
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();

        System.out.println(food.getmPrice()+food.getmName()+food.getmImg());
        String fileName =basePath+"/uploadFiles/"+food.getmImg();
        System.out.println(fileName);
        food.setmImg(fileName);
        fs.InsertFood(food);
        return "redirect:aaa";
    }
}
