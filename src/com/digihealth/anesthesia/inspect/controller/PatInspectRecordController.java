package com.digihealth.anesthesia.inspect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/inspect")
@Api(value = "PatInspectRecordController", description = "检验检查结果处理类")
public class PatInspectRecordController extends BaseController {
	/*
	 * 检验检查病人信息列表
	 */
	@RequestMapping(value = "/getRegInfoListByPatInspect")
	@ResponseBody
	@ApiOperation(value = "检验检查病人信息列表", httpMethod = "POST", notes = "检验检查病人信息列表")
	public String getRegInfoListByPatInspect(@ApiParam(name = "searchFormBean", value = "查询参数") @RequestBody SystemSearchFormBean searchFormBean){
		logger.info("--------------start getRegInfoListByPatInspect--------------");
		ResponseValue resp = new ResponseValue();
		resp.put("resultList", patInspectRecordService.getRegInfoListByPatInspect(searchFormBean));
		resp.put("total", patInspectRecordService.getTotalRegInfoListByPatInspect(searchFormBean));
		logger.info("--------------end getRegInfoListByPatInspect--------------");
		return resp.getJsonStr();
	}
	
	/*
	 * 患者对应检验检测列表
	 */
	@RequestMapping(value = "/getPatInspectRecordList")
	@ResponseBody
	@ApiOperation(value = "患者对应检验检测列表", httpMethod = "POST", notes = "患者对应检验检测列表")
	public String getPatInspectRecordList(@ApiParam(name = "searchFormBean", value = "查询参数") @RequestBody SystemSearchFormBean searchFormBean){
		logger.info("--------------start getPatInspectRecordList--------------");
		ResponseValue resp = new ResponseValue();
		resp.put("resultList", patInspectRecordService.getPatInspectRecordList(searchFormBean));
		resp.put("total", patInspectRecordService.getTotalPatInspectRecordList(searchFormBean));
		logger.info("--------------end getPatInspectRecordList--------------");
		return resp.getJsonStr();
	}
}
