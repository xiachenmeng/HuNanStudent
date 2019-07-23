package com.qf.service;

import com.qf.bean.Department;

import java.util.List;

public interface DepartmentMapperService {

    //全查
    List<Department> findall();
    int deleteByPrimaryKey(Integer departid);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer departid);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}