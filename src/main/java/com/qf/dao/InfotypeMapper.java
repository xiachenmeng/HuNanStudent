package com.qf.dao;

import com.qf.bean.Infotype;

import java.util.List;

public interface InfotypeMapper {
    //返回资料的类型
    List findall();
    int deleteByPrimaryKey(Integer infoid);

    int insert(Infotype record);

    int insertSelective(Infotype record);

    Infotype selectByPrimaryKey(Integer infoid);

    int updateByPrimaryKeySelective(Infotype record);

    int updateByPrimaryKey(Infotype record);
}