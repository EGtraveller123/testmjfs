package com.hxg.testmjfs.controller;

import com.hxg.testmjfs.service.HoudaobuService;
import com.hxg.testmjfs.util.Response;
import com.hxg.testmjfs.util.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/hdb")
public class HoudaobuController implements HoudaobuService {

    @Autowired
    private HoudaobuService houdaobuService;

    @Override
    @RequestMapping(value = "selecthdb",method = RequestMethod.GET)
    public Map<String, Object> selectByKuanhao(@RequestParam("kuanhao") String kuanhao) {
        //初始化
        Response responseContent = ResponseFactory.newInstance();
        String result = Response.RESPONSE_RESULT_ERROR;
        //获取信息
        Map<String, Object> queryResult = houdaobuService.selectByKuanhao(kuanhao);
        Object o = queryResult.get(kuanhao);
        // 设置 Response
        responseContent.setResponseResult(result);
        responseContent.setResponseData(o);
        return responseContent.generateResponse();
    }

    @Override
    @RequestMapping(value = "updatehdb",method = RequestMethod.GET)
    public boolean update(String houdaobu) {
        // 初始化 Response
        Response responseContent = ResponseFactory.newInstance();

        // 更新
        String result = houdaobuService.update(houdaobu) ? Response.RESPONSE_RESULT_SUCCESS : Response.RESPONSE_RESULT_ERROR;

        responseContent.setResponseResult(result);
        if (result.equals("success")) {
            return true;
        } else {
            return false;
        }
    }
}
