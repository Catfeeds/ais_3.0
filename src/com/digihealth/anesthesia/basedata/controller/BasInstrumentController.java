package com.digihealth.anesthesia.basedata.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasInstrument;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * 
 * Title: InstrumentController.java Description: 器械Controller
 * 
 * @author chengwang
 * @created 2015-9-15 下午1:56:40
 */
@Controller
@RequestMapping(value = "/basedata")
@Api(value = "BasInstrumentController", description = "器械处理类")
public class BasInstrumentController extends BaseController
{
    
    @RequestMapping(value = "/searchInstrument")
    @ResponseBody
    @ApiOperation(value = "查询器械信息", httpMethod = "POST", notes = "查询器械信息")
    public String searchInstrument(@ApiParam(name = "baseQuery", value = "系统查询对象") @RequestBody BaseInfoQuery baseQuery)
    {
        logger.info("begin getAnaesMethodList");
        ResponseValue resp = new ResponseValue();
        List<BasInstrument> resultList = basInstrumentService.searchInstrument(baseQuery);
        resp.put("resultList", resultList);
        logger.info("end getAnaesMethodList");
        return resp.getJsonStr();
    }
    
    /**
     * 
     * @discription 根据条件查询器械
     * @author chengwang
     * @created 2015年12月3日 下午3:01:40
     * @param systemSearchFormBean
     * @return
     */
    @RequestMapping(value = "/queryInstrumentList")
    @ResponseBody
    @ApiOperation(value = "根据条件查询器械信息", httpMethod = "POST", notes = "根据条件查询器械信息")
    public String queryInstrumentList(
        @ApiParam(name = "systemSearchFormBean", value = "系统查询对象") @RequestBody SystemSearchFormBean systemSearchFormBean)
    {
        logger.info("begin queryInstrumentList");
        ResponseValue resp = new ResponseValue();
        List<BasInstrument> resultList = basInstrumentService.queryInstrumentList(systemSearchFormBean);
        int total = basInstrumentService.queryInstrumentListTotal(systemSearchFormBean);
        resp.put("resultList", resultList);
        resp.put("total", total);
        logger.info("end queryInstrumentList");
        return resp.getJsonStr();
    }
    
    /**
     * 
     * @discription 查询单个器械信息
     * @author chengwang
     * @created 2015年12月3日 下午3:01:54
     * @param dept
     * @return
     */
    @RequestMapping(value = "/queryInstrumentById")
    @ResponseBody
    @ApiOperation(value = "查询单个器械信息", httpMethod = "POST", notes = "查询单个器械信息")
    public String queryInstrumentById(
        @ApiParam(name = "instrument", value = "器械对象") @RequestBody BasInstrument instrument)
    {
        logger.info("begin queryInstrumentById");
        ResponseValue resp = new ResponseValue();
        BasInstrument resultInstrument = basInstrumentService.searchInstrumentById(instrument.getInstrumentId());
        resp.put("instrument", resultInstrument);
        logger.info("end queryInstrumentById");
        return resp.getJsonStr();
    }
    
    /**
     * 
     * @discription 修改或者添加器械
     * @author chengwang
     * @created 2015年12月3日 下午3:02:15
     * @param dept
     * @return
     */
    @RequestMapping(value = "/updateInstrument")
    @ResponseBody
    @ApiOperation(value = "根据条件查询库存信息", httpMethod = "POST", notes = "根据条件查询库存信息")
    public String updateInstrument(@ApiParam(name = "instrument", value = "器械对象") @RequestBody BasInstrument instrument)
    {
        logger.info("begin updateInstrument");
        ResponseValue resp = new ResponseValue();
        basInstrumentService.updateInstrument(instrument);
        logger.info("end updateInstrument");
        return resp.getJsonStr();
    }
    
}
