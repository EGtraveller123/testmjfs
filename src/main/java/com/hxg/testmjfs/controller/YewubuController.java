package com.hxg.testmjfs.controller;

import com.hxg.testmjfs.bean.Yewubu;
import com.hxg.testmjfs.service.YewubuService;
import com.hxg.testmjfs.util.Response;
import com.hxg.testmjfs.util.ResponseFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class YewubuController {

    @Autowired
    private YewubuService yewubuService;


    private static final String SELECT_BY_KUANHAO = "selectByKuanhao";
    private static final String SELECT_BY_KEHU = "searchByKehu";
    private static final String SELECT_ALL = "selectAll";

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

        switch (searchType) {
            case SELECT_BY_KUANHAO:
                if (StringUtils.isNumeric(keyWord))
                    queryResult = yewubuService.selectByKuanhao(keyWord);
                break;
            case SELECT_BY_KEHU:
                queryResult = yewubuService.selectByKehu(offset, limit, keyWord);
                break;
            case SELECT_ALL:
                queryResult = yewubuService.selectAll(offset, limit);
                break;
            default:
                // do other thing
                break;
        }
        return queryResult;
    }
    /**
     * 搜索客户信息
     *
     * @param searchType 搜索类型
     * @param offset     如有多条记录时分页的偏移值
     * @param limit      如有多条记录时分页的大小
     * @param keyWord    搜索的关键字
     * @return 返回查询的结果，其中键值为 rows 的代表查询到的每一记录，若有分页则为分页大小的记录；键值为 total 代表查询到的符合要求的记录总条数
     */

    @RequestMapping(value = "getYewubuList", method = RequestMethod.GET)
    public
    @ResponseBody
    Map<String, Object> getCustomerList(@RequestParam("searchType") String searchType,
                                        @RequestParam("offset") int offset,
                                        @RequestParam("limit") int limit,
                                        @RequestParam("keyWord") String keyWord){
        // 初始化 Response
        Response responseContent = ResponseFactory.newInstance();

        List<Yewubu> rows = null;
        long total = 0;

        Map<String, Object> queryResult = query(searchType, keyWord, offset, limit);

        if (queryResult != null) {
            rows = (List<Yewubu>) queryResult.get("data");
            total = (long) queryResult.get("total");
        }

        // 设置 Response
        responseContent.setCustomerInfo("rows", rows);
        responseContent.setResponseTotal(total);
        responseContent.setResponseResult(Response.RESPONSE_RESULT_SUCCESS);
        return responseContent.generateResponse();
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
    Map<String, Object> getYwbKuanhao(@RequestParam("kuanhao") String kuanhao){
        // 初始化 Response
        Response responseContent = ResponseFactory.newInstance();
        String result = Response.RESPONSE_RESULT_ERROR;

        //获取业务部信息
        Yewubu yewubu=null;
        Map<String, Object> queryResult = query(SELECT_BY_KUANHAO, kuanhao, -1, -1);
        if (queryResult != null) {
            yewubu = (Yewubu) queryResult.get("data");
            if (yewubu != null) {
                result = Response.RESPONSE_RESULT_SUCCESS;
            }
        }
        // 设置 Response
        responseContent.setResponseResult(result);
        responseContent.setResponseData(yewubu);

        return responseContent.generateResponse();
    }

    /**
     * 查询指定kehu的信息
     *
     * @param kehu 客户
     * @return 返回一个map，其中：key 为 result 的值为操作的结果，包括：success 与 error；key 为 data
     * 的值为客户信息
     */
    @RequestMapping(value = "kehu",method = RequestMethod.GET)
    public
    @ResponseBody
    Map<String, Object> getYwbKehu(@RequestParam("kehu") String kehu){
        // 初始化 Response
        Response responseContent = ResponseFactory.newInstance();
        String result = Response.RESPONSE_RESULT_ERROR;

        //获取业务部信息
        Yewubu yewubu=null;
        Map<String, Object> queryResult = query(SELECT_BY_KEHU, kehu, -1, -1);
        if (queryResult != null) {
            yewubu = (Yewubu) queryResult.get("data");
            if (yewubu != null) {
                result = Response.RESPONSE_RESULT_SUCCESS;
            }
        }
        // 设置 Response
        responseContent.setResponseResult(result);
        responseContent.setResponseData(yewubu);

        return responseContent.generateResponse();
    }

    /**
     * 添加一条业务部信息
     *
     * @param yewubu 客户信息
     * @return 返回一个map，其中：key 为 result表示操作的结果，包括：success 与 error
     */
    @RequestMapping(value = "addYewubu", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, Object> addCustomer(@RequestBody Yewubu yewubu){
        // 初始化 Response
        Response responseContent = ResponseFactory.newInstance();

        // 添加记录
        String result = yewubuService.insert(yewubu) ? Response.RESPONSE_RESULT_SUCCESS : Response.RESPONSE_RESULT_ERROR;

        responseContent.setResponseResult(result);
        return responseContent.generateResponse();
    }

    /**
     * 更新业务部信息
     *
     * @param yewubu 客户信息
     * @return 返回一个map，其中：key 为 result表示操作的结果，包括：success 与 error
     */
    @RequestMapping(value = "updateYewubu", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String,Object> updateYewubu(@RequestBody Yewubu yewubu){
        // 初始化 Response
        Response responseContent = ResponseFactory.newInstance();

        // 更新
        String result = yewubuService.update(yewubu)? Response.RESPONSE_RESULT_SUCCESS : Response.RESPONSE_RESULT_ERROR;

        responseContent.setResponseResult(result);
        return responseContent.generateResponse();
    }
    /**
     * 删除业务部信息
     *
     * @param yewubuKuanhao 客户信息
     * @return 返回一个map，其中：key 为 result表示操作的结果，包括：success 与 error
     */
    @RequestMapping(value = "deleteYewubu", method = RequestMethod.GET)
    public
    @ResponseBody
    Map<String, Object> deleteYewubu(@RequestParam("Yewubukuanhao") String yewubuKuanhao){
        // 初始化 Response
        Response responseContent = ResponseFactory.newInstance();
        // 参数检查
        if (StringUtils.isNumeric(yewubuKuanhao)) {
            // 转换为 Integer
            Integer customerID = Integer.valueOf(yewubuKuanhao);

            // 刪除
            String result = yewubuService.delete(yewubuKuanhao) ? Response.RESPONSE_RESULT_SUCCESS : Response.RESPONSE_RESULT_ERROR;
            responseContent.setResponseResult(result);
        } else
            responseContent.setResponseResult(Response.RESPONSE_RESULT_ERROR);

        return responseContent.generateResponse();
    }

}
