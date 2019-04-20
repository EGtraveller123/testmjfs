package com.hxg.testmjfs.mapper;

import com.hxg.testmjfs.bean.Caijianbu;


public interface CaijianbuMapper {

    /**
     *
     * @param kuanhao
     * @return
     */
    Caijianbu selectByKuanhao(String kuanhao);


    /**
     * 更新
     * @param caijianbu
     */
    boolean updateCaijian(Caijianbu caijianbu);
}
