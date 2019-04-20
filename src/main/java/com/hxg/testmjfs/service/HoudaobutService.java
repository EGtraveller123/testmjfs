package com.hxg.testmjfs.service;


import com.hxg.testmjfs.bean.Houdaobut;

import java.util.Map;


public interface HoudaobutService {

    //根据款号查询
    Map<String,Object> selectByKuanhao(String kuanhao);

    //添加
    boolean insert(Houdaobut houdaobut);
}
