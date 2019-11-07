package com.aaa.store08.controller;

import com.aaa.store08.entity.DataGrid;
import com.aaa.store08.entity.PageVo;
import com.aaa.store08.entity.VipVO;
import com.aaa.store08.service.IVipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/vips")
public class BillsController {
    @Autowired
    private IVipService iVipService;
    @RequestMapping("/vipbills")
    public String vipBllis(){
        return "page/vippage/billsFindall";
    }
    //查看消费记录
    @ResponseBody
    @RequestMapping("/billsFindall")
    public Object billFindall(PageVo pageVo, VipVO vipVO){
        DataGrid dg=new DataGrid();
        List<Map> findall = iVipService.billsFindall(pageVo,vipVO);
        int count = iVipService.countBills();
        dg.setCode(0);
        dg.setData(findall);
        dg.setCount(count);
        dg.setMsg("");
        return dg;
    }

}
