package com.qf.service.impl;

import com.qf.bean.Menu;
import com.qf.bean.Role;
import com.qf.bean.UserTb;
import com.qf.dao.MenuMapper;
import com.qf.dao.UserTbMapper;
import com.qf.service.UserTbMapperService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserTbMapperServiceImpl implements UserTbMapperService {

    @Resource
    private UserTbMapper userTbMapper;
    @Resource
    private MenuMapper menuMapper;

    @Override
    @Transactional
    public UserTb login(String username, String password) {
       //1.根据用户名查询用户信息
        UserTb userTb = userTbMapper.login(username);
        //2.验证密码
        if (userTb != null && password.equals(userTb.getUserPs())) {
        //修改登录次数
            int count=userTb.getLogincount()+1;
        //调取修改方法
            userTb.setLogincount(count);
            int i = userTbMapper.updateByPrimaryKeySelective(userTb);

            //查询菜单信息
            List<Menu> menus = menuMapper.findbyroleid(userTb.getRoleId());
//2.1将菜单分成一二级
            List newmenus=new ArrayList();
            for (Menu menu : menus) {
                if (menu.getUpmenuid()==-1){
                    List second=new ArrayList();
                    //2.2哪些二级菜单属于当前的一级菜单
                    for (Menu menu1 : menus) {
                        if (menu.getMenuid()==menu1.getUpmenuid()){
                            second.add(menu1);
                        }
                    }
                    menu.setSecondmenus(second);
                    newmenus.add(menu);
                }
            }
            Role role=new Role();
            role.setMenuList(newmenus);
            userTb.setRole(role);
            return userTb;
        }
        return null;
    }

    @Override
    public boolean checkname(String name) {
        String checkname=userTbMapper.checkname(name);
        if (checkname != null) {
            return true;
        }
        return false;
    }

    @Override
    public int deleteByPrimaryKey(Integer userId) {
        return 0;
    }

    @Override
    public int insert(UserTb record) {
        return 0;
    }

    @Override
    public int insertSelective(UserTb record) {
        return 0;
    }

    @Override
    public UserTb selectByPrimaryKey(Integer userId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(UserTb record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(UserTb record) {
        return userTbMapper.updateByPrimaryKey(record);
    }

    @Override
    public UserTb updateuser(UserTb userTb) {
        int i = userTbMapper.updateByPrimaryKeySelective(userTb);
        if (i>0){
            String userName = userTb.getUserName();
            UserTb userTb1 = userTbMapper.login(userName);
            return userTb1;
        }
        return null;
    }

}