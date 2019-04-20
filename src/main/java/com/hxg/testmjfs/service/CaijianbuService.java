package com.hxg.testmjfs.service;

import com.hxg.testmjfs.bean.Caijianbu;

import java.util.Map;

public interface CaijianbuService {
    Map<String,Object> selectByKuanhao(String kuanhao);

    boolean update(String caijianbu);
}
