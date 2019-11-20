package com.aaa.store08.controller;

import com.aaa.store08.entity.Area;
import com.aaa.store08.entity.AreaVo;
import com.aaa.store08.entity.DataGrid;
import com.aaa.store08.entity.PageVo;
import com.aaa.store08.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("Area")
public class AreaController {
    @Autowired
    private AreaService as;
    @RequestMapping("toArea")
    public String toArea(AreaVo areaVo,Model model) {
        List<AreaVo> area=as.findArea();
        model.addAttribute("area",area);
        return "page/area/Area";
    }
    @RequestMapping("AreaSelect")
    @ResponseBody
    public Object SelFood(PageVo pageVo, String aName) {
        DataGrid dg = new DataGrid();
        System.out.println(aName);
        AreaVo areaVo=new AreaVo();
        areaVo.setaName(aName);
        int count = as.findCount(areaVo);
        System.out.println(aName+"--"+count);
        List<Map> maps = as.SelDeskAll(pageVo,aName);
        dg.setCode(0);
        dg.setCount(count);
        dg.setData(maps);
        dg.setMsg("");
        return dg;
    }
    @RequestMapping("toAreaAdd")
    public String toAreaAdd() {
        return "page/area/AreaAdd";
    }
    @RequestMapping("toCK")
    public String toCK() {

        return "page/area/CK";
    }
    @RequestMapping("CKSelect")
    @ResponseBody
    public Object WindowSelect() {
        System.out.println("测试");
        DataGrid dg = new DataGrid();
        List<Map> areas = as.findAreaKing();
        //查询介绍添加
        for (int i=0;i<areas.size();i++){
            Integer aId= (Integer) areas.get(i).get("aId");
            List<Map> aKname = as.findAreaKname(aId);
            String kName="";
            for (int j=0;j<aKname.size();j++){
                if (j==aKname.size()-1){
                    kName=kName+aKname.get(j).get("kName");
                }else {
                    kName=kName+aKname.get(j).get("kName")+",";
                }
            }
            areas.get(i).put("kName",kName);
        }
        dg.setCode(0);
        dg.setData(areas);
        dg.setMsg("");
        return dg;
    }
    @RequestMapping("AreaAdd")
    public String AreaAdd(String dName,String dimg, HttpServletRequest request) {
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();

        String fileName =basePath+"/uploadFiles/"+dimg;
        System.out.println(fileName);
        AreaVo areaVo=new AreaVo();
        String aName="莲香楼";
        System.out.println("添加事件");
        areaVo.setaName(aName);
        areaVo.setdName(dName);
        areaVo.setDimg(fileName);
        as.AddDesk(areaVo);
        return "page/area/Area";
    }
    @RequestMapping("AreaDel")
    public String AreaDel(Integer dId) {
        as.DelDesk(dId);
        return "page/area/Area";
    }
    @RequestMapping("AreaUpdDsort")
    public String AreaUpdDsort(Integer dId,String dsort) {
        AreaVo areaVo=new AreaVo();
        areaVo.setdId(dId);
        areaVo.setDsort(dsort);
        as.UpdDsort(areaVo);
        return "page/area/Area";
    }
    @RequestMapping("AreaUpd")
    public String AreaUpd(Integer dId,String dName) {
        System.out.println(dId);
        AreaVo areaVo=new AreaVo();
        areaVo.setdId(dId);
        areaVo.setdName(dName);
        as.UpdDesk(areaVo);
        return "page/area/Area";
    }



    //文件上传


    @RequestMapping("upload")

    public String uploadImg(MultipartFile file) {
        if (null != file) {
            String myFileName = file.getOriginalFilename();// 文件原名称
            String pat="E:\\app-git\\08store\\store08\\src\\main\\resources\\templates\\common\\image\\img\\";//获取文件保存路径

            File fileDir=new File(pat);
            if (!fileDir.exists()) { //如果不存在 则创建
                fileDir.mkdirs();
            }
            String path=pat+myFileName;
            System.out.println(path);
            File localFile = new File(path);
            try {
                file.transferTo(localFile);
                return pat+myFileName;
            } catch (IllegalStateException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else{
            System.out.println("文件为空");
        }
        return null;
    }
    @RequestMapping("toCKAdd")
    public String toCKAdd(Model model) {
         //查询菜品分类
        List<Map> kind = as.findKind();
        model.addAttribute("kind",kind);
        return "page/area/CKAdd";
    }
    @RequestMapping("AddArea")
    @ResponseBody
    public Object AddArea(String aName,String aMain,String aImg,HttpServletRequest request) {
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        String fileName =basePath+"/uploadFiles/"+aImg;
        System.out.println(fileName);
        Map map=new HashMap();
        map.put("aName",aName);
        map.put("aMain",aMain);
        map.put("aImg",fileName);
        int num = as.AddArea(map);
        return num;
    }
    @RequestMapping("AddTempt")
    @ResponseBody
    public Object AddTempt(Integer kId) {
        //添加tempt方法
        as.AddTempt(kId);
        return 0;
    }
    @RequestMapping("DelArea")
    @ResponseBody
    public Object DelArea(Integer aId) {
        //删除tempt方法
        as.DelArea(aId);
        return 0;
    }
    @RequestMapping("UpdArea")
    @ResponseBody
    public Object UpdArea(Integer aId,String aName) {
        System.out.println("修改"+aId);
        //修改tempt方法
        Map map=new HashMap();
        map.put("aId",aId);
        map.put("aName",aName);
        as.UpdArea(map);
        return 0;
    }

}
