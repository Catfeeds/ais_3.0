package com.digihealth.anesthesia.basedata.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.po.BasConsultation;
import com.digihealth.anesthesia.common.config.Global;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.evt.formbean.SearchConditionFormBean;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/operation")
@Api(value = "BasConsultationController", description = "外部会诊处理类")
public class BasConsultationController  extends BaseController{

	@RequestMapping(value = "/updateConsultation")
	@ResponseBody
	@ApiOperation(value = "修改外部会诊", httpMethod = "POST", notes = "修改外部会诊")
	public String updateConsultation(@ApiParam(name = "consultation", value = "外部会诊对象") @RequestBody BasConsultation consultation){
		logger.info("begin updateConsultation");
		ResponseValue resp = new ResponseValue();
		if(null == consultation)
		{
			resp.setResultCode("70000000");
			resp.setResultMessage(Global.getRetMsg(resp.getResultCode()));
			
		}else
		{
			basConsultationService.updateConsultation(consultation);
		}
		
		logger.info("end updateConsultation");
		return resp.getJsonStr();
	}
	
	@RequestMapping(value = "/searchConsultation")
	@ResponseBody
	@ApiOperation(value = "查询外部会诊", httpMethod = "POST", notes = "查询外部会诊")
	public String searchConsultation(@ApiParam(name = "searchConditionFormBean", value = "统计查询参数对象") @RequestBody SearchConditionFormBean searchConditionFormBean){
		logger.info("begin searchConsultation");
		ResponseValue resp = new ResponseValue();
		List<BasConsultation> searchConsultation = basConsultationService.searchConsultation(searchConditionFormBean);
		resp.put("resultList", searchConsultation);
		resp.put("total", searchConsultation.size());
		logger.info("end searchConsultation");
		return resp.getJsonStr();
	}
	
	@RequestMapping(value = "/searchConsultationById")
	@ResponseBody
	@ApiOperation(value = "根据id查询外部会诊", httpMethod = "POST", notes = "根据id查询外部会诊")
	public String searchConsultationById(@ApiParam(name = "consultation", value = "外部会诊对象") @RequestBody BasConsultation consultation){
		logger.info("begin searchConsultation");
		ResponseValue resp = new ResponseValue();
		BasConsultation resultConsultation = basConsultationService.searchConsultationById(consultation!=null?consultation.getConttId():"");
		resp.put("consultation", resultConsultation);
		logger.info("end searchConsultation");
		return resp.getJsonStr();
	}
	
	@RequestMapping(value = "/deleteConsultationById")
	@ResponseBody
	@ApiOperation(value = "删除外部会诊", httpMethod = "POST", notes = "删除外部会诊")
	public String deleteConsultationById(@ApiParam(name = "consultation", value = "外部会诊对象") @RequestBody BasConsultation consultation){
		logger.info("begin searchConsultation");
		ResponseValue resp = new ResponseValue();
		basConsultationService.deleteConsultationById(consultation!=null?consultation.getConttId():"");
		logger.info("end searchConsultation");
		return resp.getJsonStr();
	}
}
