package com.digihealth.anesthesia.operProceed.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.operProceed.formbean.BasAnaesMonitorConfigFormBean;
import com.digihealth.anesthesia.operProceed.po.BasAnaesMonitorConfig;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;


/**
 * 
     * Title: AnaesMonitorConfigController.java    
     * Description:监测点设置Controller
     * @author liukui       
     * @created 2015-9-15 下午1:56:40
 */
@Controller
@RequestMapping(value = "/basedata")
@Api(value = "BasAnaesMonitorConfigController", description = "麻醉监测标记点设置处理类")
public class BasAnaesMonitorConfigController extends BaseController{

	
	/**
	 * 进入术中麻醉记录单显示项数据的展示
	 * @param baseQuery
	 * @return
	 */
	@RequestMapping(value = "/getAnaesRecordShowListByRegOptId")
	@ResponseBody
	@ApiOperation(value = "查询术中麻醉记录单显示项", httpMethod = "POST", notes = "查询术中麻醉记录单显示项")
	public String getAnaesRecordShowListByRegOptId(@ApiParam(name = "baseQuery", value = "系统查询对象") @RequestBody BaseInfoQuery baseQuery) {
		logger.info("begin getAnaesRecordShowListByRegOptId");
		ResponseValue resp = new ResponseValue();
		List<BasAnaesMonitorConfigFormBean> showList = basAnaesMonitorConfigService.getAnaesMonitorRecordShowListByRegOptId(baseQuery);
		resp.put("showList", showList);
		logger.info("end getAnaesRecordShowListByRegOptId");
		return resp.getJsonStr();
	}
	
	
	/**
	 * 保存监测点配置
	 * @param AnaesObserveOperationFormBean
	 * @return
	 */
	@RequestMapping(value = "/saveAnaesMonitorConfig")
	@ResponseBody
	@ApiOperation(value = "保存监测点配置", httpMethod = "POST", notes = "保存监测点配置")
	public String saveAnaesMonitorConfig(@ApiParam(name = "anaesMonitorConfigList", value = "监测点配置列表") @RequestBody List<BasAnaesMonitorConfig> anaesMonitorConfigList){
		logger.info("begin saveAnaesMonitorConfig");
		ResponseValue resp = new ResponseValue();
		basAnaesMonitorConfigService.saveAnaesMonitorConfig(anaesMonitorConfigList);
		logger.info("end saveAnaesMonitorConfig");
		return resp.getJsonStr();
	}

	
}
