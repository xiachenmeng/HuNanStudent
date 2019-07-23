package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.bean.Classes;
import com.qf.dao.ClassesMapper;
import com.qf.service.ClassesMapperService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClassesMapperServiceImpl implements ClassesMapperService {

    @Resource
    private ClassesMapper classesMapper;


    @Override
    public List<String> findteacher(int mid) {
        return classesMapper.findteacher(mid);
    }

    @Override
    public PageInfo findall(int index, int size,String classnum, String classname,String classsate,int auditid) {
        PageHelper.startPage(index, size);
        Map map=new HashMap();
        map.put("cname",classname);
        map.put("classnum",classnum);
        map.put("classsate",classsate);
        map.put("auditid",auditid);
        List list = classesMapper.findall(map);
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }

    @Override
    public List<Classes> findclassbyid(int majorid) {
        return classesMapper.findclassbyid(majorid);
    }

    @Override
    public int deleteByPrimaryKey(Integer classid) {
        return 0;
    }

    @Override
    public int insert(Classes record) {
        return 0;
    }

    @Override
    @Transactional
    public int insertSelective(Classes record) {
        return classesMapper.insertSelective(record);
    }

    @Override
    public Classes selectByPrimaryKey(Integer classid) {
        return classesMapper.selectByPrimaryKey(classid);
    }

    @Override
    public int updateByPrimaryKeySelective(Classes record) {
        return classesMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Classes record) {
        return 0;
    }
}
