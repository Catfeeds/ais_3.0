package com.digihealth.anesthesia.evt.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.common.beanvalidator.ValidatorBean;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.evt.formbean.RegOptOperIoeventFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchOptOperIoevent;
import com.digihealth.anesthesia.evt.po.EvtInEvent;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/operation")
public class EvtInEventController extends BaseController {

	@RequestMapping(value = "/searchIoeventList")
	@ResponseBody
	@ApiOperation(value = "查询所有入量事件", httpMethod = "POST", notes = "查询所有入量事件")
	public String searchIoeventList(@ApiParam(name = "formbean", value = "参数") @RequestBody SearchFormBean searchBean) {
		logger.info("begin searchIoeventList");
		ResponseValue resp = new ResponseValue();
		List<SearchOptOperIoevent> resultList = evtInEventService.searchIoeventList(searchBean);
		resp.put("resultList", resultList);
		logger.info("end searchIoeventList");
		return resp.getJsonStr();
	}

	@RequestMapping(value = "/searchIoeventGroupByDefIdList")
	@ResponseBody
	@ApiOperation(value = "分组查询入量时间list", httpMethod = "POST", notes = "分组查询入量时间list")
	public String searchIoeventGroupByDefIdList(@ApiParam(name = "formbean", value = "参数") @RequestBody SearchFormBean searchBean) {
		logger.info("begin searchIoeventGroupByDefIdList");
		ResponseValue resp = new ResponseValue();
		List<RegOptOperIoeventFormBean> resultList = evtInEventService.searchIoeventGroupByDefIdList(searchBean);
		resp.put("resultList", resultList);
		logger.info("end searchIoeventGroupByDefIdList");
		return resp.getJsonStr();
	}

	@RequestMapping(value = "/saveIoevent")
	@ResponseBody
	@ApiOperation(value = "保存入量事件", httpMethod = "POST", notes = "保存入量事件")
	public String saveIoevent(@ApiParam(name = "ioevent", value = "参数") @RequestBody EvtInEvent ioevent) {
		logger.info("begin saveIoevent");
		ResponseValue resp = new ResponseValue();
		ValidatorBean validatorBean = beanValidator(ioevent);
		if (!(validatorBean.isValidator())) {
			resp.setResultCode("10000001");
			resp.setResultMessage(validatorBean.getMessage());
			return resp.getJsonStr();
		}
		evtInEventService.saveIoevent(ioevent, resp);
		resp.put("inEventId", ioevent.getInEventId());
		logger.info("end saveIoevent");
		return resp.getJsonStr();
	}

	@RequestMapping(value = "/batchSaveIoevent")
	@ResponseBody
	@ApiOperation(value = "批量保存入量事件", httpMethod = "POST", notes = "批量保存入量事件")
	public String batchSaveIoevent(@ApiParam(name = "ioeventList", value = "参数") @RequestBody List<EvtInEvent> ioeventList) {
		logger.info("begin batchSaveIoevent");
		ResponseValue value = new ResponseValue();
		evtInEventService.batchSaveIoevent(ioeventList, value);
		logger.info("end batchSaveIoevent");
		return value.getJsonStr();
	}

	@RequestMapping(value = "/deleteIoevent")
	@ResponseBody
	@ApiOperation(value = "删除入量", httpMethod = "POST", notes = "删除入量")
	public String deleteIoevent(@ApiParam(name = "ioevent", value = "参数")@RequestBody EvtInEvent ioevent) {
		logger.info("begin deleteIoevent");
		ResponseValue value = new ResponseValue();
		evtInEventService.deleteIoevent(ioevent);
		logger.info("end deleteIoevent");
		return value.getJsonStr();
	}

	@RequestMapping(value = "/totleIoEvent")
	@ResponseBody
	@ApiOperation(value = "全部类型入量事件", httpMethod = "POST", notes = "全部类型入量事件")
	public String totleIoEvent(@ApiParam(name = "ioevent", value = "参数")@RequestBody SearchFormBean searchBean) {
		logger.info("begin totleIoEvent");
		ResponseValue value = new ResponseValue();
		String blood = evtInEventService.seleteBloodSumByDocId(searchBean.getDocId());
		String egress = evtInEventService.seleteEgressSumByDocId(searchBean.getDocId());
		String emiction = evtInEventService.seleteEmictionSumByDocId(searchBean.getDocId());
		String ioevent = evtInEventService.seleteIoeventSumByDocId(searchBean.getDocId());
		String otherEgress = evtInEventService.seleteOtherSumByDocId(searchBean.getDocId());
		value.put("blood", blood);
		value.put("egress", egress);
		value.put("emiction", emiction);
		value.put("ioevent", ioevent);
		value.put("otherEgress", otherEgress);
		logger.info("end totleIoEvent");
		return value.getJsonStr();
	}
}
