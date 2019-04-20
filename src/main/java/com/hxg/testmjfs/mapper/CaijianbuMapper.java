package com.hxg.testmjfs.mapper;

import com.hxg.testmjfs.bean.Caijianbu;

import java.util.List;
import java.util.Map;

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
