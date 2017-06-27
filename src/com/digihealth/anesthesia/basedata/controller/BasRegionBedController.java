package com.digihealth.anesthesia.basedata.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasRegionBed;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/bas")
@Api(value="BasRegionBedController",description="恢复室床位信息处理类")
public class BasRegionBedController extends BaseController{
	@RequestMapping("/getregionbed")
	@ResponseBody
	@ApiOperation(value="手术申请>查询恢复室床位信息列表",httpMethod="POST",notes="查询恢复室床位信息列表")
	public String getregionbed(@ApiParam(name="params", value ="系统查询参数") @RequestBody SystemSearchFormBean regionBedFormbean){
		ResponseValue resp = new ResponseValue();
		List<BasRegionBed> resultList = basRegionBedService.getregionbed(regionBedFormbean);
		resp.put("resultList", resultList);
		return resp.getJsonStr();
	}
	
	
	@RequestMapping(value = "/getregionbedlist")
	@ResponseBody
	@ApiOperation(value="根据条件查询恢复室床位信息列表",httpMethod="POST",notes="根据条件查询恢复室床位信息列表")
	public String basregionbedlist(@ApiParam(name="params", value ="系统查询参数") @RequestBody SystemSearchFormBean systemSearchFormBean) {
		logger.info("begin getregionbedlist");
		ResponseValue resp = new ResponseValue();
		List<BasRegionBed> resultList = basRegionBedService.queryRegionBedList(systemSearchFormBean);
		int total = basRegionBedService.queryRegionBedListTotal(systemSearchFormBean);
		resp.put("resultList", resultList);
		resp.put("total", total);
		logger.info("end getregionbedlist");
		return resp.getJsonStr();
	}
	
	
	@RequestMapping(value = "/queryRegionBedById")
	@ResponseBody
	@ApiOperation(value="根据主键查询恢复室床位信息",httpMethod="POST",notes="根据主键查询恢复室床位信息")
	public String queryRegionBedById(@ApiParam(name="basRegionBed", value ="询恢复室床位信息对象") @RequestBody BasRegionBed basRegionBed){
		logger.info("begin queryRegionBedById");
		ResponseValue resp = new ResponseValue();
		BasRegionBed resultObj = basRegionBedService.queryRegionBedById(basRegionBed.getId());
		resp.put("regionBed", resultObj);
		logger.info("end queryRegionBedById");
		return resp.getJsonStr();
	}
	
	@RequestMapping(value = "/updateRegionBed")
	@ResponseBody
	@ApiOperation(value="保存恢复室床位信息",httpMethod="POST",notes="保存恢复室床位信息")
	public String updateRegionBed(@ApiParam(name="basRegionBed", value ="询恢复室床位信息对象") @RequestBody BasRegionBed BasRegionBed){
		logger.info("begin updateRegionBed");
		ResponseValue resp = new ResponseValue();
		basRegionBedService.updateRegionBed(BasRegionBed);
		logger.info("end updateRegionBed");
		return resp.getJsonStr();
	}
	
	@RequestMapping(value = "/deleteRegionBed")
	@ResponseBody
	@ApiOperation(value="根据主键删除恢复室床位信息",httpMethod="DELETE",notes="根据主键删除恢复室床位信息")
	public String deleteRegionBed(@RequestBody List<String> idList){
		logger.info("begin deleteRegionBed");
		ResponseValue resp = new ResponseValue();
        basRegionBedService.deleteRegionBed(idList);
		logger.info("end deleteRegionBed");
		return resp.getJsonStr();
	}
}
