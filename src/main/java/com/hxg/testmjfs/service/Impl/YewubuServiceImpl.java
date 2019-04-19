package com.hxg.testmjfs.service.Impl;




import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hxg.testmjfs.bean.Yewubu;
import com.hxg.testmjfs.mapper.YewubuMapper;
import com.hxg.testmjfs.service.YewubuService;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class YewubuServiceImpl implements YewubuService {

    @Autowired
    private YewubuMapper yewubuMapper;

    @Override
    public Map<String, Object> selectByKuanhao(String kuanhao) {
        // 初始化结果集
        Map<String, Object> resultSet = new HashMap<>();
        List<Yewubu> yewubus = new ArrayList<>();
        long total = 0;

        // 查询
        Yewubu yewubu=null;
        try {
            yewubu = yewubuMapper.selectByKuanhao(kuanhao);
        } catch (PersistenceException e) {
            System.out.println("exception catch");
            e.printStackTrace();
        }

        if (yewubu != null) {
            yewubus.add(yewubu);
            total = 1;
        }

        resultSet.put("data", yewubus);
        resultSet.put("total", total);
        return resultSet;
    }

    @Override
    public Map<String, Object> selectByKuanhao(int offset, int limit, String kuanhao) {
        return selectByKuanhao(-1,-1,kuanhao);
    }

    @Override
    public Map<String, Object> selectByKehu(int offset, int limit, String kehu) {
        return selectByKehu(-1,-1,kehu);
    }

    /**
     * 分页查询
     *
     * @param offset 分页的偏移值
     * @param limit  分页的大小
     * @return 结果的一个Map，其中： key为 data 的代表记录数据；key 为 total 代表结果记录的数量
     */
    @Override
    public Map<String, Object> selectAll(int offset, int limit) {
        // 初始化结果集
        Map<String, Object> resultSet = new HashMap<>();
        List<Yewubu> yewubus = null;
        long total = 0;
        boolean isPagination = true;

        // validate
        if (offset < 0 || limit < 0)
            isPagination = false;

        // query
        try {
            if (isPagination) {
                PageHelper.offsetPage(offset, limit);
                yewubus = yewubuMapper.selectAll();
                if (yewubus != null) {
                    PageInfo<Yewubu> pageInfo = new PageInfo<>(yewubus);
                    total = pageInfo.getTotal();
                } else
                    yewubus = new ArrayList<>();
            } else {
                yewubus = yewubuMapper.selectAll();
                if (yewubus != null)
                    total = yewubus.size();
                else
                    yewubus = new ArrayList<>();
            }
        } catch (PersistenceException e) {
            System.out.println("......");
        }

        resultSet.put("data", yewubus);
        resultSet.put("total", total);
        return resultSet;
    }



    /**
     * 添加客户信息
     *
     * @param yewubu 业务部
     * @return 返回一个boolean值，值为true代表更新成功，否则代表失败
     */
    @Override
    public boolean insert(Yewubu yewubu) {
// 插入新的记录
        if (yewubu != null) {
            // 验证
            if (yewuCheck(yewubu)) {
                try {
                    if (null == yewubuMapper.selectByKuanhao(yewubu.getKuanhao())) {
                        yewubuMapper.insert(yewubu);
                        return true;
                    }
                } catch (Exception e) {
                    System.out.println("请按格式正确输入");
                }
            }
        }
        return false;
    }


    /**
     * 更新客户信息
     *
     *
     * @param yewubu 业务信息
     * @return 返回一个boolean值，值为true代表更新成功，否则代表失败
     */
    @Override
    public boolean update(Yewubu yewubu) {

        //更新记录
        if (yewubu != null) {
            // 检验
            if (yewuCheck(yewubu)) {
                //检查款号是否重复
                Yewubu yewubus = yewubuMapper.selectByKuanhao(yewubu.getKuanhao());
                if(yewubus == null || yewubus.getKuanhao().equals(yewubus.getKuanhao())){
                    yewubuMapper.update(yewubu);
                    return true;
                }
            }else{
                System.out.println("请检查格式是否正确");
            }
        }
        return false;
    }

    /**
     * 删除客户信息
     *
     * @param kuanhao 根据款号
     * @return 返回一个boolean值，值为true代表更新成功，否则代表失败
     */
    @Override
    public boolean delete(String kuanhao) {
        yewubuMapper.delete(kuanhao);
        return true;
    }


//    /**
//     * 返回指定kuanhao 的客户记录
//     *
//     * @param kuanhao 客户ID
//     * @return 结果的一个Map，其中： key为 data 的代表记录数据；key 为 total 代表结果记录的数量
//     */
//    public Map<String, Object> selectByKuanhao(String kuanhao) {
//        // 初始化结果集
//        Map<String, Object> resultSet = new HashMap<>();
//        List<Yewubu> yewubus = new ArrayList<>();
//        long total = 0;
//
//        // 查询
//        Yewubu yewubu=null;
//        try {
//            yewubu = (Yewubu) yewubuMapper.selectByKuanhao(kuanhao);
//        } catch (PersistenceException e) {
//            System.out.println("exception catch");
//            e.printStackTrace();
//        }
//
//        if (yewubu != null) {
//            yewubus.add(yewubu);
//            total = 1;
//        }
//
//        resultSet.put("data", yewubus);
//        resultSet.put("total", total);
//        return resultSet;
//    }
//
//
//
//    /**
//     * 添加客户信息
//     *
//     * @param yewubu 业务部
//     * @return 返回一个boolean值，值为true代表更新成功，否则代表失败
//     */
//
//    public boolean addYewu(Yewubu yewubu) {
//
//        // 插入新的记录
//        if (yewubu != null) {
//            // 验证
//            if (yewuCheck(yewubu)) {
//                try {
//                    if (null == yewubuMapper.selectByKuanhao(yewubu.getKuanhao())) {
//                        yewubuMapper.insert(yewubu);
//                        return true;
//                    }
//                } catch (Exception e) {
//                    System.out.println("请按格式正确输入");
//                }
//            }
//        }
//        return false;
//    }
//
//
//
//
//    /**
//     * 更新客户信息
//     *
//     * @param yewubu 业务信息
//     * @return 返回一个boolean值，值为true代表更新成功，否则代表失败
//     */
//
//    public boolean updateYewubu(Yewubu yewubu){
//        // 更新记录
//        if (yewubu != null) {
//            // 检验
//            if (yewuCheck(yewubu)) {
//                //检查款号是否重复
//                Yewubu yewubus = yewubuMapper.selectByKuanhao(yewubu.getKuanhao());
//                if(yewubus == null || yewubus.getKuanhao().equals(yewubus.getKuanhao())){
//                    yewubuMapper.update(yewubu);
//                    return true;
//                }
//            }else{
//                System.out.println("请检查格式是否正确");
//            }
//        }
//        return false;
//    }
//
//    /**
//     * 删除客户信息
//     *
//     * @param yewubuKuhao 根据款号
//     * @return 返回一个boolean值，值为true代表更新成功，否则代表失败
//     */
//    public boolean deleteYewubu(String yewubuKuhao){
//        yewubuMapper.delete(yewubuKuhao);
//        return true;
//    }
//
//
    /**
     * 检查
     */
    private boolean yewuCheck(Yewubu yewubu){
        return yewubu.getKuanhao()!=null && yewubu.getKehu()!=null && yewubu.getYwbshuliang()!=null &&yewubu.getMianliao()!=null && yewubu.getChriqi()!=null;
    }

}