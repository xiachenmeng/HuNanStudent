package com.qf.service;

import com.qf.bean.Menu;

import java.util.List;

public interface MenuMapperService {

    List<Menu> findmenus();
    int deleteByPrimaryKey(Integer menuid);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer menuid);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}