package com.digihealth.anesthesia.basedata.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.OperDefFormBean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasOperdef;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;


/**
 * 
     * Title: OperdefController.java    
     * Description: 手术名称Controller
     * @author liukui       
     * @created 2015-9-15 下午1:56:40
 */
@Controller
@RequestMapping(value = "/basedata")
@Api(value="BasOperdefController",description="手术名称处理类")
public class BasOperdefController extends BaseController{

	/**
	 * 查询手术名称
	 * @param baseQuery
	 * @return
	 */
	@RequestMapping(value = "/getOperdefList")
	@ResponseBody
	@ApiOperation(value="查询手术名称列表",httpMethod="POST",notes="查询手术名称列表")
	public String getOperdefList(@ApiParam(name="baseQuery", value ="系统查询参数") @RequestBody BaseInfoQuery baseQuery) {
        logger.info("begin getOperdefList");
        ResponseValue resp = new ResponseValue();
        List<OperDefFormBean> resultList = new ArrayList<OperDefFormBean>();
        if(null == baseQuery)
        {
        	baseQuery = new BaseInfoQuery();
        }
        resultList = basOperdefService.findList(baseQuery);
        resp.put("resultList", resultList);
        logger.info("end getOperdefList");
        return resp.getJsonStr();
	}
	
	
	/**
	 * 
	     * @discription 根据条件查询手术名称
	     * @author chengwang       
	     * @created 2015年12月3日 下午3:01:40     
	     * @param systemSearchFormBean
	     * @return
	 */
	@RequestMapping(value = "/queryOperdefList")
	@ResponseBody
	@ApiOperation(value="根据条件查询手术名称",httpMethod="POST",notes="根据条件查询手术名称")
	public String queryOperdefList(@ApiParam(name="systemSearchFormBean", value ="系统查询参数") @RequestBody SystemSearchFormBean systemSearchFormBean) {
		logger.info("begin queryOperdefList");
		ResponseValue resp = new ResponseValue();
		List<BasOperdef> resultList = basOperdefService.queryOperdefList(systemSearchFormBean);
		int total = basOperdefService.queryOperdefListTotal(systemSearchFormBean);
		resp.put("resultList", resultList);
		resp.put("total", total);
		logger.info("end queryOperdefList");
		return resp.getJsonStr();
	}
	
	/**
	 * 
	     * @discription 查询单个手术名称
	     * @author chengwang       
	     * @created 2015年12月3日 下午3:01:54     
	     * @param dept
	     * @return
	 */
	@RequestMapping(value = "/queryOperdefById")
	@ResponseBody
	@ApiOperation(value="根据条件查询手术名称",httpMethod="POST",notes="根据条件查询手术名称")
	public String queryOperdefById(@ApiParam(name="operdef", value ="手术名称对象") @RequestBody BasOperdef operdef){
		logger.info("begin queryOperdefById");
		ResponseValue resp = new ResponseValue();
		BasOperdef resultDept = basOperdefService.queryOperdefById(operdef.getOperdefId());
		resp.put("operdef", resultDept);
		logger.info("end queryOperdefById");
		return resp.getJsonStr();
	}
	
	
	/**
	 * 
	     * @discription 修改或者添加手术名称
	     * @author liukui      
	     * @created 2015年12月3日 下午3:02:15     
	     * @param HisOperdef
	     * @return
	 */
	@RequestMapping(value = "/saveOperdef")
	@ResponseBody
	@ApiOperation(value="根据条件查询手术名称",httpMethod="POST",notes="根据条件查询手术名称")
	public String saveOperdef(@ApiParam(name="operdef", value ="手术名称对象") @RequestBody BasOperdef operdef){
		logger.info("begin saveOperdef");
		ResponseValue resp = new ResponseValue();
        basOperdefService.saveOperdef(operdef);
		logger.info("end saveOperdef");
		return resp.getJsonStr();
	}
	/**
	 * 
	     * @discription 删除手术名称
	     * @author liukui      
	     * @created 2015年12月3日 下午3:02:15     
	     * @param HisOperdef
	     * @return
	 */
	@RequestMapping(value = "/deleteOperDef")
	@ResponseBody
	@ApiOperation(value="删除手术名称",httpMethod="POST",notes="删除手术名称")
	public String deleteOperDef(@ApiParam(name="operdefIdList", value ="需要删除的手术id集合") @RequestBody List<String> operdefIdList){
		logger.info("begin deleteOperDef");
		ResponseValue resp = new ResponseValue();
        basOperdefService.deleteOperdef(operdefIdList);
		logger.info("end deleteOperDef");
		return resp.getJsonStr();
	}
	
}
