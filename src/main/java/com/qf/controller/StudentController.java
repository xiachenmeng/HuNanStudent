package com.qf.controller;

import com.github.pagehelper.PageInfo;
import com.qf.bean.Classes;
import com.qf.bean.Department;
import com.qf.bean.Major;
import com.qf.service.ClassesMapperService;
import com.qf.service.DepartmentMapperService;
import com.qf.service.MajorMapperService;
import com.qf.util.StudentEnum;
import com.qf.bean.Student;
import com.qf.service.StudentMapperService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Controller
public class StudentController {

    @Resource
    private StudentMapperService studentMapperService;
    @Resource
   private DepartmentMapperService departmentMapperService;
    @Resource
    private MajorMapperService majorMapperService;
    @Resource
    private ClassesMapperService classesMapperService;

    /**
     * 退学
     * @param student
     * @return
     */
    @RequestMapping("/Educational/student/updatestate")
    public String updateState(Student student){
     student.setStustate("退学");
        int i = studentMapperService.updateByPrimaryKeySelective(student);
        return "redirect:/Educational/student/selectall";
    }


    /**
     * 添加学生
     * @param student
     * @return
     */
    @RequestMapping("/Educational/student/addstudent")
    public String addstudent(Student student){
    student.setRegdate(new Date());
    student.setStustate("正常");
    int i = studentMapperService.insertSelective(student);
    if (i>0){
        return "redirect:/Educational/student/selectall";
    }
    return "redirect:/Educational/student/selectdepts";
    }



    /**
     * 查询所有班级
     * @param mid
     * @return
     */
    @RequestMapping("/Educational/student/findclassbyid")
    @ResponseBody
    public List getclasses(int mid){
        List<Classes> classesList = classesMapperService.findclassbyid(mid);
        return classesList;
    }

    /**
     * 查询所有专业
     * @param deptid
     * @return
     */
    @RequestMapping("/Educational/student/findmajorbyid")
    @ResponseBody
    public List getmajor(int deptid){
        List<Major> majorList = majorMapperService.findbydeptid(deptid);
        return majorList;
    }

    /**
     * 查询所有学院
     * @param map
     * @return
     */
    @RequestMapping("/Educational/student/selectdepts")
    public String getdepts(ModelMap map){
        List<Department> departments = departmentMapperService.findall();
        map.addAttribute("dlist",departments);
        return "Educational/student/add";
    }

    /**
     * 查询所有学生
     * @param map
     * @param index
     * @param stuname
     * @param stuno
     * @param stusex
     * @return
     */
    @RequestMapping("/Educational/student/selectall")
    public String getstudents(ModelMap map,@RequestParam(defaultValue ="1") int index,
                              String stuname,String stuno,@RequestParam(defaultValue ="-1") int stusex){
        PageInfo<Student> pageInfo = studentMapperService.findall(index, StudentEnum.PAGE_SIZE.getValue(),stuname,stuno,stusex);
        map.addAttribute("pi",pageInfo);
        map.addAttribute("sname",stuname);
        map.addAttribute("sno",stuno);
        map.addAttribute("sex",stusex);
        return "Educational/student/list";
    }




}
