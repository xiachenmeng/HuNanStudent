package com.qf.controller;

import com.github.pagehelper.PageInfo;
import com.qf.bean.Classes;
import com.qf.bean.UserTb;
import com.qf.service.ClassesMapperService;
import com.qf.util.ClassEnum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class EducationalController {

    @Resource
    private ClassesMapperService classesMapperService;

    /**
     * 审核班级
     * @param classid
     * @param state
     * @return
     */
    @RequestMapping("/Educational/updatestate/{a1}/{b1}")
    public String audit(@PathVariable(name="a1") int classid,@PathVariable(name="b1") int state){
        Classes classes=new Classes();
        classes.setClassid(classid);
        switch (state){
            case 1:
                classes.setClassstate("审核通过");
                break;
            case 0:
                classes.setClassstate("审核未通过");
                break;
        }
        classesMapperService.updateByPrimaryKeySelective(classes);
        return "redirect:/Educational/findall";
    }

    /**
     * 班级审核
     * @param map
     * @param index
     * @param classnum
     * @param classname
     * @return
     */
    @RequestMapping("/Educational/findall")
    public String findall(ModelMap map, @RequestParam(defaultValue ="1") int index, String classnum, String classname, HttpSession session){
        UserTb userTb = (UserTb)session.getAttribute("user");
        PageInfo pageInfo = classesMapperService.findall(index, ClassEnum.PAGE_SIZE.getValue(), classnum,classname, "审核中",userTb.getUserId());
        map.addAttribute("pi",pageInfo);
        map.addAttribute("cname",classname);
        map.addAttribute("cnum",classnum);
        return "/Educational/Auditing";
    }

}
