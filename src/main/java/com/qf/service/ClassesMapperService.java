package com.qf.service;

import com.github.pagehelper.PageInfo;
import com.qf.bean.Classes;

import java.util.List;

public interface ClassesMapperService {

    //根据专业id查询老师列表
    List<String> findteacher(int mid);

    PageInfo findall(int index, int size,String classnum ,String classname,String classsate,int auditid);

    List<Classes> findclassbyid(int majorid);
    int deleteByPrimaryKey(Integer classid);

    int insert(Classes record);

    int insertSelective(Classes record);

    Classes selectByPrimaryKey(Integer classid);

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);
}