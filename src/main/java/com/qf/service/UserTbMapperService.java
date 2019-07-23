package com.qf.service;

import com.qf.bean.UserTb;

public interface UserTbMapperService {

    UserTb login(String username,String password);
    boolean checkname(String name);
    int deleteByPrimaryKey(Integer userId);

    int insert(UserTb record);

    int insertSelective(UserTb record);

    UserTb selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserTb record);

    int updateByPrimaryKey(UserTb record);
    UserTb updateuser(UserTb userTb);
}