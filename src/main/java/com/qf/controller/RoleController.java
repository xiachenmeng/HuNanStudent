package com.qf.controller;

import com.github.pagehelper.PageInfo;
import com.qf.bean.Menu;
import com.qf.bean.Role;
import com.qf.service.MenuMapperService;
import com.qf.service.RoleMapperService;
import com.qf.util.BookEnum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class RoleController {

    @Resource
    private RoleMapperService roleMapperService;
    @Resource
    private MenuMapperService menuMapperService;

//查询所有菜单
    @RequestMapping("power/role/selectmenus")
    public String getmenus(ModelMap map){
        List<Menu> menus = menuMapperService.findmenus();
        map.addAttribute("menus",menus);
        return "power/role/add";
    }


    /**
     * 查询所有角色
     * @param index
     * @param map
     * @return
     */
    @RequestMapping("/power/role/list")
    public String getlist(@RequestParam(defaultValue = "1") int index, ModelMap map){
        PageInfo pageInfo = roleMapperService.findall(index, BookEnum.ROLE_PAGE_SIZE.getValue());
        map.addAttribute("pi",pageInfo);
        return "power/role/list";
    }

    /**
     * 添加角色
     * @param role
     * @param menuid
     * @return
     */
    @RequestMapping("/power/role/add")
    public String add(Role role,int[] menuid){
        int i = roleMapperService.insertrole(role, menuid);
        return "redirect:/power/role/list";
    }

    /**
     * 主键查询角色
     * @param roleid
     * @param map
     * @return
     */
    @RequestMapping("/power/role/findbyrid")
    public String selectrole(int roleid,ModelMap map){
    Role role = roleMapperService.selectByPrimaryKey(roleid);
    List<Menu> menus = menuMapperService.findmenus();
    map.addAttribute("role",role);
    map.addAttribute("menus",menus);
    return "power/role/edit";
}

    /**
     * 跟新角色
     * @param role
     * @param menuid
     * @return
     */
    @RequestMapping("/power/role/update")
    public String update(Role role,int[] menuid){
        int insertrole = roleMapperService.update(role, menuid);
        return "redirect:/power/role/list";
    }

    /**
     * 删除角色
     * @param roleid
     * @param response
     * @return
     */
    @RequestMapping("/power/role/delect")
    public String delect(int roleid, HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i = roleMapperService.deleteByPrimaryKey(roleid);
      if (i>0){
         writer.print("<script>alert('该角色被占用');location.href='/power/role/list'</script>");
     }else {
          return "redirect:/power/role/list";
      }
      return null;
    }

    /**
     *更改角色的禁用启用状态
     * @param roleid
     * @param rolestate
     * @return
     */
    @RequestMapping("power/role/changestate/{roleid}/{rolestate}")
    public void change(@PathVariable(name="roleid") int roleid,@PathVariable(name = "rolestate")int rolestate,HttpServletResponse response){
        int i = roleMapperService.change(roleid, rolestate);
        try {
            response.setContentType("text/html;charset=utf-8");
            if (i>0){
                response.getWriter().print("true");
            }else{
                response.getWriter().print("flase");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }






}
