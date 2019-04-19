package com.hxg.testmjfs.service;

import com.hxg.testmjfs.bean.Yewubu;

import java.util.Map;

public interface YewubuService {

    /**
     * 根据款号查询所有业务部的记录
     *
     * @return 结果的一个Map，其中： key为 data 的代表记录数据；key 为 total 代表结果记录的数量
     */
    Map<String,Object> selectByKuanhao(String kuanhao);

    /**
     * 查询分页
     *
     * @param offset       分页的偏移值
     * @param limit        分页的大小
     * @param kuanhao 客户的名称
     * @return 结果的一个Map，其中： key为 data 的代表记录数据；key 为 total 代表结果记录的数量
     */
    Map<String, Object> selectByKuanhao(int offset, int limit, String kuanhao);
    /**
     * 根据客户查询所有业务部的记录
     *
     * @return 结果的一个Map，其中： key为 data 的代表记录数据；key 为 total 代表结果记录的数量
     */
    Map<String,Object> selectByKehu(int offset, int limit, String kehu);


    /**
     * 查询所有业务部的记录
     *
     * @return 结果的一个Map，其中： key为 data 的代表记录数据；key 为 total 代表结果记录的数量
     */
    Map<String,Object> selectAll(int offset, int limit);


    /**
     * 添加业务部信息
     *
     * @param yewubu 客户信息
     * @return 返回一个boolean值，值为true代表更新成功，否则代表失败
     */
    boolean insert(Yewubu yewubu);


    /**
     * 更新业务部信息
     *
     * @param yewubu 客户信息
     * @return 返回一个boolean值，值为true代表更新成功，否则代表失败
     */
    boolean update(Yewubu yewubu);


    /**
     * 根据款号删除客户信息
     *
     * @param kuanhao 客户ID
     * @return 返回一个boolean值，值为true代表更新成功，否则代表失败
     */
    boolean delete(String kuanhao);


}
