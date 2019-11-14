package com.aaa.store08.controller;

import com.aaa.store08.entity.DataGrid;
import com.aaa.store08.entity.PageVo;
import com.aaa.store08.entity.VipVO;
import com.aaa.store08.service.IVipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/vip")
public class vipController  extends  BaseController{
        @Autowired
        private IVipService iVipService;

        @RequestMapping("/vipfindall")
        public String vipFindAll(){
        return  "page/vippage/vipindexall";
        }
        //查看会员
        @ResponseBody
        @RequestMapping("/findall")
        public Object vipFindall(PageVo pageVo,String value,VipVO vipVO){
            System.out.println(value);
            String date1 = null;
            String date2 = null;
            if(value != null){
                date1 = value.substring(0,value.indexOf('~'));
                date2 = value.substring(value.indexOf('~')+1);
                System.out.println(date1);
                System.out.println(date2);
            }
            Map<Object,Object> map = new HashMap<Object,Object>();
            map.put("limit",pageVo.getLimit());
            map.put("page",pageVo.getPage());
            map.put("date1",date1);
            map.put("date2",date2);

             DataGrid dg=new DataGrid();
             List<Map> findall = iVipService.findVip(map);
             int count = iVipService.vipFindall(vipVO);

            for(Map m:findall){
                m.put("count",count);
            }

             dg.setCode(0);
             dg.setData(findall);
             dg.setCount(count);
             dg.setMsg("");
             return dg;
        }

        //查看会员类型
        @RequestMapping("/vipAdd")
        public String addVip(Model model){
            List<VipVO> typeFindall = iVipService.typeFindall();
            model.addAttribute("typeFindall",typeFindall);
            return "page/vippage/addVip";
        }
        //注册会员
        @ResponseBody
        @RequestMapping("/addVip")
        public Object addVip(VipVO vipVO){
            Date date = new Date();
            SimpleDateFormat dateFormat= new SimpleDateFormat("yyyyMMddhhmmss");
            String dates = dateFormat.format(date);
            System.out.println(vipVO.getvIdc());
            vipVO.setvState(1);
            vipVO.setvCount(dates);
            vipVO.setvSum(vipVO.getvAcount());
            int success = iVipService.addVip(vipVO);
            return success;
        }
        //编辑前的查询
        @RequestMapping("/vipEdit")
        public String vipEdit(Integer id,Model model){
            List<VipVO> typeFindall = iVipService.typeFindall();
            List<VipVO> vipVOS = iVipService.vipOne(id);
            model.addAttribute("vs",vipVOS);
            model.addAttribute("tl",typeFindall);
            return "page/vippage/vipEdit";
        }
        //修改会员状态
        @ResponseBody
        @RequestMapping("/vipEdit_do")
        public Object vipEdit_do(VipVO vipVO){
            int success = iVipService.updateVip(vipVO);
            return success;
        }

        //根据 充值金额 去查询 等级id
        @ResponseBody
        @RequestMapping("/selVid")
        public Object selVid(Integer vAcount,Model model){
            System.out.println("vlimit:"+vAcount);
            List<VipVO> vtype = iVipService.selVid(vAcount);
            Integer vidc = vtype.get(0).getvIdc();
            //double vDiscount = vtype.get(0).getvDiscount();
            String vGrade = vtype.get(0).getvGrade();
            String vDisplay = vtype.get(0).getvDisplay();
            double vLimit = vtype.get(0).getvLimit();
            String zong = vidc+"."+vGrade+",享受折扣："+vDisplay+",累计充值："+vLimit+"元";
            return zong;
        }


}
