package com.digihealth.anesthesia.sysMng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.sysMng.po.BasUserRole;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/sys")
@Api(value="BasUserRoleController",description="用户权限处理类")
public class BasUserRoleController extends BaseController {

	@RequestMapping(value = "/saveBasUserRole")
	@ResponseBody
	@ApiOperation(value="保存用户权限",httpMethod="POST",notes="保存用户权限")
	public String saveBasUserRole(@ApiParam(name="params", value ="保存参数") @RequestBody BasUserRole entity) {
		logger.info("begin saveBasUserRole");
		ResponseValue res = new ResponseValue();
		basUserRoleService.insertEntity(entity);
		res.setResultCode("1");
		res.setResultMessage("保存用户权限成功");
		logger.info("end saveBasUserRole");
		return res.getJsonStr();
	}

	@RequestMapping(value = "/deleteBasUserRole")
	@ResponseBody
	@ApiOperation(value="删除用户权限",httpMethod="POST",notes="删除用户权限")
	public String deleteBasMenuById(@ApiParam(name="params", value ="删除参数") @RequestBody BasUserRole entity) {
		logger.info("begin deleteBasUserRole");
		ResponseValue res = new ResponseValue();
		basUserRoleService.deleteByPrimaryKey(entity.getUserId(), entity.getRoleId(), getBeid());
		res.setResultCode("1");
		res.setResultMessage("删除用户权限成功");
		logger.info("end deleteBasUserRole");
		return res.getJsonStr();
	}
}
