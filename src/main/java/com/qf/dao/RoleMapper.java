package com.qf.dao;

import com.qf.bean.Role;

import java.util.List;
import java.util.Map;

public interface RoleMapper {
    //查询全部角色
    List<Role> findall();
    //删除该角色的中间表
    int deletemiddle(int rid);
    //查询该角色是否有用户占用
    int selectbyrid(int rid);
    //增加中间表
    int insertmiddle(Map map);
    //改变角色启用禁用的状态
    int change(Map map);

    int deleteByPrimaryKey(Integer roleid);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}