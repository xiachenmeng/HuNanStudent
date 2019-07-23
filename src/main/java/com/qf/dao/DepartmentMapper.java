package com.qf.dao;

import com.qf.bean.Department;

import java.util.List;

public interface DepartmentMapper {
    //查询全部学院
    List<Department> findall();

    int deleteByPrimaryKey(Integer departid);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer departid);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}