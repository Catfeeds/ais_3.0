package com.digihealth.anesthesia.basedata.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.CommonRetreatRecordFormBean;
import com.digihealth.anesthesia.basedata.formbean.OperationRetreatRecordFormBean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/basedata") 
@Api(value = "BasAnaesMedicineRetreatRecordController", description = "毒麻药退药处理类")
public class BasAnaesMedicineRetreatRecordController extends BaseController
{
	/**
     * 
     * @discription 查询毒麻药普通退药记录
     * @author pengqing
     * @created 2017年6月13日 下午3:01:40
     * @param systemSearchFormBean
     * @return
     */
    @RequestMapping(value = "/queryCommonRetreatRecordList")
    @ResponseBody
    @ApiOperation(value = "查询毒麻药普通退药记录", httpMethod = "POST", notes = "查询毒麻药普通退药记录")
    public String queryCommonRetreatRecordList(
        @ApiParam(name = "systemSearchFormBean", value = "系统查询参数") @RequestBody SystemSearchFormBean systemSearchFormBean)
    {
        logger.info("begin queryCommonRetreatRecordList");
        ResponseValue resp = new ResponseValue();
        List<CommonRetreatRecordFormBean> resultList = basAnaesMedicineRetreatRecordService.queryCommonRetreatRecordList(systemSearchFormBean);
        int total = basAnaesMedicineRetreatRecordService.queryCommonRetreatRecordListTotal(systemSearchFormBean);
        resp.put("resultList", resultList);
        resp.put("total", total);
        logger.info("end queryCommonRetreatRecordList");
        return resp.getJsonStr();
    }
    
	/**
     * 
     * @discription 查询毒麻药手术退药记录
     * @author pengqing
     * @created 2017年6月13日 下午3:01:40
     * @param systemSearchFormBean
     * @return
     */
    @RequestMapping(value = "/queryOperationRetreatRecordList")
    @ResponseBody
    @ApiOperation(value = "查询毒麻药手术退药记录", httpMethod = "POST", notes = "查询毒麻药手术退药记录")
    public String queryOperationRetreatRecordList(
        @ApiParam(name = "systemSearchFormBean", value = "系统查询参数") @RequestBody SystemSearchFormBean systemSearchFormBean)
    {
        logger.info("begin queryOperationRetreatRecordList");
        ResponseValue resp = new ResponseValue();
        List<OperationRetreatRecordFormBean> resultList = basAnaesMedicineRetreatRecordService.queryOperationRetreatRecordList(systemSearchFormBean);
        int total = basAnaesMedicineRetreatRecordService.queryOperationRetreatRecordListTotal(systemSearchFormBean);
        resp.put("resultList", resultList);
        resp.put("total", total);
        logger.info("end queryOperationRetreatRecordList");
        return resp.getJsonStr();
    }
}
