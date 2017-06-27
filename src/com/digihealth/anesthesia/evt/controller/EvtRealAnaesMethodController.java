package com.digihealth.anesthesia.evt.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.po.EvtRealAnaesMethod;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * 
 * Title: RealAnaesMethodController.java Description: 实际麻醉方法
 * 
 * @author liukui
 * @created 2015-9-15 下午1:56:40
 */
@Controller
@RequestMapping(value = "/operation")
@Api(value = "EvtRealAnaesMethodController", description = "麻醉方法事件处理类")
public class EvtRealAnaesMethodController extends BaseController {

	@RequestMapping(value = "/searchRealAnaesMethodList")
	@ResponseBody
	@ApiOperation(value = "查询麻醉方法事件", httpMethod = "POST", notes = "查询麻醉方法事件")
	public String searchRealAnaesMethodList(@ApiParam(name = "searchBean", value = "系统查询参数") @RequestBody SearchFormBean searchBean) {
		logger.info("begin searchRealAnaesMethodList");
		ResponseValue resp = new ResponseValue();
		List<EvtRealAnaesMethod> resultList = evtRealAnaesMethodService.searchRealAnaesMethodList(searchBean);
		resp.put("resultList", resultList);
		logger.info("end searchRealAnaesMethodList");
		return resp.getJsonStr();
	}

	/**
	 * 批量保存事件数据
	 * 
	 * @param realAnaesMethodList
	 * @return
	 */
	@RequestMapping(value = "/saveRealAnaesMethod")
	@ResponseBody
	@ApiOperation(value = "批量保存麻醉方法事件", httpMethod = "POST", notes = "批量保存麻醉方法事件")
	public String saveRealAnaesMethod(@ApiParam(name = "realAnaesMethodList", value = "麻醉方法列表对象") @RequestBody List<EvtRealAnaesMethod> realAnaesMethodList) {
		logger.info("begin saveRealAnaesMethod");
		ResponseValue resp = new ResponseValue();
		evtRealAnaesMethodService.saveRealAnaesMethod(realAnaesMethodList);
		logger.info("end saveRealAnaesMethod");
		return resp.getJsonStr();
	}
}
