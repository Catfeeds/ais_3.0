package com.digihealth.anesthesia.basedata.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasRegion;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;


/**
 * 
     * Title: RegionController.java    
     * Description: 病区Controller
     * @author liukui       
     * @created 2015-9-15 下午1:56:40
 */
@Controller
@RequestMapping(value = "/basedata")
@Api(value="BasRegionController",description="病区信息处理类")
public class BasRegionController extends BaseController{

	@RequestMapping(value = "/getRegionList")
	@ResponseBody
	@ApiOperation(value="手术申请>查询病区列表",httpMethod="POST",notes="查询病区列表")
	public String getRegionList(@RequestBody Map<String,Object> map) {
		logger.info("begin getRegionList");
		ResponseValue resp = new ResponseValue();
		List<BasRegion> resultList = new ArrayList<BasRegion>();
		if(null != map && null != map.get("name"))
		{
			String name = map.get("name").toString();
			BaseInfoQuery baseQuery = new BaseInfoQuery();
			baseQuery.setName(name);
			resultList = basRegionService.findList(baseQuery);
		}else
		{
			resultList = basRegionService.findList(null);
		}
		resp.put("resultList", resultList);
		logger.info("end getRegionList");
		return resp.getJsonStr();
	}
	
	/*@RequestMapping(value = "/queryRegionList")
	@ResponseBody
	public String queryRegionList(@RequestBody BaseInfoQuery baseQuery) {
		logger.info("begin queryRegionList");
		List<BasRegion> resultList = basRegionService.findList(baseQuery);
		logger.info("end queryRegionList");
		return JsonType.jsonType(resultList);
	}*/
	
	/**
	 * 
	     * @discription 根据条件查询病区
	     * @author chengwang       
	     * @created 2015年12月3日 下午3:01:40     
	     * @param systemSearchFormBean
	     * @return
	 */
	@RequestMapping(value = "/queryRegionList")
	@ResponseBody
	@ApiOperation(value="根据条件查询病区",httpMethod="POST",notes="根据条件查询病区")
	public String queryRegionList(@ApiParam(name="systemSearchFormBean", value ="系统查询对象") @RequestBody SystemSearchFormBean systemSearchFormBean) {
		logger.info("begin queryRegionList");
		ResponseValue resp = new ResponseValue();
		List<BasRegion> resultList = basRegionService.queryRegionList(systemSearchFormBean);
		int total = basRegionService.queryRegionListTotal(systemSearchFormBean);
		resp.put("resultList", resultList);
		resp.put("total", total);
		logger.info("end queryRegionList");
		return resp.getJsonStr();
	}
	
	/**
	 * 
	     * @discription 查询单个病区信息
	     * @author chengwang       
	     * @created 2015年12月3日 下午3:01:54     
	     * @param HisRegion
	     * @return
	 */
	@RequestMapping(value = "/queryRegionById")
	@ResponseBody
	@ApiOperation(value="根据主键查询病区信息",httpMethod="POST",notes="根据主键查询病区信息")
	public String queryRegionById(@ApiParam(name="region", value ="病区信息对象") @RequestBody BasRegion region){
		logger.info("begin queryRegionById");
		ResponseValue resp = new ResponseValue();
        BasRegion resultRegion = basRegionService.searchRegionById(region.getRegionId());
		resp.put("region", resultRegion);
		logger.info("end queryRegionById");
		return resp.getJsonStr();
	}
	
	
	/**
	 * 
	     * @discription 修改或者添加科室
	     * @author chengwang       
	     * @created 2015年12月3日 下午3:02:15     
	     * @param HisRegion
	     * @return
	 */
	@RequestMapping(value = "/updateRegion")
	@ResponseBody
	@ApiOperation(value="修改或者病区信息",httpMethod="POST",notes="修改或者病区信息")
	public String updateRegion(@ApiParam(name="region", value ="病区信息对象") @RequestBody BasRegion region){
		logger.info("begin updateRegion");
		ResponseValue resp = new ResponseValue();
		basRegionService.updateRegion(region);
		logger.info("end updateRegion");
		return resp.getJsonStr();
	}
}
