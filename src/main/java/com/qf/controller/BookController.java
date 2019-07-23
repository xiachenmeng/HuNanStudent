package com.qf.controller;

import com.github.pagehelper.PageInfo;
import com.qf.bean.Information;
import com.qf.service.InformationMapperService;
import com.qf.util.BookEnum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class BookController {

    @Resource
    private InformationMapperService informationMapperService;

    @RequestMapping("/book/update")
    public String update(Information information){
        information.setDate(new Date());
        int i = informationMapperService.updateByPrimaryKeySelective(information);

        return "redirect:/book/selectall";
    }

    @RequestMapping("/book/add")
    public String findtotype(ModelMap map){
        List list = informationMapperService.findinfotpe();
        map.addAttribute("fotype", list);
        return "/book/add";
    }

    @RequestMapping("/book/selectall")
    public String findall(ModelMap map, @RequestParam(defaultValue ="1") int index, String infname,String infotype){
        PageInfo pageInfo = informationMapperService.findall(index, BookEnum.PAGE_SIZE.getValue(),infname,infotype);
        map.addAttribute("pi",pageInfo);
        map.addAttribute("infname",infname);
        map.addAttribute("infotype",infotype);
        return "/book/list-ziliao";
    }

    @RequestMapping("/book/findbyid")
    public String findbyid(ModelMap map,int informationid){
        Information information = informationMapperService.selectByPrimaryKey(informationid);

        map.addAttribute("im",information);
        return "/book/info-ziliao";
    }

    @RequestMapping("/book/findbyid2")
    public String findbyid2(ModelMap map,int informationid){
        Information information = informationMapperService.selectByPrimaryKey(informationid);
        List list = informationMapperService.findinfotpe();
        map.addAttribute("fotype", list);
        map.addAttribute("im",information);
        return "/book/edit-ziliao";
    }


    @RequestMapping("/book/upload")
    public String upload(Information information, MultipartFile myfile, HttpServletRequest request){
        try {
            //上传文件
            String realPath=request.getRealPath("/uploadimg");
            System.out.println("realpath="+realPath);
            myfile.transferTo(new File(realPath+"/"+myfile.getOriginalFilename()) );

            System.out.println(myfile.getOriginalFilename());
            request.setAttribute("filename",myfile.getOriginalFilename());
            information.setDate(new Date());
            information.setInformationname(myfile.getOriginalFilename());
            information.setUrl("/uploadimg"+myfile.getOriginalFilename());
            int i = informationMapperService.insertSelective(information);
            System.out.println(i+"***********");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/book/selectall";
    }

}
