package com.digihealth.anesthesia.basedata.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.AnaesMethodFormBean;
import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasAnaesMethod;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * 
 * Title: AnaesMethodController.java Description: 麻醉方法Controller
 * 
 * @author chengwang
 * @created 2015-9-15 下午1:56:40
 */
@Controller
@RequestMapping(value = "/basedata")
@Api(value = "BasAnaesMethodController", description = "麻醉方法处理类")
public class BasAnaesMethodController extends BaseController
{
    
    @RequestMapping(value = "/getAnaesMethodList")
    @ResponseBody
    @ApiOperation(value = "手术申请>查询麻醉方法列表", httpMethod = "POST", notes = "查询麻醉方法列表")
    public String getAnaesMethodList(
        @ApiParam(name = "baseQuery", value = "系统查询参数") @RequestBody BaseInfoQuery baseQuery)
    {
        logger.info("begin getAnaesMethodList");
        ResponseValue resp = new ResponseValue();
        if(null == baseQuery)
        {
        	baseQuery = new BaseInfoQuery();
        }
        List<AnaesMethodFormBean> resultList = basAnaesMethodService.findList(baseQuery);
        resp.put("resultList", resultList);
        logger.info("end getAnaesMethodList");
        return resp.getJsonStr();
    }
    
    /**
     * 插入麻醉方法
     * 
     * @param anaesMethod
     * @return
     */
    @RequestMapping(value = "/insertAnaesMethod")
    @ResponseBody
    @ApiOperation(value = "保存麻醉方法", httpMethod = "POST", notes = "保存麻醉方法")
    public String insertAnaesMethod(
        @ApiParam(name = "anaesMethod", value = "麻醉方法对象") @RequestBody BasAnaesMethod anaesMethod)
    {
        logger.info("begin insertAnaesMethod");
        ResponseValue resp = new ResponseValue();
        basAnaesMethodService.insertAnaesMethod(anaesMethod);
        resp.put("status", true);
        logger.info("end insertAnaesMethod");
        return resp.getJsonStr();
    }
    
    /**
     * 
     * @discription 根据条件查询麻醉方法
     * @author chengwang
     * @created 2015年12月3日 下午3:01:40
     * @param systemSearchFormBean
     * @return
     */
    @RequestMapping(value = "/queryAnaesMethodList")
    @ResponseBody
    @ApiOperation(value = "根据条件查询麻醉方法", httpMethod = "POST", notes = "根据条件查询麻醉方法")
    public String queryAnaesMethodList(
        @ApiParam(name = "systemSearchFormBean", value = "系统查询参数") @RequestBody SystemSearchFormBean systemSearchFormBean)
    {
        logger.info("begin queryDeptList");
        ResponseValue resp = new ResponseValue();
        List<BasAnaesMethod> resultList = basAnaesMethodService.queryAnaesMethodList(systemSearchFormBean);
        int total = basAnaesMethodService.queryAnaesMethodListTotal(systemSearchFormBean);
        resp.put("resultList", resultList);
        resp.put("total", total);
        logger.info("end queryDeptList");
        return resp.getJsonStr();
    }
    
    /**
     * 
     * @discription 查询单个麻醉方法信息
     * @author chengwang
     * @created 2015年12月3日 下午3:01:54
     * @param dept
     * @return
     */
    @RequestMapping(value = "/queryAnaesMethodById")
    @ResponseBody
    @ApiOperation(value = "根据主键查询麻醉方法", httpMethod = "POST", notes = "根据主键查询麻醉方法")
    public String queryAnaesMethodById(
        @ApiParam(name = "anaesMethod", value = "麻醉方法对象") @RequestBody BasAnaesMethod anaesMethod)
    {
        logger.info("begin queryAnaesMethodById");
        ResponseValue resp = new ResponseValue();
        BasAnaesMethod resultAnaesMethod = basAnaesMethodService.searchAnaesMethodById(anaesMethod.getAnaMedId());
        resp.put("anaesMethod", resultAnaesMethod);
        logger.info("end queryAnaesMethodById");
        return resp.getJsonStr();
    }
    
    /**
     * 
     * @discription 修改或者添加麻醉方法
     * @author chengwang
     * @created 2015年12月3日 下午3:02:15
     * @param dept
     * @return
     */
    
    @RequestMapping(value = "/updateAnaesMethod")
    @ResponseBody
    @ApiOperation(value = "修改或者添加麻醉方法", httpMethod = "POST", notes = "修改或者添加麻醉方法")
    public String updateAnaesMethod(
        @ApiParam(name = "anaesMethod", value = "麻醉方法对象") @RequestBody BasAnaesMethod anaesMethod)
    {
        logger.info("begin updateAnaesMethod");
        ResponseValue resp = new ResponseValue();
        basAnaesMethodService.updateAnaesMethod(anaesMethod);
        logger.info("end updateAnaesMethod");
        return resp.getJsonStr();
    }
    
}
