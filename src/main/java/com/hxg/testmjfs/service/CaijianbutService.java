package com.hxg.testmjfs.service;

import com.hxg.testmjfs.bean.Caijianbut;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;


public interface CaijianbutService {

    //根据款号查询
    Map<String,Object> selectByKuanhao(String kuanhao);

    //添加
    boolean insert(Caijianbut caijianbut);
}
