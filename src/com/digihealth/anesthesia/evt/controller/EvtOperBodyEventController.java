package com.digihealth.anesthesia.evt.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.evt.formbean.OperBodyFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/operation")
public class EvtOperBodyEventController extends BaseController {

	@RequestMapping(value = "/queryOperBodyEventList")
	@ResponseBody
	@ApiOperation(value = "查询手术体位更换事件", httpMethod = "POST", notes = "查询手术体位更换事件")
	public String queryOperBodyEventList(@ApiParam(name = "searchBean", value = "参数")@RequestBody SearchFormBean searchBean) {
		logger.info("begin queryOperBodyEventList");
		ResponseValue resp = new ResponseValue();
		List<OperBodyFormBean> resultList = evtOperBodyEventService.queryOperBodyEventList(searchBean);
		resp.put("resultList", resultList);
		logger.info("end queryOperBodyEventList");
		return resp.getJsonStr();
	}

	/**
	 * 手术体位 返回手术体位字符串
	 * 
	 * @param searchBean
	 * @return
	 */
	@RequestMapping("queryOperBodyList")
	@ResponseBody
	@ApiOperation(value = "手术体位 返回手术体位字符串", httpMethod = "POST", notes = "手术体位 返回手术体位字符串")
	public String queryOperBodyList(@ApiParam(name = "searchBean", value = "参数")@RequestBody SearchFormBean searchBean) {
		logger.info("----------begin queryOperBodyEventList-----------");
		ResponseValue res = new ResponseValue();
		String operBodyString = evtOperBodyEventService.queryOperBodyList(searchBean);
		res.put("resultList", operBodyString);
		return res.getJsonStr();
	}

	/**
	 * 保存术中手术体位变更事件数据
	 * 
	 * @param saveOperBodyEvent
	 * @return
	 */
	// @RequestMapping(value = "/saveOperBodyEvent")
	// @ResponseBody
	// public Map saveOperBodyEvent(@RequestBody OperBodyEvent operBodyEvent) {
	// logger.info("begin saveOperBodyEvent");
	// Map map = new HashMap();
	// try {
	// operBodyEventService.saveOperBody(operBodyEvent);
	// map.put("result", true);
	// } catch (Exception e) {
	// if(logger.isErrorEnabled()){
	// logger.error(Exceptions.getStackTraceAsString(e));
	// }
	// map.put("resultCode", "10000000");
	// map.put("resultMessage", "系统错误，请与系统管理员联系!");
	// }
	// logger.info("end saveOperBodyEvent");
	// return map;
	// }
}
