package com.qf.dao;

import com.qf.bean.Classes;

import java.util.List;
import java.util.Map;

public interface ClassesMapper {

    List findall(Map map);

    List<Classes> findclassbyid(int majorid);

    //根据专业id查询老师列表
    List<String> findteacher(int mid);

    int deleteByPrimaryKey(Integer classid);

    int insert(Classes record);

    int insertSelective(Classes record);

    Classes selectByPrimaryKey(Integer classid);

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);
}