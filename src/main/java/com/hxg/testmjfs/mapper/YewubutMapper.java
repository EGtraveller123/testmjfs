package com.hxg.testmjfs.mapper;

import com.hxg.testmjfs.bean.Yewubut;


public interface YewubutMapper {
    /**
     *
     * @param yewubut
     */
    //添加
    void insert(Yewubut yewubut);
    /**
     *
     * @param kuanhao
     */
    //删除
    void delete(String kuanhao);
    /**
     *
     * @param kuanhao
     */
    //查询
    Yewubut selectByKuanhao(String kuanhao);


}
