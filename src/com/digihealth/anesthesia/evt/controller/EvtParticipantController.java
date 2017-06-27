package com.digihealth.anesthesia.evt.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.po.EvtParticipant;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/operation")
public class EvtParticipantController extends BaseController {
	@RequestMapping(value = "/searchParticipantList")
	@ResponseBody
	@ApiOperation(value = "查询手术人员列表", httpMethod = "POST", notes = "查询手术人员列表")
	public String searchParticipantList(@ApiParam(name = "searchBean", value = "参数")@RequestBody SearchFormBean searchBean) {
		logger.info("begin searchParticipantList");
		ResponseValue resp = new ResponseValue();
		List<EvtParticipant> resultList = evtParticipantService.searchParticipantList(searchBean);
		resp.put("resultList", resultList);
		logger.info("end searchParticipantList");
		return resp.getJsonStr();
	}

	/**
	 * 根据docId获取当次手术的麻醉医生及护士信息
	 * 
	 * @param searchBean
	 * @return
	 */
	@RequestMapping(value = "/queryOperPersonListByDocId")
	@ResponseBody
	@ApiOperation(value = "根据文书id查询手术人员列表", httpMethod = "POST", notes = "根据文书id查询手术人员列表")
	public String queryOperPersonListByDocId(@ApiParam(name = "searchBean", value = "参数")@RequestBody SearchFormBean searchBean) {
		logger.info("begin queryOperPersonListByDocId");
		ResponseValue resp = new ResponseValue();
		List<EvtParticipant> resultList = evtParticipantService.queryOperPersonListByDocId(searchBean);
		resp.put("resultList", resultList);
		logger.info("end queryOperPersonListByDocId");
		return resp.getJsonStr();
	}

	/**
	 * 批量保存事件数据
	 * 
	 * @param participantList
	 * @return
	 */

	@RequestMapping(value = "/saveParticipant")
	@ResponseBody
	@ApiOperation(value = "保存手术人员信息", httpMethod = "POST", notes = "保存手术人员信息")
	public String saveParticipant(@ApiParam(name = "participantList", value = "参数")@RequestBody List<EvtParticipant> participantList) {
		logger.info("begin saveParticipant");
		ResponseValue resp = new ResponseValue();
		evtParticipantService.saveParticipant(participantList);
		logger.info("end saveParticipant");
		return resp.getJsonStr();
	}
}
