package com.hxg.testmjfs.controller;


import com.hxg.testmjfs.bean.Yewubut;
import com.hxg.testmjfs.service.YewubutService;
import com.hxg.testmjfs.util.Response;
import com.hxg.testmjfs.util.ResponseFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
@RequestMapping("/")
public class YewubutController {
    @Autowired
    private YewubutService  yewubutService;

    /**
     * 添加业务部信息
     *
     * @param yewubut
     * @return 返回一个map，其中：key 为 result表示操作的结果，包括：success 与 error
     */
    @RequestMapping(value = "addYewubut", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, Object> addYewubut(@RequestBody Yewubut yewubut){
        // 初始化 Response
        Response responseContent = ResponseFactory.newInstance();

        // 添加记录
        String result = yewubutService.insertYewubut(yewubut) ? Response.RESPONSE_RESULT_SUCCESS : Response.RESPONSE_RESULT_ERROR;

        responseContent.setResponseResult(result);
        return responseContent.generateResponse();
    }


    /**
     * 查询kuanhao
     *
     * @param kuanhao
     * @return 返回一个map，其中：key 为 result 的值为操作的结果
     * 的值为客户信息
     */
    @RequestMapping(value = "ywbtkuanhao",method = RequestMethod.GET)
    public
    @ResponseBody
    Map<String, Object> getYwbKehu(@RequestParam("kuanhao") String kuanhao){
        // 初始化 Response
        Response responseContent = ResponseFactory.newInstance();
        String result = Response.RESPONSE_RESULT_ERROR;

        //获取业务部信息
        Yewubut yewubut=null;
        Map<String, Object> queryResult = query(kuanhao);
        if (queryResult != null) {
            yewubut = (Yewubut) queryResult.get("data");
            if (yewubut != null) {
                result = Response.RESPONSE_RESULT_SUCCESS;
            }
        }
        // 设置 Response
        responseContent.setResponseResult(result);
        responseContent.setResponseData(yewubut);

        return responseContent.generateResponse();
    }

    private Map<String, Object> query(String kuanhao) {
        Map<String, Object> queryResult = null;
        queryResult = yewubutService.selectByKuanhao(kuanhao);
        return queryResult;
    }


    /**
     * 删除业务部信息
     *
     * @param yewubutKuanhao
     * @return 返回一个map，其中：key 为 result表示操作的结果，包括：success 与 error
     */
    @RequestMapping(value = "deleteYewubut", method = RequestMethod.GET)
    public
    @ResponseBody
    Map<String, Object> deleteYewubut(@RequestParam("yewubutKuanhao") String yewubutKuanhao){
        // 初始化 Response
        Response responseContent = ResponseFactory.newInstance();
        // 参数检查
        if (StringUtils.isNumeric(yewubutKuanhao)) {
            // 转换为 Integer
            Integer customerID = Integer.valueOf(yewubutKuanhao);

            // 刪除
            String result = yewubutService.deleteYewubu(yewubutKuanhao) ? Response.RESPONSE_RESULT_SUCCESS : Response.RESPONSE_RESULT_ERROR;
            responseContent.setResponseResult(result);
        } else
            responseContent.setResponseResult(Response.RESPONSE_RESULT_ERROR);

        return responseContent.generateResponse();
    }



}
