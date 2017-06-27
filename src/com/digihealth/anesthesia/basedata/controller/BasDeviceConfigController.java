package com.digihealth.anesthesia.basedata.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.BasDeviceConfigOperateFormBean;
import com.digihealth.anesthesia.basedata.formbean.BasDeviceMonitorConfigFormBean;
import com.digihealth.anesthesia.basedata.po.BasDeviceConfig;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * 
 * Title: AnaesMonitorConfigController.java Description:监测点设置Controller
 * 
 * @author liukui
 * @created 2015-9-15 下午1:56:40
 */
@Controller
@RequestMapping(value = "/basedata")
@Api(value = "BasDeviceConfigController", description = "床旁设备配置处理类")
public class BasDeviceConfigController extends BaseController
{
    @RequestMapping(value = "/getDeviceConfigList")
    @ResponseBody
    @ApiOperation(value = "查询床旁设备配置", httpMethod = "POST", notes = "查询床旁设备配置")
    public String getDeviceConfigList()
    {
        logger.info("begin getDeviceConfigList");
        ResponseValue resp = new ResponseValue();
        List<BasDeviceConfig> resultList = basDeviceConfigService.getDeviceConfigList();
        resp.put("resultList", resultList);
        logger.info("end getDeviceConfigList");
        return resp.getJsonStr();
    }
    
    @RequestMapping(value = "/getDeviceMonitorConfigList")
    @ResponseBody
    @ApiOperation(value = "根据设备id查询床旁设备配置", httpMethod = "POST", notes = "根据设备id查询床旁设备配置")
    public String getDeviceMonitorConfigList(@ApiParam(name = "deviceConfig", value = "床旁设备对象") @RequestBody BasDeviceConfig deviceConfig)
    {
        logger.info("begin getDeviceConfigList");
        ResponseValue resp = new ResponseValue();
        List<BasDeviceMonitorConfigFormBean> resultList =
            basDeviceMonitorConfigService.getDeviceMonitorConfigList(deviceConfig.getDeviceId().toString(), null);
        resp.put("resultList", resultList);
        logger.info("end getDeviceMonitorConfigList");
        return resp.getJsonStr();
    }
    
    /**
     * 设备监测项数据配置成功
     * 
     * @param BasDeviceConfigOperateFormBean
     * @return
     */
    @RequestMapping(value = "/saveDeviceConfig")
    @ResponseBody
    @ApiOperation(value = "保存设备监测项数据配置", httpMethod = "POST", notes = "保存设备监测项数据配置")
    public String saveDeviceConfig(@ApiParam(name = "deviceConfigOperateFormBean", value = "床旁设备配置对象") @RequestBody BasDeviceConfigOperateFormBean deviceConfigOperateFormBean)
    {
        logger.info("begin saveDeviceConfig");
        ResponseValue resp = new ResponseValue();
        basDeviceConfigService.saveDeviceConfig(deviceConfigOperateFormBean);
        logger.info("end saveDeviceConfig");
        return resp.getJsonStr();
    }
    
    /**
     * 查询可用的串口
     * 
     * @param deviceConfig
     * @return
     */
    @RequestMapping(value = "/getUseSerialPortList")
    @ResponseBody
    @ApiOperation(value = "查询可用的串口", httpMethod = "POST", notes = "查询可用的串口")
    public String getUseSerialPortList()
    {
        logger.info("begin getUseSerialPortList");
        ResponseValue resp = new ResponseValue();
        basDeviceConfigService.listPortChoices();
        List<String> resultList = basDeviceConfigService.getUseSerialPortList();
        resp.put("resultList", resultList);
        logger.info("end getUseSerialPortList");
        return resp.getJsonStr();
    }
    
}
