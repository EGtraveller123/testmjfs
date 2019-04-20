package com.hxg.testmjfs.service.Impl;
import com.alibaba.fastjson.JSONObject;

import com.hxg.testmjfs.bean.Houdaobu;
import com.hxg.testmjfs.mapper.HoudaobuMapper;
import com.hxg.testmjfs.service.HoudaobuService;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HoudaobuServiceImpl implements HoudaobuService {

    @Autowired
    private HoudaobuMapper houdaobuMapper;

    @Override
    public Map<String, Object> selectByKuanhao(String kuanhao) {
        // 初始化结果集
        Map<String, Object> resultSet = new HashMap<>();
        List<Houdaobu> houdaobus = new ArrayList<>();
        long total = 0;

        // 查询
        Houdaobu houdaobu=null;
        try {
            houdaobu = houdaobuMapper.selectByKuanhao(kuanhao);
        } catch (PersistenceException e) {
            System.out.println("exception catch");
            e.printStackTrace();
        }

        if (houdaobu != null) {
            houdaobus.add(houdaobu);
            total = 1;
        }

        resultSet.put("data", houdaobus);
        resultSet.put("total", total);
        return resultSet;
    }

    @Override
    public boolean update(String houdaobu) {
        JSONObject parse = JSONObject.parseObject(houdaobu);
        Houdaobu houdaobu1 = new Houdaobu();
        houdaobu1.setId(parse.getInteger("hdbid"));
        houdaobu1.setKuanhao(parse.getString("hdbkuanhao"));
        houdaobu1.setHdbshuliang(parse.getInteger("hdbshuliang"));
        houdaobuMapper.updateHoudaobu(houdaobu1);
        if(houdaobuMapper.selectByKuanhao(parse.getString("kuanhao"))!=null){
            return true;
        }else {
            return false;
        }
    }
}
