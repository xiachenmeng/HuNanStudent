package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.bean.Information;
import com.qf.dao.InformationMapper;
import com.qf.dao.InfotypeMapper;
import com.qf.service.InformationMapperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InformationMapperServiceImpl implements InformationMapperService {

    @Resource
    private InformationMapper informationMapper;
    @Resource
    private InfotypeMapper infotypeMapper;

    @Override
    public List findinfotpe() {
        List list = infotypeMapper.findall();
        return list;
    }

    @Override
    public PageInfo findall(int index, int size, String infname,String infotype) {
        PageHelper.startPage(index, size);
        Map map=new HashMap();
        map.put("infname",infname);
        map.put("infotype",infotype);
        List list = informationMapper.findall(map);
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }

    @Override
    public int deleteByPrimaryKey(Integer informationid) {
        return 0;
    }

    @Override
    public int insert(Information record) {
        return 0;
    }

    @Override
    public int insertSelective(Information record) {
        int i = informationMapper.insertSelective(record);
        return i;
    }

    @Override
    public Information selectByPrimaryKey(Integer informationid) {
        Information information = informationMapper.selectByPrimaryKey(informationid);
        return information;
    }

    @Override
    public int updateByPrimaryKeySelective(Information record) {
        int i = informationMapper.updateByPrimaryKeySelective(record);
        System.out.println(i+"##########");
        return i;
    }

    @Override
    public int updateByPrimaryKey(Information record) {
        return 0;
    }
}
