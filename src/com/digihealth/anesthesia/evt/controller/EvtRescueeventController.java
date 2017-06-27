package com.digihealth.anesthesia.evt.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.po.EvtRescueevent;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * 
 * Title: RescueeventController.java Description: 抢救事件
 * 
 * @author liukui
 * @created 2015-9-15 下午1:56:40
 */
@Controller
@RequestMapping(value = "/operation")
@Api(value = "EvtRescueeventController", description = "抢救事件处理类")
public class EvtRescueeventController extends BaseController {

	/**
	 * 抢救事件
	 * 
	 * @param searchBean
	 * @return
	 */
	@RequestMapping(value = "/searchRescueeventList")
	@ResponseBody
	@ApiOperation(value = "查询抢救事件", httpMethod = "POST", notes = "查询抢救事件")
	public String searchRescueeventList(@ApiParam(name = "searchBean", value = "系统查询参数") @RequestBody SearchFormBean searchBean) {
		// 抢救事件
		ResponseValue resp = new ResponseValue();
		logger.info("begin searchRescueeventList");
		List<EvtRescueevent> rescueeventList = evtRescueeventService.searchRescueeventList(searchBean);
		resp.put("resultList", rescueeventList);
		logger.info("end searchRescueeventList");
		return resp.getJsonStr();
	}

	/**
	 * 抢救事件当前模式
	 * 
	 * @param searchBean
	 * @return
	 */
	@RequestMapping(value = "/searchRescueeventCurrentState")
	@ResponseBody
	@ApiOperation(value = "查询抢救事件当前模式", httpMethod = "POST", notes = "查询抢救事件当前模式")
	public String searchRescueeventCurrentState(@ApiParam(name = "searchBean", value = "系统查询参数") @RequestBody SearchFormBean searchBean) {
		// 抢救事件
		logger.info("begin searchRescueeventCurrentState");
		ResponseValue resp = new ResponseValue();
		EvtRescueevent rescueevent = new EvtRescueevent();
		searchBean.setCurrentState("1"); // 当前有效状态
		if (evtRescueeventService.searchRescueeventList(searchBean).size() > 0) {
			rescueevent = evtRescueeventService.searchRescueeventList(searchBean).get(0);
		} else {
			rescueevent.setDocId(searchBean.getDocId());
			rescueevent.setModel("normal");
		}
		resp.put("rescueevent", rescueevent);
		logger.info("end searchRescueeventCurrentState");
		return resp.getJsonStr();
	}

	@RequestMapping(value = "/saveRescueevent")
	@ResponseBody
	@ApiOperation(value = "保存抢救事件", httpMethod = "POST", notes = "保存抢救事件")
	public String saveRescueevent(@ApiParam(name = "rescueevent", value = "系统查询参数")@RequestBody EvtRescueevent rescueevent) {
		logger.info("begin saveRescueevent");
		ResponseValue resp = new ResponseValue();
		evtRescueeventService.saveRescueevent(rescueevent);
		resp.put("rescueeventId", rescueevent.getRescueEventId());
		logger.info("end saveRescueevent");
		return resp.getJsonStr();
	}

}
