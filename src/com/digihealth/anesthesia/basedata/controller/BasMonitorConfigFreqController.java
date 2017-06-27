package com.digihealth.anesthesia.basedata.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasMonitorConfigFreq;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * 
 * Title: MonitorConfigFreqController.java Description: 采集频率设置表Controller
 * 
 * @author liukui
 * @created 2015-9-15 下午1:56:40
 */
@Controller
@RequestMapping(value = "/basedata")
@Api(value = "BasMonitorConfigFreqController", description = "采集频率设置处理类")
public class BasMonitorConfigFreqController extends BaseController
{
    
    /**
     * 
     * @discription 根据条件查询采集频率设置
     * @author liukui
     * @created 2015年12月3日 下午3:01:40
     * @param systemSearchFormBean
     * @return
     */
    @RequestMapping(value = "/queryMonitorConfigFreqList")
    @ResponseBody
    @ApiOperation(value = "根据条件查询采集频率设置", httpMethod = "POST", notes = "根据条件查询采集频率设置")
    public String queryMonitorConfigFreqList(@ApiParam(name = "systemSearchFormBean", value = "系统查询对象") @RequestBody SystemSearchFormBean systemSearchFormBean)
    {
        logger.info("begin queryMonitorConfigFreqList");
        ResponseValue resp = new ResponseValue();
        List<BasMonitorConfigFreq> resultList =
            basMonitorConfigFreqService.queryMonitorConfigFreqList(systemSearchFormBean);
        resp.put("resultList", resultList);
        logger.info("end queryMonitorConfigFreqList");
        return resp.getJsonStr();
    }
    
    /**
     * 
     * @discription 查询采集频率
     * @author liukui
     * @created 2015年12月3日 下午3:01:54
     * @param monitorConfigFreq
     * @return
     */
    @RequestMapping(value = "/queryMonitorConfigFreqById")
    @ResponseBody
    @ApiOperation(value = "查询采集频率", httpMethod = "POST", notes = "查询采集频率")
    public String queryMonitorConfigFreqById(@ApiParam(name = "monitorConfigFreq", value = "采集频率对象") @RequestBody BasMonitorConfigFreq monitorConfigFreq)
    {
        logger.info("begin queryMonitorConfigFreqById");
        ResponseValue resp = new ResponseValue();
        BasMonitorConfigFreq resultObj =
            basMonitorConfigFreqService.queryMonitorConfigFreqById(monitorConfigFreq.getId());
        resp.put("monitorConfigFreq", resultObj);
        logger.info("end queryMonitorConfigFreqById");
        return resp.getJsonStr();
    }
    
    /**
     * 
     * @discription 修改或者添加科室
     * @author liukui
     * @created 2015年12月3日 下午3:02:15
     * @param BasMonitorConfigFreq
     * @return
     */
    @RequestMapping(value = "/saveMonitorConfigFreq")
    @ResponseBody
    @ApiOperation(value = "修改或者添加采集频率", httpMethod = "POST", notes = "修改或者添加采集频率")
    public String saveMonitorConfigFreq(@ApiParam(name = "monitorConfigFreq", value = "采集频率对象") @RequestBody BasMonitorConfigFreq monitorConfigFreq)
    {
        logger.info("begin saveMonitorConfigFreq");
        ResponseValue resp = new ResponseValue();
        basMonitorConfigFreqService.updateMonitorConfigFreq(monitorConfigFreq);
        logger.info("end saveMonitorConfigFreq");
        return resp.getJsonStr();
    }
    
}
