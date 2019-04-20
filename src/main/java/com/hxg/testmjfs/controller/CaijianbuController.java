package com.hxg.testmjfs.controller;

import com.hxg.testmjfs.service.CaijianbuService;
import com.hxg.testmjfs.util.Response;
import com.hxg.testmjfs.util.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/cjb")
public class CaijianbuController implements CaijianbuService {

    @Autowired
    private CaijianbuService caijianbuService;

    @Override
    @RequestMapping(value = "selectcjb",method = RequestMethod.GET)
    public Map<String, Object> selectByKuanhao(@RequestParam("kuanhao") String kuanhao) {
        //初始化
        Response responseContent = ResponseFactory.newInstance();
        String result = Response.RESPONSE_RESULT_ERROR;
        //获取信息
        Map<String, Object> queryResult = caijianbuService.selectByKuanhao(kuanhao);
        Object o = queryResult.get(kuanhao);
        // 设置 Response
        responseContent.setResponseResult(result);
        responseContent.setResponseData(o);
        return responseContent.generateResponse();
    }

    @Override
    @RequestMapping(value = "updatecjb",method = RequestMethod.GET)
    public boolean update(String caijianbu) {
        // 初始化 Response
        Response responseContent = ResponseFactory.newInstance();

        // 更新
        String result = caijianbuService.update(caijianbu) ? Response.RESPONSE_RESULT_SUCCESS : Response.RESPONSE_RESULT_ERROR;

        responseContent.setResponseResult(result);
        if (result.equals("success")) {
            return true;
        } else {
            return false;
        }
    }
}
