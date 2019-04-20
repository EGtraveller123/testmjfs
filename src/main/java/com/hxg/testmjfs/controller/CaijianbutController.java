package com.hxg.testmjfs.controller;

import com.hxg.testmjfs.bean.Caijianbu;
import com.hxg.testmjfs.bean.Caijianbut;
import com.hxg.testmjfs.service.CaijianbutService;
import com.hxg.testmjfs.util.Response;
import com.hxg.testmjfs.util.ResponseFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/cjbt")
public class CaijianbutController {
    @Autowired
    private CaijianbutService caijianbutService;

    private static final String SELECT_BY_KUANHAO = "selectByKuanhao";

    /**
     * 通用的结果查询方法
     *
     * @param searchType 查询方式
     * @param keyWord    查询关键字
     * @param offset     分页偏移值
     * @param limit      分页大小
     * @return 返回指定条件查询的结果
     */
    private Map<String, Object> query(String searchType, String keyWord, int offset, int limit) {
        Map<String, Object> queryResult = null;
            if (StringUtils.isNumeric(keyWord))
                queryResult = caijianbutService.selectByKuanhao(keyWord);
        return queryResult;
    }

    /**
     * 查询指定kuanhao的信息
     *
     * @param kuanhao 款号
     * @return 返回一个map，其中：key 为 result 的值为操作的结果，包括：success 与 error；key 为 data
     * 的值为客户信息
     */
    @RequestMapping(value = "kuanhao",method = RequestMethod.GET)
    public
    @ResponseBody
    Map<String, Object> getCjbtKuanhao(@RequestParam("kuanhao") String kuanhao){
        // 初始化 Response
        Response responseContent = ResponseFactory.newInstance();
        String result = Response.RESPONSE_RESULT_ERROR;

        //获取业务部信息
        Caijianbut caijianbut=null;
        Map<String, Object> queryResult = query(SELECT_BY_KUANHAO, kuanhao, -1, -1);
        if (queryResult != null) {
            caijianbut = (Caijianbut) queryResult.get("data");
            if (caijianbut != null) {
                result = Response.RESPONSE_RESULT_SUCCESS;
            }
        }
        // 设置 Response
        responseContent.setResponseResult(result);
        responseContent.setResponseData(caijianbut);

        return responseContent.generateResponse();
    }

    /**
     * 添加一条裁剪部具体信息
     * @param caijianbut
     * @return 返回一个map，其中：key 为 result表示操作的结果，包括：success 与 error
     */
    @RequestMapping(value = "addCjbt", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, Object> addCaijianbut(@RequestBody Caijianbut caijianbut){
        // 初始化 Response
        Response responseContent = ResponseFactory.newInstance();

        // 添加记录
        String result = caijianbutService.insert(caijianbut) ? Response.RESPONSE_RESULT_SUCCESS : Response.RESPONSE_RESULT_ERROR;

        responseContent.setResponseResult(result);
        return responseContent.generateResponse();
    }


}
