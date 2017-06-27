package com.digihealth.anesthesia.sysMng.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/sys")
public class SysBasSysCodeController extends BaseController {
	
	@RequestMapping(value = "/getDictItemList")
	@ResponseBody
	@ApiOperation(value = "查询字典值", httpMethod = "POST", notes = "通过groupId或者codeValue查询字典值")
	public String getDictItemList(@ApiParam(name = "map", value = "查询对象,groupId不能为空。") @RequestBody Map<String, Object> map) {
		logger.info("--------------start getDictItemList---------------------------");
		ResponseValue resp = new ResponseValue();
		String groupId = null;
		String codeValue = null;
		String beid = null;
		if (null != map.get("groupId")) {
			groupId = map.get("groupId").toString();
		}
		if (null != map.get("codeValue")) {
			codeValue = map.get("codeValue").toString();
		}
		if (null != map.get("beid")) {
			beid = map.get("beid").toString();
		}
		resp.put("dictItemList", basSysCodeService.searchSysCodeByGroupIdAndCodeValue(groupId, codeValue, beid));
		logger.info("--------------end getDictItemList---------------------------");
		return resp.getJsonStr();
	}
	
	
}
