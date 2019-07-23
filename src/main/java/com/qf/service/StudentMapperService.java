package com.qf.service;

import com.github.pagehelper.PageInfo;
import com.qf.bean.Student;

import java.util.List;

public interface StudentMapperService {
    //查询学生信息列表
    public PageInfo<Student> findall(int index,int size, String stuname,String stuno,int stusex);
    int deleteByPrimaryKey(Integer studentid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer studentid);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}