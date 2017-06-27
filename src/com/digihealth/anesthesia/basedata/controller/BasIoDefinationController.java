package com.digihealth.anesthesia.basedata.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.IoDefinationFormBean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasIoDefination;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * 
 * Title: AdminUserController.java Description: 用户Controller
 * 
 * @author liukui
 * @created 2015-9-15 下午1:56:40
 */
@Controller
@RequestMapping(value = "/basedata")
@Api(value = "BasIoDefinationController", description = "出入量信息处理类")
public class BasIoDefinationController extends BaseController
{
    
    @RequestMapping(value = "/getIoDefinationList")
    @ResponseBody
    @ApiOperation(value = "根据条件查询出入量信息", httpMethod = "POST", notes = "根据条件查询出入量信息")
    public String getIoDefinationList(
        @ApiParam(name = "baseQuery", value = "系统查询对象") @RequestBody BaseInfoQuery baseQuery)
    {
        logger.info("begin getIoDefinationList");
        ResponseValue resp = new ResponseValue();
        String type = baseQuery.getType();
        List<IoDefinationFormBean> resultList = null;
        if ("I".equals(type))
        {
            resultList = basIoDefinationService.findList(baseQuery);
        }
        else if ("O".equals(type))
        {
            resultList = basIoDefinationService.findOutList();
        }
        resp.put("resultList", resultList);
        logger.info("end getIoDefinationList");
        return resp.getJsonStr();
    }
    
    @RequestMapping(value = "/updateIoDefination")
    @ResponseBody
    @ApiOperation(value = "保存或修改出入量信息", httpMethod = "POST", notes = "保存或修改出入量信息")
    public String updateIoDefination(
        @ApiParam(name = "ioDefination", value = "出入量信息对象") @RequestBody BasIoDefination ioDefination)
    {
        ResponseValue resp = new ResponseValue();
        basIoDefinationService.updateIoDefination(ioDefination);
        return resp.getJsonStr();
    }
    
    @RequestMapping(value = "/queryIoDefinationList")
    @ResponseBody
    @ApiOperation(value = "根据条件查询出入量信息", httpMethod = "POST", notes = "根据条件查询出入量信息")
    public String queryIoDefinationList(
        @ApiParam(name = "systemSearchFormBean", value = "系统查询对象") @RequestBody SystemSearchFormBean systemSearchFormBean)
    {
        logger.info("begin queryDeptList");
        List<BasIoDefination> resultList = basIoDefinationService.queryIoDefinationList(systemSearchFormBean);
        int total = basIoDefinationService.queryIoDefinationListTotal(systemSearchFormBean);
        ResponseValue resp = new ResponseValue();
        resp.put("resultList", resultList);
        resp.put("total", total);
        logger.info("end queryDeptList");
        return resp.getJsonStr();
    }
    
    @RequestMapping(value = "/queryIoDefinationById")
    @ResponseBody
    @ApiOperation(value = "根据主键查询出入量信息", httpMethod = "POST", notes = "根据主键查询出入量信息")
    public String queryIoDefinationById(
        @ApiParam(name = "ioDefination", value = "出入量信息对象") @RequestBody BasIoDefination ioDefination)
    {
        logger.info("begin queryIoDefinationById");
        ResponseValue resp = new ResponseValue();
        BasIoDefination resultIoDefination = basIoDefinationService.selectByPrimarykey(ioDefination.getIoDefId());
        resp.put("ioDefination", resultIoDefination);
        logger.info("end queryIoDefinationById");
        return resp.getJsonStr();
    }
    
}
