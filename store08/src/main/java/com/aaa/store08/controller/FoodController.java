package com.aaa.store08.controller;

import com.aaa.store08.entity.*;
import com.aaa.store08.service.AreaService;
import com.aaa.store08.service.FoodService;
import com.aaa.store08.service.KindService;
import com.aaa.store08.service.WindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
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

    //分页查询菜品
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
    //跳转菜品页面
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
    //添加菜品
    @RequestMapping("ToAddFood")
    public String ToAddFood(Model model){
        List<Area> areas = as.SelArea();
        model.addAttribute("as",areas);
        return "page/Food-Manage/Food-Add";
    }

    @RequestMapping("GetFood")
    @ResponseBody
    public Object GetFood(Integer tArea){
        System.out.println("123");
        List<Food> kInd = fs.SelFoodId(tArea);
        for (Food food : kInd){
            System.out.println(food.getkName());
            System.out.println(food.getkId());
        }
        return kInd;
    }

    //跳转添加页面
    @RequestMapping("Add")
    public  String Add(){
        return "page/Food-Manage/Food-Add";
    }
    //添加菜品图片
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
    //文件上传
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
    //雷禧新增
    @Autowired
    private WindService ts;
    //添加菜品类别
    @RequestMapping("toType")
    public String toType(){
        return "page/Food-Manage/Food-type";
    }
    @RequestMapping("findTemptKind")
    @ResponseBody
    public Object findType(HttpSession httpSession){
        String username = String.valueOf(httpSession.getAttribute("username"));
        DataGrid dg = new DataGrid();
        int usersaId = ts.findUsersaId(username);
        //查询出所有类别
        List<Map> temptKind = fs.findTemptKind(usersaId);
        dg.setCode(0);
        dg.setData(temptKind);
        dg.setMsg("");
        return dg;
    }
    @RequestMapping("AddTemptKind")
    public String AddKind(HttpSession httpSession){
        String kName=null;
        //添加Kind
         fs.insertKind(kName);
        //添加tempt
        String username = String.valueOf(httpSession.getAttribute("username"));
        DataGrid dg = new DataGrid();
        int tArea = ts.findUsersaId(username);
         fs.insertTempt(tArea);
        return "page/Food-Manage/Food-Type";
    }
    @RequestMapping("TemptDel")
    public String TemptDel(Integer tId){

        fs.deleteTempt(tId);
        return "page/Food-Manage/Food-Type";
    }
    @RequestMapping("UpdKind")
    public String UpdKind(Integer tId,String kName){
        fs.UpdKind(tId,kName);
        return "page/Food-Manage/Food-Type";
    }
}
