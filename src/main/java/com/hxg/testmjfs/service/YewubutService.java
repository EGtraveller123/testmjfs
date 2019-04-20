package com.hxg.testmjfs.service;

import com.hxg.testmjfs.bean.Yewubut;

import java.util.Map;

public interface YewubutService {

    //根据款号查询
    Map<String,Object> selectByKuanhao(String kuanhao);


    //添加业务部
    boolean insertYewubut(Yewubut yewubut);

    //删除
    boolean deleteYewubu(String kuanhao);

}
