package com.digihealth.anesthesia.basedata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.po.BasHealthNurse;
import com.digihealth.anesthesia.common.config.Global;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.sysMng.po.BasUser;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
@Controller
@RequestMapping(value = "/basedata")
@Api(value = "BasHealthNurseController", description = "卫生护士处理类")
public class BasHealthNurseController extends BaseController{

	@RequestMapping(value = "/queryHealthNurse")
	@ResponseBody
	@ApiOperation(value = "查询卫生护士", httpMethod = "POST", notes = "查询卫生护士")
	public String queryHealthNurse(@ApiParam(name = "healthNurse", value = "卫生护士对象") @RequestBody BasHealthNurse healthNurse) {
		logger.info("begin queryHealthNurse");
		ResponseValue resp = new ResponseValue();
		BasHealthNurse hn = basHealthNurseService.selectHealNurse(healthNurse.getOperaDate(), healthNurse.getOperRoomId());
		if(null != hn){
			String id = hn.getHealthnurse();
			if(null != id){
				BasUser u = basUserService.searchHnUserById(id);
				hn.setHnUser(u);
				resp.put("healthNurse", hn);
			}else{
				logger.info("----------queryHealthNurse----id为null---------------");
				resp.setResultCode("70000000");
				resp.setResultMessage(Global.getRetMsg(resp.getResultCode()));
			}
		}else{
			logger.info("----------queryHealthNurse----HealthNurse为null---------------");
			resp.setResultCode("70000000");
			resp.setResultMessage(Global.getRetMsg(resp.getResultCode()));
		}
		logger.info("end queryHealthNurse");
		return resp.getJsonStr();
	}
	

	@RequestMapping(value = "/updateHealthNurse")
	@ResponseBody
	@ApiOperation(value = "修改或添加卫生护士", httpMethod = "POST", notes = "修改或添加卫生护士")
	public String updateHealthNurse(@ApiParam(name = "healthNurse", value = "卫生护士对象") @RequestBody BasHealthNurse healthNurse){
		logger.info("begin updateHealthNurse");
		ResponseValue resp = new ResponseValue();
		int result = basHealthNurseService.updateHealthNurse(healthNurse);
		if(result < 1){
			resp.setResultCode("0");
		}
		logger.info("end updateHealthNurse");
		return resp.getJsonStr();
	}
}
