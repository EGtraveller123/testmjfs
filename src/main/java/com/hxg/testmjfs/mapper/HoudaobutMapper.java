package com.hxg.testmjfs.mapper;

import com.hxg.testmjfs.bean.Houdaobut;

public interface HoudaobutMapper {
    /**
     * 添加houdaobut信息
     *
     * @param houdaobut
     */
    void insert(Houdaobut houdaobut);

    /**
     * 选择指定 款号
     * @param kuanhao
     * @return 返回指定对应的所有信息
     */
    Houdaobut selectByKuanhao(String kuanhao);
}