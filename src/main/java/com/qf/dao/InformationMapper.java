package com.qf.dao;

import com.qf.bean.Information;

import java.util.List;
import java.util.Map;

public interface InformationMapper {

    List findall(Map map);
    int deleteByPrimaryKey(Integer informationid);

    int insert(Information record);

    int insertSelective(Information record);

    Information selectByPrimaryKey(Integer informationid);

    int updateByPrimaryKeySelective(Information record);

    int updateByPrimaryKey(Information record);
}