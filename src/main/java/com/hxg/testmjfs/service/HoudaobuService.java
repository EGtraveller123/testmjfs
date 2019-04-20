package com.hxg.testmjfs.service;

import java.util.Map;

public interface HoudaobuService {
    Map<String,Object> selectByKuanhao(String kuanhao);

    boolean update(String houdaobu);
}
