package com.aaa.store08.controller;

import com.aaa.store08.entity.*;
import com.aaa.store08.service.AreaService;
import com.aaa.store08.service.FoodService;
import com.aaa.store08.service.KindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("Food")
public class FoodController {
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
    public String InsertFood(MultipartFile file, Food food, Area area, Kind kind){
           System.out.println("进来了");
           System.out.println(food.getmPrice()+food.getmName()+food.getmImg()+food.getmArea()+food.getmKind());
           System.out.println("名字"+food.getmImg());
           String name="../common/image/img/"+food.getmImg();
           food.setmImg(name);
           //判断文件夹是否存在    不存在则创建
           System.out.println(food.getmPrice()+food.getmName()+food.getmImg()+food.getmArea()+food.getmKind());
           fs.InsertFood(food);


        System.out.println(food.getmName()+food.getmImg());
        return "redirect:aaa";
    }
    @RequestMapping("upload")
    public @ResponseBody Map<String, Object> image(@RequestBody MultipartFile file, HttpServletRequest request){

        Map<String, Object> map = new HashMap<String, Object>();
        try {
            String name = file.getOriginalFilename();//上传文件的真实名称
            String suffixName = name.substring(name.lastIndexOf(".")+1);//获取后缀名
            //图片的存储位置
            String path = "F:\\demo\\store08\\src\\main\\resources\\templates\\common\\image\\img";
            String image = UploadUtil.uploadFile(file, path);
            System.out.println(path);
            map.put("code", 0);
            map.put("message", "上传成功");
            map.put("data", image);
        } catch (Exception e) {
            map.put("code", 1);
            e.printStackTrace();
        }
        System.out.println(map);
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
    public String Upd(Food food,MultipartFile upload){
        System.out.println(food.getmName()+food.getmPrice()+food.getmKind()+food.getmArea()+food.getmId()+food.getmImg());
        String name="../common/image/img/"+food.getmImg();
        food.setmImg(name);
        fs.UpdateFood(food);
        return "redirect:aaa";
    }
}
