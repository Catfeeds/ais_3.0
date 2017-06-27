package com.digihealth.anesthesia.basedata.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.DiagnosedefFormBean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasDiagnosedef;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;


/**
 * 
     * Title: DiagnosedefController.java    
     * Description: 诊断名称Controller
     * @author chengwang       
     * @created 2015-9-15 下午1:56:40
 */
@Controller
@RequestMapping(value = "/basedata")
@Api(value = "BasDiagnosedefController", description = "诊断名称处理类")
public class BasDiagnosedefController extends BaseController{

	@RequestMapping(value = "/getDiagnosedefList")
	@ResponseBody
	@ApiOperation(value = "查询诊断名称", httpMethod = "POST", notes = "查询诊断名称")
	public String getDiagnosedefList(@ApiParam(name = "baseQuery", value = "系统查询对象") @RequestBody BaseInfoQuery baseQuery) {
		logger.info("begin getDiagnosedefList");
		ResponseValue resp = new ResponseValue();
		if(null == baseQuery)
		{
			baseQuery = new BaseInfoQuery();
		}
		List<DiagnosedefFormBean> resultList = basDiagnosedefService.findList(baseQuery);
		resp.put("resultList", resultList);
		logger.info("end getDiagnosedefList");
		return resp.getJsonStr();
	}
	
	
	/**
	 * 
	     * @discription 根据条件查询诊断
	     * @author chengwang       
	     * @created 2015年12月3日 下午3:01:40     
	     * @param systemSearchFormBean
	     * @return
	 */
	@RequestMapping(value = "/queryDiagnosedefList")
	@ResponseBody
	@ApiOperation(value = "根据条件查询诊断", httpMethod = "POST", notes = "根据条件查询诊断")
	public String queryDiagnosedefList(@ApiParam(name = "systemSearchFormBean", value = "系统查询对象") @RequestBody SystemSearchFormBean systemSearchFormBean) {
		logger.info("begin queryDiagnosedefList");
		ResponseValue resp = new ResponseValue();
		List<BasDiagnosedef> resultList = basDiagnosedefService.queryDiagnosedefList(systemSearchFormBean);
		int total = basDiagnosedefService.queryDiagnosedefListTotal(systemSearchFormBean);
		resp.put("resultList", resultList);
		resp.put("total", total);
		logger.info("end queryDiagnosedefList");
		return resp.getJsonStr();
	}
	
	/**
	 * 
	     * @discription 查询单个诊断信息
	     * @author chengwang       
	     * @created 2015年12月3日 下午3:01:54     
	     * @param HisDiagnosedef
	     * @return
	 */
	@RequestMapping(value = "/queryDiagnosedefById")
	@ResponseBody
	@ApiOperation(value = "查询单个诊断信息", httpMethod = "POST", notes = "查询单个诊断信息")
	public String queryDiagnosedefById(@ApiParam(name = "diagnosedef", value = "诊断名称对象") @RequestBody BasDiagnosedef diagnosedef){
		logger.info("begin queryDiagnosedefById");
		ResponseValue resp = new ResponseValue();
        BasDiagnosedef resultDiagnosedef = basDiagnosedefService.searchDiagnosedefById(diagnosedef.getDiagDefId());
		resp.put("diagnosedef", resultDiagnosedef);
		logger.info("end queryDiagnosedefById");
		return resp.getJsonStr();
	}
	
	
	/**
	 * 
	     * @discription 修改或者添加诊断
	     * @author chengwang       
	     * @created 2015年12月3日 下午3:02:15     
	     * @param HisDiagnosedef
	     * @return
	 */
	@RequestMapping(value = "/updateDiagnosedef")
	@ResponseBody
	@ApiOperation(value = "修改或者添加诊断名称", httpMethod = "POST", notes = "修改或者添加诊断名称")
	public String updateDiagnosedef(@ApiParam(name = "diagnosedef", value = "诊断名称对象") @RequestBody BasDiagnosedef diagnosedef){
		logger.info("begin updateDiagnosedef");
		ResponseValue resp = new ResponseValue();
		basDiagnosedefService.updateDiagnosedef(diagnosedef);
		logger.info("end updateDiagnosedef");
		return resp.getJsonStr();
	}
	
}
