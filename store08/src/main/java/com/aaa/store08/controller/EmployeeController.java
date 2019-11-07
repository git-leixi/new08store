package com.aaa.store08.controller;

import com.aaa.store08.entity.*;
import com.aaa.store08.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/staff")
public class EmployeeController extends BaseController{
    @Autowired
    private IEmployeeService iEmployeeService;
    //异步加载数据
    @RequestMapping("/staffSelect")
    public String staff(){
        return "page/staff/findall";
    }
    @ResponseBody
    @RequestMapping("/findall")
    public Object staffSelect(PageVo pageVo){
        DataGrid dg=new DataGrid();
        List<Map> findall = iEmployeeService.findall(pageVo);
        int count = iEmployeeService.selEmployee();
        dg.setCode(0);
        dg.setData(findall);
        dg.setCount(count);
        dg.setMsg("");
        return dg;
    }
    //查询要修改的员工的信息
    @RequestMapping("/staffedit")
    public  String staffedit(Integer id,Model model){
        System.out.println(id);
        List<Area> a = iEmployeeService.areaSelect();
        List<EmployeeVO> findone = iEmployeeService.findone(id);

        model.addAttribute("a",a);
        model.addAttribute("findone",findone);
        model.addAttribute("eid",id);
        return  "page/staff/staffEdit";
    }
    //删除数据
    @RequestMapping("/staffDel")
    public Object satffDel(Integer id){
        iEmployeeService.staffDelect(id);
        return "redirect:/staff/staffSelect";
    }
    //添加数据
    @RequestMapping("staffAdd")
    public String staffAdd(Model model){
        List<State> states = iEmployeeService.stateAll();
        List<Job> jobs = iEmployeeService.jobAll();
        List<Area> areas = iEmployeeService.areaSelect();
        model.addAttribute("states",states);
        model.addAttribute("areas",areas);
        model.addAttribute("jobs",jobs);
        return "page/staff/staffAdd";
    }
    //添加员工信息
    @ResponseBody
    @RequestMapping("addStaff_do")
    public Object staffAdd_do(Employee employee, String eBirthday)throws Exception{
        SimpleDateFormat aaa = new SimpleDateFormat("yyyy-MM-dd");
        Date date = aaa.parse(eBirthday);
        employee.seteBirthday(date);
        int success = iEmployeeService.addStaff(employee);
        return success;
    }
    //修改员工信息
    @ResponseBody
    @RequestMapping("/staffEdit_do")
    public Object staffEdit_do(Employee employee){
        System.out.println(employee);
        int success = iEmployeeService.editStaff(employee);
        System.out.println(success);
        return success;
    }
    //调动员工
    @RequestMapping("/EmployeeEdit")
    public String employeeEdit(){
        return "page/staff/EmployeeEdit";
    }
    //查询要调动的员工信息
    @RequestMapping("/editEmployee")
    public String selEmployee(Integer id,Model model){
        List<EmployeeVO> findone = iEmployeeService.findone(id);
        List<Job> jobs = iEmployeeService.jobAll();
        List<Area> areas = iEmployeeService.areaSelect();
        model.addAttribute("findone",findone);
        model.addAttribute("jobs",jobs);
        model.addAttribute("areas",areas);
        return "page/staff/emidEmp";
    }
    //员工调动
    @ResponseBody
    @RequestMapping("/employeeEdit_do")
    public Object employeeEdit_do(Employee employee){
        int success = iEmployeeService.editEmployee(employee);
        return success;
    }
}
