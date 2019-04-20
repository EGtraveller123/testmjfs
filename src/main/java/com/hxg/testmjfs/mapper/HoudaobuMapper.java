package com.hxg.testmjfs.mapper;

import com.hxg.testmjfs.bean.Houdaobu;

public interface HoudaobuMapper {

    /**
     *
     * @param kuanhao
     * @return
     */
    Houdaobu selectByKuanhao(String kuanhao);


    /**
     * 更新
     * @param houdaobu
     */
    boolean updateHoudaobu(Houdaobu houdaobu);
}
