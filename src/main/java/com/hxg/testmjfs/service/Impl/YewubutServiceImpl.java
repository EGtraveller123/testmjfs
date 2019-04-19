package com.hxg.testmjfs.service.Impl;

import com.hxg.testmjfs.bean.Yewubut;
import com.hxg.testmjfs.mapper.YewubutMapper;
import com.hxg.testmjfs.service.YewubutService;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class YewubutServiceImpl implements YewubutService {

    @Autowired
    YewubutMapper yewubutMapper;

    @Override
    public Map<String, Object> selectByKuanhao(String kunahao) {
        // 初始化结果集
        Map<String, Object> resultSet = new HashMap<>();
        List<Yewubut> yewubuts = new ArrayList<>();
        long total = 0;

        // 查询
        Yewubut yewubut=null;
        try {
            yewubut = yewubutMapper.selectByKuanhao(kunahao);
        } catch (PersistenceException e) {
            System.out.println("exception catch");
            e.printStackTrace();
        }

        if (yewubut != null) {
            yewubuts.add(yewubut);
            total = 1;
        }

        resultSet.put("data", yewubuts);
        resultSet.put("total", total);
        return resultSet;
    }

    /**
     *
     * @param yewubut
     */
    @Override
    public boolean insertYewubut(Yewubut yewubut) {
        // 插入新的记录
        if (yewubut != null) {
            // 验证
            if (yewutCheck(yewubut)) {
                try {
                    if (null == yewubutMapper.selectByKuanhao(yewubut.getKuanhao())) {
                        yewubutMapper.insert(yewubut);
                        return true;
                    }
                } catch (Exception e) {
                    System.out.println(".......");
                }
            }
        }
        return false;
    }
//        // 插入新的记录
//        if (yewubut != null) {
//            // 验证
//            if (yewutCheck(yewubut)) {
//                try {
//                    if (null == yewubutMapper.selectByKuanhao(yewubut.getKuanhao())) {
//                        yewubutMapper.insert(yewubut);
//                        return true;
//                    }
//                } catch (Exception e) {
//                    System.out.println(".......");
//                }
//            }
//        }
//        return false;
//    }

    /**
     *
     * @param kuanhao
     */
    @Override
    public boolean deleteYewubu(String kuanhao) {
        yewubutMapper.delete(kuanhao);
        return true;
    }

    /**
     * 检查
     */
    private boolean yewutCheck(Yewubut yewubut){
        return yewubut.getKuanhao()!=null && yewubut.getYanse()!=null && yewubut.getXs()!=null && yewubut.getS()!=null
                && yewubut.getM()!=null && yewubut.getL()!=null && yewubut.getXxl()!=null && yewubut.getXxxl()!=null;
    }
}
