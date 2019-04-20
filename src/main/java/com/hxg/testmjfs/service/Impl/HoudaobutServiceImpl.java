package com.hxg.testmjfs.service.Impl;

import com.hxg.testmjfs.bean.Houdaobut;
import com.hxg.testmjfs.mapper.HoudaobutMapper;
import com.hxg.testmjfs.service.HoudaobutService;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HoudaobutServiceImpl implements HoudaobutService {

    @Autowired
    private HoudaobutMapper houdaobutMapper;

    @Override
    public Map<String, Object> selectByKuanhao(String kuanhao) {
        // 初始化结果集
        Map<String, Object> resultSet = new HashMap<>();
        List<Houdaobut> houdaobuts = new ArrayList<>();
        long total = 0;

        // 查询
        Houdaobut houdaobut=null;
        try {
            houdaobut = houdaobutMapper.selectByKuanhao(kuanhao);
        } catch (PersistenceException e) {
            System.out.println("exception catch");
            e.printStackTrace();
        }

        if (houdaobut != null) {
            houdaobuts.add(houdaobut);
            total = 1;
        }

        resultSet.put("data", houdaobuts);
        resultSet.put("total", total);
        return resultSet;
    }

    @Override
    public boolean insert(Houdaobut houdaobut) {
        // 插入新的记录
        if (null == houdaobutMapper.selectByKuanhao(houdaobut.getKuanhao())) {
            houdaobutMapper.insert(houdaobut);
            return true;
        }else{
            return false;
        }
    }
}
