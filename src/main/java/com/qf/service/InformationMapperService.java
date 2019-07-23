package com.qf.service;

import com.github.pagehelper.PageInfo;
import com.qf.bean.Information;

import java.util.List;

public interface InformationMapperService {

    List findinfotpe();
    PageInfo findall(int index,int size,String infname,String infotype);

    int deleteByPrimaryKey(Integer informationid);

    int insert(Information record);

    int insertSelective(Information record);

    Information selectByPrimaryKey(Integer informationid);

    int updateByPrimaryKeySelective(Information record);

    int updateByPrimaryKey(Information record);
}