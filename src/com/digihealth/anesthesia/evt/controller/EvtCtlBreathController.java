package com.digihealth.anesthesia.evt.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.po.EvtCtlBreath;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/operation")
public class EvtCtlBreathController extends BaseController {

	@RequestMapping(value = "/searchCtlBreathList")
	@ResponseBody
	@ApiOperation(value = "查询呼吸时间list", httpMethod = "POST", notes = "查询呼吸时间list")
	public String searchCtlBreathList(@ApiParam(name = "searchBean", value = "参数")@RequestBody SearchFormBean searchBean) {
		// 呼吸事件
		List<EvtCtlBreath> ctlBreathList = evtCtlBreathService.searchCtlBreathList(searchBean);
		return JsonType.jsonType(ctlBreathList);

	}

	/**
	 * 呼吸事件当前模式
	 * 
	 * @param searchBean
	 * @return
	 */
	@RequestMapping(value = "/searchCtlBreathCurrentState")
	@ResponseBody
	@ApiOperation(value = " 呼吸事件当前模式", httpMethod = "POST", notes = " 呼吸事件当前模式")
	public String searchCtlBreathCurrentState(@ApiParam(name = "searchBean", value = "参数")@RequestBody SearchFormBean searchBean) {
		// 抢救事件
		logger.info("begin searchCtlBreathCurrentState");
		EvtCtlBreath ctlBreath = new EvtCtlBreath();
		ResponseValue resp = new ResponseValue();
		searchBean.setCurrentState("1"); // 当前有效状态
		if (evtCtlBreathService.searchCtlBreathList(searchBean).size() > 0) {
			ctlBreath = evtCtlBreathService.searchCtlBreathList(searchBean).get(0);
		} else {
			ctlBreath.setDocId(searchBean.getDocId());
			ctlBreath.setType(1);// 默认自主呼吸
		}
		resp.put("ctlBreath", ctlBreath);
		logger.info("end searchCtlBreathCurrentState");
		return resp.getJsonStr();
	}

	@RequestMapping(value = "/saveCtlBreath")
	@ResponseBody
	@ApiOperation(value = "保存呼吸事件", httpMethod = "POST", notes = "保存呼吸事件")
	public String saveCtlBreath(@ApiParam(name = "ctlBreath", value = "参数")@RequestBody EvtCtlBreath ctlBreath) {
		logger.info("begin saveCtlBreath");
		ResponseValue resp = new ResponseValue();
		evtCtlBreathService.saveCtlBreath(ctlBreath, resp);
		resp.put("ctlBreId", ctlBreath.getCtlBreId());
		logger.info("end saveCtlBreath");
		return resp.getJsonStr();
	}
}
