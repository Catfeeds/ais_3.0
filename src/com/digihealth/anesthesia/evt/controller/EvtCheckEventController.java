package com.digihealth.anesthesia.evt.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.evt.formbean.CheckeventItemFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.po.EvtCheckEvent;
import com.digihealth.anesthesia.evt.po.EvtCheckEventItemRelation;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/operation")
@Api(value = "EvtCheckEventController", description = "检查检验事件处理类")
public class EvtCheckEventController extends BaseController {

	/**
	 * 查询检测事件
	 * @param searchBean
	 * @return
	 */
	@RequestMapping(value = "/searchCheckeventList")
	@ResponseBody
	@ApiOperation(value = "查询检测事件", httpMethod = "POST", notes = "查询检测事件")
	public String searchCheckeventList(@ApiParam(name = "searchBean", value = "查询参数") @RequestBody SearchFormBean searchBean) {
		logger.info("begin searchCheckeventList");
		ResponseValue resp = new ResponseValue();
//		EvtCheckEvent evtCheckEvent = new EvtCheckEvent();
		List<EvtCheckEvent> checkeventList = evtCheckEventService.serarchCheckevent(searchBean);
//		if (!checkeventList.isEmpty() && checkeventList.size() > 0) {
//			evtCheckEvent = evtCheckEventService.searchEvtCheckEventById(checkeventList.get(0).getCheEventId());
//		}
		resp.put("resultList", checkeventList);
		logger.info("end searchCheckeventList");
		return resp.getJsonStr();
	}
	
	/**
	 * 查询检测事件明细数据
	 * @param searchBean
	 * @return
	 */
	@RequestMapping(value = "/searchCheckeventItemList")
	@ResponseBody
	@ApiOperation(value = "查询检测事件明细数据", httpMethod = "POST", notes = "查询检测事件明细数据")
	public String searchCheckeventItemList(@ApiParam(name = "searchBean", value = "查询参数") @RequestBody SearchFormBean searchBean) {
		logger.info("begin searchCheckeventList");
		ResponseValue resp = new ResponseValue();
		List<EvtCheckEventItemRelation> checkeventList = evtCheckEventService.serarchCheckeventItemRelationList(searchBean);
		resp.put("resultList", checkeventList);
		logger.info("end searchCheckeventList");
		return resp.getJsonStr();
	}
	
	@RequestMapping(value = "/saveCheckevent")
	@ResponseBody
	@ApiOperation(value = "保存检查检验事件", httpMethod = "POST", notes = "保存检查检验事件")
	public String saveCheckevent(@ApiParam(name = "checkeventItemFormBean", value = "保存参数") @RequestBody CheckeventItemFormBean checkeventItemFormBean) {
		logger.info("begin saveCheckevent");
		ResponseValue resp = new ResponseValue();
		String date = evtCheckEventService.updateCheckeventItemRelation(checkeventItemFormBean);
		resp.put("createTime",date);
		logger.info("end saveCheckevent");
		return resp.getJsonStr();
	}
	
	@RequestMapping(value = "/deleteCheckevent")
	@ResponseBody
	@ApiOperation(value = "删除检查检验事件", httpMethod = "POST", notes = "删除检查检验事件")
	public String deleteCheckevent(@ApiParam(name = "searchBean", value = "删除参数") @RequestBody SearchFormBean searchBean) {
		ResponseValue resp = new ResponseValue();
		evtCheckEventService.deleteCheckItem(searchBean);
		return resp.getJsonStr();
	}
}
