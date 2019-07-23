package com.qf.dao;

import com.qf.bean.Menu;

import java.util.List;

public interface MenuMapper {

    List<Menu> findmenus();
    int deleteByPrimaryKey(Integer menuid);
    List<Menu> findbyroleid(int roleid);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer menuid);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}