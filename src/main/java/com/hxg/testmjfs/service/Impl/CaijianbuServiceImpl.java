package com.hxg.testmjfs.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.hxg.testmjfs.bean.Caijianbu;
import com.hxg.testmjfs.mapper.CaijianbuMapper;
import com.hxg.testmjfs.service.CaijianbuService;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CaijianbuServiceImpl implements CaijianbuService {

    @Autowired
    private CaijianbuMapper caijianbuMapper;

    @Override
    public Map<String, Object> selectByKuanhao(String kuanhao) {
        // 初始化结果集
        Map<String, Object> resultSet = new HashMap<>();
        List<Caijianbu> caijianbus = new ArrayList<>();
        long total = 0;

        // 查询
        Caijianbu caijianbu=null;
        try {
            caijianbu = caijianbuMapper.selectByKuanhao(kuanhao);
        } catch (PersistenceException e) {
            System.out.println("exception catch");
            e.printStackTrace();
        }

        if (caijianbu != null) {
            caijianbus.add(caijianbu);
            total = 1;
        }

        resultSet.put("data", caijianbus);
        resultSet.put("total", total);
        return resultSet;
    }

    @Override
    public boolean update(String caijianbu) {
        JSONObject parse = JSONObject.parseObject(caijianbu);
        Caijianbu caijianbu1 = new Caijianbu();
        caijianbu1.setId(parse.getInteger("cjbid"));
        caijianbu1.setKuanhao(parse.getString("cjbkuanhao"));
        caijianbu1.setCjbshuliang(parse.getInteger("cjbshuliang"));
        caijianbuMapper.updateCaijian(caijianbu1);
        if(caijianbuMapper.selectByKuanhao(parse.getString("kuanhao"))!=null){
            return true;
        }else {
            return false;
        }
    }
}
