package com.digihealth.anesthesia.evt.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.common.beanvalidator.ValidatorBean;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.po.EvtOtherEvent;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/operation")
public class EvtOtherDataController extends BaseController {

	@RequestMapping(value = "/searchOthereventList")
	@ResponseBody
	@ApiOperation(value = "查询其他事件列表", httpMethod = "POST", notes = "查询其他事件列表")
	public String searchOthereventList(@ApiParam(name = "searchBean", value = "参数") @RequestBody SearchFormBean searchBean) {
		// 其他事件
		logger.info("begin searchOthereventList");
		ResponseValue resp = new ResponseValue();
		List<EvtOtherEvent> othereventList = evtOtherEventService.searchOthereventList(searchBean);
		resp.put("resultList", othereventList);
		logger.info("end searchOthereventList");
		return resp.getJsonStr();
	}

	@RequestMapping(value = "/saveOtherevent")
	@ResponseBody
	@ApiOperation(value = "保存其他事件", httpMethod = "POST", notes = "保存其他事件")
	public String saveOtherevent(@ApiParam(name = "otherevent", value = "参数") @RequestBody EvtOtherEvent otherevent) {
		logger.info("begin saveOtherevent");
		ResponseValue resp = new ResponseValue();
		ValidatorBean validatorBean = beanValidator(otherevent);
		if (!(validatorBean.isValidator())) {
			resp.put("resultCode", "10000001");
			resp.put("resultMessage", validatorBean.getMessage());
			return resp.getJsonStr();
		}

		evtOtherEventService.saveOtherevent(otherevent);
		resp.put("othereventId", otherevent.getOtherEventId());
		logger.info("end saveOtherevent");
		return resp.getJsonStr();
	}

	@RequestMapping(value = "/deleteOtherevent")
	@ResponseBody
	@ApiOperation(value = "删除其他事件", httpMethod = "POST", notes = "删除其他事件")
	public String deleteOtherevent(@ApiParam(name = "otherevent", value = "参数") @RequestBody EvtOtherEvent otherevent) {
		logger.info("begin deleteOtherevent");
		ResponseValue resp = new ResponseValue();
		evtOtherEventService.deleteOtherevent(otherevent);
		logger.info("end deleteOtherevent");
		return resp.getJsonStr();
	}
}
