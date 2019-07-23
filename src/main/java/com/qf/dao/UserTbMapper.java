package com.qf.dao;

import com.qf.bean.UserTb;

public interface UserTbMapper {

    UserTb login(String name);
    String checkname(String name);
    int deleteByPrimaryKey(Integer userId);

    int insert(UserTb record);

    int insertSelective(UserTb record);

    UserTb selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserTb record);

    int updateByPrimaryKey(UserTb record);
}