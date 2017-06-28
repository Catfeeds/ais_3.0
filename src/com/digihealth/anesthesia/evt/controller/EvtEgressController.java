package com.digihealth.anesthesia.evt.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.common.beanvalidator.ValidatorBean;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.evt.formbean.RegOptOperEgressFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchOptOperEgress;
import com.digihealth.anesthesia.evt.po.EvtEgress;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/operation")
public class EvtEgressController extends BaseController {

	@RequestMapping(value = "/searchEgressList")
	@ResponseBody
	@ApiOperation(value = "查询出量list", httpMethod = "POST", notes = "查询出量list")
	public String searchEgressList(
			@ApiParam(name = "formbean", value = "参数")@RequestBody SearchFormBean searchBean) {
		logger.info("begin searchEgressList");
		ResponseValue resp = new ResponseValue();
		List<SearchOptOperEgress> resulitList = evtEgressService.searchEgressList(searchBean);
		resp.put("resultList", resulitList);
		logger.info("end searchEgressList");
		return resp.getJsonStr();

	}

	@RequestMapping(value = "/searchEgressGroupByDefIdList")
	@ResponseBody
	@ApiOperation(value = "分组获取相同的出量list", httpMethod = "POST", notes = "分组获取相同的出量list")
	public String searchEgressGroupByDefIdList(
			@ApiParam(name = "formbean", value = "参数")@RequestBody SearchFormBean searchBean) {
		logger.info("begin searchEgressGroupByDefIdList");
		ResponseValue resp = new ResponseValue();
		List<RegOptOperEgressFormBean> resulitList = evtEgressService.searchEgressGroupByDefIdList(searchBean);
		resp.put("resultList", resulitList);
		logger.info("end searchEgressGroupByDefIdList");
		return resp.getJsonStr();
	}

	@RequestMapping(value = "/saveEgress")
	@ResponseBody
	@ApiOperation(value = "保存出量", httpMethod = "POST", notes = "保存出量")
	public String saveEgress(@ApiParam(name = "formbean", value = "参数")@RequestBody EvtEgress egress) {
		ResponseValue value = new ResponseValue();
		ValidatorBean validatorBean = beanValidator(egress);
		if (!(validatorBean.isValidator())) {
			value.setResultCode("10000001");
			value.setResultMessage(validatorBean.getMessage());
			return value.getJsonStr();
		}
		if (StringUtils.isBlank(egress.getIoDefId())) {
			value.setResultCode("70000000");
			value.setResultMessage("ioDefId必须传");
			return value.getJsonStr();
		}
		evtEgressService.saveEgress(egress);
		value.put("egressId", egress.getEgressId());
		logger.info("end saveEgress");
		return value.getJsonStr();
	}

	@RequestMapping(value = "/deleteEgress")
	@ResponseBody
	@ApiOperation(value = "删除出量", httpMethod = "POST", notes = "删除出量")
	public String deleteEgress(@ApiParam(name = "formbean", value = "参数")@RequestBody EvtEgress egress) {
		logger.info("begin deleteEgress");
		ResponseValue value = new ResponseValue();
		evtEgressService.deleteEgress(egress);
		logger.info("end deleteEgress");
		return value.getJsonStr();
	}
}
