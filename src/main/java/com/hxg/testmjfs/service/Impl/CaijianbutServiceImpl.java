package com.hxg.testmjfs.service.Impl;

import com.hxg.testmjfs.bean.Caijianbut;
import com.hxg.testmjfs.mapper.CaijianbutMapper;
import com.hxg.testmjfs.service.CaijianbutService;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CaijianbutServiceImpl implements CaijianbutService {

    @Autowired
    private CaijianbutMapper caijianbutMapper;

    @Override
    public Map<String, Object> selectByKuanhao(String kuanhao) {
        // 初始化结果集
        Map<String, Object> resultSet = new HashMap<>();
        List<Caijianbut> yewubuts = new ArrayList<>();
        long total = 0;

        // 查询
        Caijianbut caijianbut=null;
        try {
            caijianbut = caijianbutMapper.selectByKuanhao(kuanhao);
        } catch (PersistenceException e) {
            System.out.println("exception catch");
            e.printStackTrace();
        }

        if (caijianbut != null) {
            yewubuts.add(caijianbut);
            total = 1;
        }

        resultSet.put("data", yewubuts);
        resultSet.put("total", total);
        return resultSet;
    }

    @Override
    public boolean insert(Caijianbut caijianbut) {
        // 插入新的记录
        if (null == caijianbutMapper.selectByKuanhao(caijianbut.getKuanhao())) {
            caijianbutMapper.insert(caijianbut);
            return true;
        }else{
            return false;
        }
    }
}
