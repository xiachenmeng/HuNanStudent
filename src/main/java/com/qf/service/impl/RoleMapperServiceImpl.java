package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.bean.Role;
import com.qf.dao.RoleMapper;
import com.qf.service.RoleMapperService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleMapperServiceImpl implements RoleMapperService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public PageInfo findall(int index, int size) {
        PageHelper.startPage(index,size);
        List<Role> list = roleMapper.findall();
        return new PageInfo(list);
    }

    @Override
    @Transactional
    public int insertrole(Role r, int[] menuid) {
        //1.先添加角色类
        roleMapper.insertSelective(r);
        //2.添加中间表
        int roleid=r.getRoleid();
        Map map=new HashMap();
        map.put("rid",roleid);
        map.put("menuids",menuid);
        int insertmiddle = roleMapper.insertmiddle(map);
        return insertmiddle;
    }

    @Override
    public int update(Role r, int[] mid) {
        //1.修改角色
       roleMapper.updateByPrimaryKeySelective(r);
       //2.删除中间表中该角色的菜单信息
        System.out.println(r+"**********");
        System.out.println(r.getRoleid()+"++++");
       roleMapper.deletemiddle(r.getRoleid());
       //3.给中间表中添加新的菜单-角色的对应关系
        Map map=new HashMap();
        map.put("rid",r.getRoleid());
        map.put("menuids",mid);
        int insertmiddle = roleMapper.insertmiddle(map);
        return insertmiddle;
    }

    @Override
    public int deleteByPrimaryKey(Integer roleid) {
        //1.先查询该角色是否还有用户占用
        int i = roleMapper.selectbyrid(roleid);
        if (i==0){
            //没有占用先删除中间表,在删除角色表中数据
            roleMapper.deletemiddle(roleid);
            roleMapper.deleteByPrimaryKey(roleid);
        }
        return i;
    }

    @Override
    public int change(int rid, int state) {
        Map map=new HashMap();
        map.put("rid",rid);
        map.put("state",state);
        int change = roleMapper.change(map);
        return change;
    }

    @Override
    public int insert(Role record) {
        return 0;
    }

    @Override
    public int insertSelective(Role record) {
        return 0;
    }

    @Override
    public Role selectByPrimaryKey(Integer roleid) {
        return roleMapper.selectByPrimaryKey(roleid);
    }

    @Override
    public int updateByPrimaryKeySelective(Role record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Role record) {
        return 0;
    }
}
