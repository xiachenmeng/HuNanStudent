package com.qf.service;

import com.github.pagehelper.PageInfo;
import com.qf.bean.Role;

import java.util.List;

public interface RoleMapperService {

    //查询全部角色
    PageInfo findall(int index,int size);

    /*删除该角色的中间表
    int deletemiddle();*/

    int insertrole(Role r, int[] menuid);
    int update(Role r,int[] mid);
    int deleteByPrimaryKey(Integer roleid);
    int change(int rid,int state);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}