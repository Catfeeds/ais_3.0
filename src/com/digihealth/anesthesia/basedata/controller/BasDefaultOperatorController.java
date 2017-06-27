package com.digihealth.anesthesia.basedata.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.SearchDefaultOperatorFormBean;
import com.digihealth.anesthesia.basedata.po.BasDefaultOperator;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;


/**
 * 
     * Title: DefaultOperatorController.java    
     * Description: 手术室人员默认配置表Controller
     * @author liukui       
     * @created 2015-9-15 下午1:56:40
 */
@Controller
@RequestMapping(value = "/basedata")
@Api(value = "BasDefaultOperatorController", description = "手术室人员默认配置处理类")
public class BasDefaultOperatorController extends BaseController{
	/**
	 * 手术室人员配置查询接口
	 * @param baseQuery
	 * @return
	 */
	@RequestMapping(value = "/getDefaultOperator")
	@ResponseBody
	@ApiOperation(value = "查询手术室人员配置", httpMethod = "POST", notes = "查询手术室人员配置")
	public String getDefaultOperator(@ApiParam(name = "baseQuery", value = "系统查询对象") @RequestBody BaseInfoQuery baseQuery) {
		logger.info("begin getDefaultOperator");
		ResponseValue resp = new ResponseValue();
		List<SearchDefaultOperatorFormBean> resultList = basDefaultOperatorService.findList(baseQuery);
		resp.put("resultList", resultList);
		logger.info("end getDefaultOperator");
		return resp.getJsonStr();
	}
	
	/**
	 * 创建手术室人员配置
	 * @param Dispatch
	 * @return
	 */
	@RequestMapping(value = "/saveDefaultOperator")
	@ResponseBody
	@ApiOperation(value = "创建手术室人员配置", httpMethod = "POST", notes = "创建手术室人员配置")
	public String saveDefaultOperator(@ApiParam(name = "defaultOperator", value = "手术室人员配置对象") @RequestBody BasDefaultOperator defaultOperator){
		logger.info("begin saveDefaultOperator");
		ResponseValue resp = new ResponseValue();
		basDefaultOperatorService.saveDefaultOperator(defaultOperator);
		logger.info("end saveDefaultOperator");
		return resp.getJsonStr();
	}
	
	
	/**
	 * 手术室人员配置取消接口
	 * @param Dispatch
	 * @return
	 */
	@RequestMapping(value = "/deleteDefaultOperator")
	@ResponseBody
	@ApiOperation(value = "删除手术室人员配置", httpMethod = "POST", notes = "删除手术室人员配置")
	public String deleteDefaultOperator(@ApiParam(name = "defaultOperator", value = "手术室人员配置对象") @RequestBody BasDefaultOperator defaultOperator){
		logger.info("begin deleteDefaultOperator");
		ResponseValue resp = new ResponseValue();
		basDefaultOperatorService.deleteDefaultOperator(defaultOperator);
		logger.info("end deleteDefaultOperator");
		return resp.getJsonStr();
	}
}
