package com.hxg.testmjfs.mapper;

import com.hxg.testmjfs.bean.Caijianbut;

public interface CaijianbutMapper {
    /**
     * 添加caijianbut信息
     * @param caijianbut
     */
    void insert(Caijianbut caijianbut);

    /**
     * 选择指定 款号
     * @param kuanhao
     * @return 返回指定对应的所有信息
     */
    Caijianbut selectByKuanhao(String kuanhao);
}
