package com.qf.controller;


import cn.com.webxml.MobileCodeWSSoap;
import com.qf.bean.Menu;
import com.qf.bean.UserTb;
import com.qf.service.UserTbMapperService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static java.awt.SystemColor.info;

@Controller
public class UserTbController {
    @Resource
    private UserTbMapperService userTbMapperService;
    @Resource
    private MobileCodeWSSoap soap;

   @RequestMapping("getphoneaddress")
   public void test(String phone,HttpServletResponse response){
       try {
           String info = soap.getMobileCodeInfo(phone, "");
           response.setContentType("text/html;charset=utf-8");
           response.getWriter().print(info);
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

    @RequestMapping("/user/updateuser")
    public void updateuser(UserTb userTb,HttpSession session,HttpServletResponse response){
        UserTb user = userTbMapperService.updateuser(userTb);
        try {
            PrintWriter out = response.getWriter();
            if (user!=null){
             session.setAttribute("user",user);
             out.print("<script>top.location.href='/index.jsp'</script>");
            }else{
                out.print("<script>location.href='/MyUser.jsp'</script>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /**
     * 验证同户名
     * @param uname
     * @param response
     */
    @RequestMapping("/user/checkname")
    public void checkname(String uname,HttpServletResponse response){
        try {
            boolean checkname = userTbMapperService.checkname(uname);
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            if (checkname){
             out.print("用户名已存在");
            }else{
                out.print("用户名可用");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 退出登录
     * @param session
     * @return
     */
    @RequestMapping("/out")
    public String loginout(HttpSession session){
        session.invalidate();
        return "redirect:/login.jsp";
    }
    /**
     * 登录
     * @param session
     * @return
     */
    @RequestMapping("/login")
    public void login(String TxtUserName, String TxtPassword, HttpServletResponse response, HttpSession session){
        UserTb userTb = userTbMapperService.login(TxtUserName, TxtPassword);
        try {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter writer = response.getWriter();
            if (userTb==null){
                writer.print("<script>alert('用户名或密码不正确');location.href='login.jsp'</script>");
            }else{
                session.setAttribute("user",userTb);
                writer.print("<script>alert('登陆成功');location.href='index.jsp'</script>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}
