package com.digihealth.anesthesia.basedata.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.po.BasDeviceSpecification;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

/**
 * 
 * Title: AnaesMonitorConfigController.java Description:监测点设置Controller
 * 
 * @author liukui
 * @created 2015-9-15 下午1:56:40
 */
@Controller
@RequestMapping(value = "/basedata")
@Api(value = "BasDeviceSpecificationController", description = "设备规格处理类")
public class BasDeviceSpecificationController extends BaseController
{
    
    @RequestMapping(value = "/getDeviceSpecificationList")
    @ResponseBody
    @ApiOperation(value = "查询设备规格", httpMethod = "POST", notes = "查询设备规格")
    public String getDeviceSpecificationList()
    {
        logger.info("begin getDeviceSpecificationList");
        ResponseValue resp = new ResponseValue();
        List<BasDeviceSpecification> resultList = basDeviceSpecificationService.getDeviceSpecificationList();
        resp.put("resultList", resultList);
        logger.info("end getDeviceSpecificationList");
        return resp.getJsonStr();
    }
    
}
