package com.digihealth.anesthesia.basedata.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasMedicalTakeReason;
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
@Api(value = "BasMedicalTakeReasonController", description = "药品信息处理类")
public class BasMedicalTakeReasonController extends BaseController
{
    
    /**
     * 
     * @discription 根据条件查询用药途径
     * @author liukui
     * @created 2015年12月3日 下午3:01:40
     * @param systemSearchFormBean
     * @return
     */
    @RequestMapping(value = "/queryMedicalTakeReasonList")
    @ResponseBody
    @ApiOperation(value = "根据条件查询用药途径", httpMethod = "POST", notes = "根据条件查询用药途径")
    public String queryMedicalTakeReasonList(@ApiParam(name = "systemSearchFormBean", value = "系统查询对象") @RequestBody SystemSearchFormBean systemSearchFormBean)
    {
        logger.info("begin queryMedicalTakeReasonList");
        ResponseValue resp = new ResponseValue();
        List<BasMedicalTakeReason> resultList =
            basMedicalTakeReasonService.queryMedicalTakeReasonList(systemSearchFormBean);
        int total = basMedicalTakeReasonService.queryMedicalTakeReasonListTotal(systemSearchFormBean);
        resp.put("resultList", resultList);
        resp.put("total", total);
        logger.info("end queryMedicalTakeReasonList");
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
    @RequestMapping(value = "/queryMedicalTakeReasonById")
    @ResponseBody
    @ApiOperation(value = "查询单个用药原因", httpMethod = "POST", notes = "查询单个用药原因")
    public String queryMedicalTakeReasonById(@ApiParam(name = "medicalTakeReason", value = "用药原因对象") @RequestBody BasMedicalTakeReason medicalTakeReason)
    {
        logger.info("begin queryMedicalTakeReasonById");
        ResponseValue resp = new ResponseValue();
        BasMedicalTakeReason resultObj =
            basMedicalTakeReasonService.queryMedicalTakeReasonById(medicalTakeReason.getMedTakeReasonId());
        resp.put("medicalTakeReason", resultObj);
        logger.info("end queryMedicalTakeReasonById");
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
    @RequestMapping(value = "/saveMedicalTakeReason")
    @ResponseBody
    @ApiOperation(value = "修改或者添加用药原因", httpMethod = "POST", notes = "修改或者添加用药原因")
    public String saveMedicalTakeReason(
        @ApiParam(name = "medicalTakeReason", value = "用药原因对象") @RequestBody BasMedicalTakeReason medicalTakeReason)
    {
        logger.info("begin saveMedicalTakeReason");
        ResponseValue resp = new ResponseValue();
        ValidatorBean validatorBean = beanValidator(medicalTakeReason);
        if (!(validatorBean.isValidator()))
        {
            resp.put("resultCode", "10000001");
            resp.put("resultMessage", validatorBean.getMessage());
            return resp.getJsonStr();
        }
        basMedicalTakeReasonService.saveMedicalTakeReason(medicalTakeReason);
        logger.info("end saveMedicalTakeReason");
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
    @RequestMapping(value = "/deleteMedicalTakeReason")
    @ResponseBody
    @ApiOperation(value = "删除用药原因", httpMethod = "POST", notes = "删除用药原因")
    public String deleteMedicalTakeReason(@ApiParam(name = "medTakeReasonIdList", value = "用药原因对象") @RequestBody List<String> medTakeReasonIdList)
    {
        logger.info("begin deleteMedicalTakeReason");
        ResponseValue resp = new ResponseValue();
        basMedicalTakeReasonService.deleteMedicalTakeReason(medTakeReasonIdList);
        logger.info("end deleteMedicalTakeReason");
        return resp.getJsonStr();
    }
    
}
