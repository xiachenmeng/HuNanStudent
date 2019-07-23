package com.qf.service;

import com.qf.bean.Major;

import java.util.List;

public interface MajorMapperService {

    //根据学院id查询专业列表
    public List<Major> findbydeptid(int deptid);
    int deleteByPrimaryKey(Integer majorid);

    int insert(Major record);

    int insertSelective(Major record);

    Major selectByPrimaryKey(Integer majorid);

    int updateByPrimaryKeySelective(Major record);

    int updateByPrimaryKey(Major record);
}