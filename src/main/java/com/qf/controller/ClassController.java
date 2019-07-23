package com.qf.controller;

import com.github.pagehelper.PageInfo;
import com.qf.bean.Classes;
import com.qf.bean.Department;
import com.qf.bean.Major;
import com.qf.bean.UserTb;
import com.qf.service.ClassesMapperService;
import com.qf.service.DepartmentMapperService;
import com.qf.service.MajorMapperService;
import com.qf.util.ClassEnum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ClassController {

    @Resource
    private ClassesMapperService classesMapperService;
    @Resource
    private DepartmentMapperService departmentMapperService;
    @Resource
    private MajorMapperService majorMapperService;



    /**
     * 提交审核
     * @param classes
     * @return
     */
    @RequestMapping("/Educational/class/submitaudit")
    public String submitaudit(Classes classes, HttpSession session){
        classes.setClassstate("审核中");
        //1.缺少审核人的id
        UserTb user = (UserTb) session.getAttribute("user");
        classes.setAuditid(user.getManagerid());
        //2.缺少审核次数的值
        Classes classes1= classesMapperService.selectByPrimaryKey(classes.getClassid());
        classes.setAuditcount(classes1.getAuditcount()+1);
        classesMapperService.updateByPrimaryKeySelective(classes);

        return "redirect:/Educational/class/selectall";
    }


    /**
     * 增加班级
     * @param classes
     * @return
     */
    @RequestMapping("/Educational/class/add")
    public String add(Classes classes){
        classes.setClassstate("未审核");
        classesMapperService.insertSelective(classes);
        return "redirect:/Educational/class/selectall";
    }


    /**
     * 查询所有的学院信息
     */
    @RequestMapping("/Educational/class/selectdepts")
    public String getdepts(ModelMap map){
        List<Department> departments = departmentMapperService.findall();
        map.addAttribute("dlist",departments);
        return "Educational/class/add";
    }

    @RequestMapping("/Educational/class/findclassbyid")
    @ResponseBody
    public List getteacher(int mid){
        List<String> strings = classesMapperService.findteacher(mid);
        return strings;
    }

    @RequestMapping("/Educational/class/findmajorbyid")
    @ResponseBody
    public List getmajor(int deptid){
        List<Major> majorList = majorMapperService.findbydeptid(deptid);
        return majorList;
    }

    /**
     * 班级管理
     * @param map
     * @param index
     * @param classnum
     * @param classname
     * @return
     */
    @RequestMapping("/Educational/class/selectall")
    public String findall(ModelMap map, @RequestParam(defaultValue ="1") int index,String classnum, String classname){
        PageInfo pageInfo = classesMapperService.findall(index, ClassEnum.PAGE_SIZE.getValue(), classnum, classname,null,-1);
        map.addAttribute("pi",pageInfo);
        map.addAttribute("cname",classname);
        return "/Educational/class/list";
    }
}
