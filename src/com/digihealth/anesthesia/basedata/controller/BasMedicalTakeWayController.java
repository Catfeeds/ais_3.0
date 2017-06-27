package com.digihealth.anesthesia.basedata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasMedicalTakeWay;
import com.digihealth.anesthesia.basedata.service.BasMedicalTakeWayService;
import com.digihealth.anesthesia.common.beanvalidator.ValidatorBean;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * 
 * Title: OperdefController.java Description: 给药途径Controller
 * 
 * @author liukui
 * @created 2015-9-15 下午1:56:40
 */
@Controller
@RequestMapping(value = "/basedata")
@Api(value = "BasMedicalTakeWayController", description = "药品信息处理类")
public class BasMedicalTakeWayController extends BaseController
{
    
    @Autowired
    private BasMedicalTakeWayService basMedicalTakeWayService;
    
    @RequestMapping(value = "/getMedicalTakeWayList")
    @ResponseBody
    @ApiOperation(value = "查询给药途径列表", httpMethod = "POST", notes = "查询给药途径列表")
    public String getMedicalTakeWayList(
        @ApiParam(name = "baseQuery", value = "系统查询对象") @RequestBody BaseInfoQuery baseQuery)
    {
        logger.info("begin getMedicalTakeWayList");
        ResponseValue resp = new ResponseValue();
        List<BasMedicalTakeWay> resultList = basMedicalTakeWayService.findList(baseQuery);
        resp.put("resultList", resultList);
        logger.info("end getMedicalTakeWayList");
        return resp.getJsonStr();
    }
    
    /**
     * 
     * @discription 根据条件查询用药途径
     * @author liukui
     * @created 2015年12月3日 下午3:01:40
     * @param systemSearchFormBean
     * @return
     */
    @RequestMapping(value = "/queryMedicalTakeWayList")
    @ResponseBody
    @ApiOperation(value = "根据条件查询用药途径", httpMethod = "POST", notes = "根据条件查询用药途径")
    public String queryMedicalTakeWayList(
        @ApiParam(name = "systemSearchFormBean", value = "系统查询对象") @RequestBody SystemSearchFormBean systemSearchFormBean)
    {
        logger.info("begin queryMedicalTakeWayList");
        ResponseValue resp = new ResponseValue();
        List<BasMedicalTakeWay> resultList = basMedicalTakeWayService.queryMedicalTakeWayList(systemSearchFormBean);
        int total = basMedicalTakeWayService.queryMedicalTakeWayListTotal(systemSearchFormBean);
        resp.put("resultList", resultList);
        resp.put("total", total);
        logger.info("end queryMedicalTakeWayList");
        return resp.getJsonStr();
    }
    
    /**
     * 
     * @discription 查询单个用药途径
     * @author liukui
     * @created 2015年12月3日 下午3:01:54
     * @param dept
     * @return
     */
    @RequestMapping(value = "/queryMedicalTakeWayById")
    @ResponseBody
    @ApiOperation(value = "查询单个用药途径", httpMethod = "POST", notes = "查询单个用药途径")
    public String queryMedicalTakeWayById(
        @ApiParam(name = "medicalTakeWay", value = "用药途径对象") @RequestBody BasMedicalTakeWay medicalTakeWay)
    {
        logger.info("begin queryMedicalTakeWayById");
        ResponseValue resp = new ResponseValue();
        BasMedicalTakeWay resultObj =
            basMedicalTakeWayService.queryMedicalTakeWayById(medicalTakeWay.getMedTakeWayId());
        resp.put("medicalTakeWay", resultObj);
        logger.info("end queryMedicalTakeWayById");
        return resp.getJsonStr();
    }
    
    /**
     * 
     * @discription 修改或者添加用药途径
     * @author liukui
     * @created 2015年12月3日 下午3:02:15
     * @param Operdef
     * @return
     */
    @RequestMapping(value = "/saveMedicalTakeWay")
    @ResponseBody
    @ApiOperation(value = "修改或者添加用药途径", httpMethod = "POST", notes = "修改或者添加用药途径")
    public String saveMedicalTakeWay(
        @ApiParam(name = "medicalTakeWay", value = "用药途径对象") @RequestBody BasMedicalTakeWay medicalTakeWay)
    {
        logger.info("begin saveMedicalTakeWay");
        ResponseValue resp = new ResponseValue();
        ValidatorBean validatorBean = beanValidator(medicalTakeWay);
        if (!(validatorBean.isValidator()))
        {
            resp.put("resultCode", "10000001");
            resp.put("resultMessage", validatorBean.getMessage());
            return resp.getJsonStr();
        }
        basMedicalTakeWayService.saveMedicalTakeWay(medicalTakeWay);
        logger.info("end saveMedicalTakeWay");
        return resp.getJsonStr();
    }
    
    /**
     * 
     * @discription 删除用药途径
     * @author liukui
     * @created 2015年12月3日 下午3:02:15
     * @param Operdef
     * @return
     */
    @RequestMapping(value = "/deleteMedicalTakeWay")
    @ResponseBody
    @ApiOperation(value = "删除用药途径", httpMethod = "POST", notes = "删除用药途径")
    public String deleteMedicalTakeWay(
        @ApiParam(name = "medTakeWayIdList", value = "用药途径对象") @RequestBody List<String> medTakeWayIdList)
    {
        logger.info("begin deleteMedicalTakeWay");
        ResponseValue resp = new ResponseValue();
        basMedicalTakeWayService.deleteMedicalTakeWay(medTakeWayIdList);
        logger.info("end deleteMedicalTakeWay");
        return resp.getJsonStr();
    }
    
}
