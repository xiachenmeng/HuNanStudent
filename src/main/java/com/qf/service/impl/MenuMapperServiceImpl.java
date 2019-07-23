package com.qf.service.impl;
import com.qf.bean.Menu;
import com.qf.dao.MenuMapper;
import com.qf.service.MenuMapperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuMapperServiceImpl implements MenuMapperService {

    @Resource
    private   MenuMapper menuMapper;

    @Override
    public List<Menu> findmenus() {
        //1.查询所有启用的菜单
        List<Menu> menus = menuMapper.findmenus();
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
        return newmenus;
    }

    @Override
    public int deleteByPrimaryKey(Integer menuid) {
        return 0;
    }

    @Override
    public int insert(Menu record) {
        return 0;
    }

    @Override
    public int insertSelective(Menu record) {
        return 0;
    }

    @Override
    public Menu selectByPrimaryKey(Integer menuid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Menu record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Menu record) {
        return 0;
    }
}
