package com.qf.dao;

import com.qf.bean.Student;

import java.util.List;
import java.util.Map;

public interface StudentMapper {
    //查询学生信息列表
    public List<Student> findall(Map map);

    int deleteByPrimaryKey(Integer studentid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer studentid);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}