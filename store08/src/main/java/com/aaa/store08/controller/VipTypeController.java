package com.aaa.store08.controller;

import com.aaa.store08.entity.DataGrid;
import com.aaa.store08.entity.PageVo;
import com.aaa.store08.entity.VipType;
import com.aaa.store08.mapper.VipTypeMapper;
import com.aaa.store08.service.VipTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("VType")
public class VipTypeController {
    @Autowired
    private VipTypeService vs;
    //分页查询vtype表

    @ResponseBody
    @RequestMapping("SelVType")
    public Object SelFood(PageVo pageVo) {
        DataGrid dg = new DataGrid();
        int count = vs.findCount();
        List<Map> maps = vs.VipTypeAll(pageVo);
        dg.setCode(0);
        dg.setCount(count);
        dg.setData(maps);
        dg.setMsg("");
        return dg;

    }

    @RequestMapping("ToVType")
    public String ToVType(){
        return "page/vippage/VipScale";
    }

    //跳转添加页面
    @RequestMapping("ToAddVType")
    public String ToAddVType(){
        return "page/vippage/VipAddScale";
    }
    @ResponseBody
    //添加会员类型
    @RequestMapping("AddVType")
    public Object AddVType(VipType vipType){
        int success = vs.AddVType(vipType);
        return success;
    }

    //跳转修改页面
    @RequestMapping("ToUpdVType")
    public String ToUpdVType(Integer vIdc, Model model){
        VipType vipType = vs.SelVType(vIdc);
        model.addAttribute("vt",vipType);
        return "page/vippage/VipUpdScale";
    }
    //修改会员类型
    @ResponseBody
    @RequestMapping("UpdVType")
    public Map UpdVType(VipType vipType){
        int success = vs.UpdVType(vipType);
        System.out.println("成功修改"+success);
        Map map=new HashMap();
        map.put("num",success);
    return map;
    }

    //按编号删除
    @RequestMapping("DelVType")
    public String DelVType(Integer vIdc){
        vs.DelVType(vIdc);
        return "redirect:VType/ToVType";
    }

}
