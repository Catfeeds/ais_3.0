package com.digihealth.anesthesia.basedata.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.InstrsuitFromBean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasInstrsuit;
import com.digihealth.anesthesia.basedata.po.BasInstrument;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * 
 * Title: InstrsuitController.java Description: 手术包Controller
 * 
 * @author chengwang
 * @created 2015-9-15 下午1:56:40
 */
@Controller
@RequestMapping(value = "/basedata")
@Api(value = "BasInstrsuitController", description = "手术包处理类")
public class BasInstrsuitController extends BaseController
{
    
    @RequestMapping(value = "/getInstrsuitList")
    @ResponseBody
    @ApiOperation(value = "查询手术包信息", httpMethod = "POST", notes = "查询手术包信息")
    public String getInstrsuitList(@ApiParam(name = "baseQuery", value = "系统查询对象") @RequestBody BaseInfoQuery baseQuery)
    {
        logger.info("begin getInstrsuitList");
        ResponseValue resp = new ResponseValue();
        List<BasInstrsuit> instrsuitList = basInstrsuitService.findList(baseQuery);
        resp.put("resultList", instrsuitList);
        logger.info("end getInstrsuitList");
        return resp.getJsonStr();
    }
    
    /**
     * 
     * @discription 根据条件查询手术包
     * @author chengwang
     * @created 2015年12月3日 下午3:01:40
     * @param systemSearchFormBean
     * @return
     */
    @RequestMapping(value = "/queryInstrsuitList")
    @ResponseBody
    @ApiOperation(value = "根据条件查询手术包", httpMethod = "POST", notes = "根据条件查询手术包")
    public String queryInstrsuitList(
        @ApiParam(name = "systemSearchFormBean", value = "系统查询对象") @RequestBody SystemSearchFormBean systemSearchFormBean)
    {
        logger.info("begin queryInstrsuitList");
        ResponseValue resp = new ResponseValue();
        List<BasInstrsuit> resultList = basInstrsuitService.queryInstrsuitList(systemSearchFormBean);
        int total = basInstrsuitService.queryInstrsuitListTotal(systemSearchFormBean);
        resp.put("resultList", resultList);
        resp.put("total", total);
        logger.info("end queryInstrsuitList");
        return resp.getJsonStr();
    }
    
    /**
     * 
     * @discription 查询单个手术包信息
     * @author chengwang
     * @created 2015年12月3日 下午3:01:54
     * @param dept
     * @return
     */
    @RequestMapping(value = "/queryInstrsuitById")
    @ResponseBody
    @ApiOperation(value = "查询单个手术包信息", httpMethod = "POST", notes = "查询单个手术包信息")
    public String queryInstrumentById(
        @ApiParam(name = "instrsuit", value = "手术包对象") @RequestBody BasInstrsuit instrsuit)
    {
        logger.info("begin queryInstrsuitById");
        ResponseValue resp = new ResponseValue();
        BasInstrsuit resultInstrsuit = basInstrsuitService.searchInstrsuitById(instrsuit.getInstrsuitId());
        List<BasInstrument> instrumentList = new ArrayList<BasInstrument>();
        if (resultInstrsuit != null)
        {
            instrumentList = basInstrumentService.queryInstrumentByInstrsuitId(resultInstrsuit.getInstrsuitId());
        }
        resp.put("instrsuit", resultInstrsuit);
        resp.put("resultList", instrumentList);
        logger.info("end queryInstrsuitById");
        return resp.getJsonStr();
    }
    
    /**
     * 
     * @discription ss's
     * @author chengwang
     * @created 2015年12月4日 下午4:56:45
     * @param instrsuitFromBean
     * @return
     */
    @RequestMapping(value = "/updateInstrsuit")
    @ResponseBody
    @ApiOperation(value = "保存或添加手术包信息", httpMethod = "POST", notes = "保存或添加手术包信息")
    public String updateInstrsuit(
        @ApiParam(name = "instrsuitFromBean", value = "手术包查询对象") @RequestBody InstrsuitFromBean instrsuitFromBean)
    {
        logger.info("begin updateInstrsuit");
        ResponseValue resp = new ResponseValue();
        basInstrsuitService.updateInstrsuit(instrsuitFromBean);
        logger.info("end updateInstrsuit");
        return resp.getJsonStr();
    }
}
