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
@Api(value = "PatInspectItemController", description = "检验检查明细结果处理类")
public class PatInspectItemController extends BaseController {
	
	@RequestMapping(value = "/getPatInspectItemList")
	@ResponseBody
	@ApiOperation(value = "检验检查病人明细信息列表", httpMethod = "POST", notes = "检验检查病人明细信息列表")
	public String getPatInspectItemList(@ApiParam(name = "searchFormBean", value = "查询参数") @RequestBody SystemSearchFormBean searchFormBean){
		logger.info("--------------start getRegInfoListByPatInspect--------------");
		ResponseValue resp = new ResponseValue();
		resp.put("resultList", patInspectItemService.getPatInspectItemList(searchFormBean));
		logger.info("--------------end getRegInfoListByPatInspect--------------");
		return resp.getJsonStr();
	}
}
