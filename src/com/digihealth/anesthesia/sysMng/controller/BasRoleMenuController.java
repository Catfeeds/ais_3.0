package com.digihealth.anesthesia.sysMng.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.sysMng.po.BasRoleMenu;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/sys")
@Api(value="BasRoleMenuController",description="菜单权限处理类")
public class BasRoleMenuController extends BaseController {

	@RequestMapping(value = "/saveBasRoleMenu")
	@ResponseBody
	@ApiOperation(value="保存菜单权限",httpMethod="POST",notes="保存菜单权限")
	public String saveBasRoleMenu(@ApiParam(name="params", value ="保存参数") @RequestBody BasRoleMenu entity) {
		logger.info("begin saveBasRoleMenu");
		ResponseValue res = new ResponseValue();
		basRoleMenuService.insertEntity(entity);
		res.setResultCode("1");
		res.setResultMessage("保存菜单权限成功");
		logger.info("end saveBasRoleMenu");
		return res.getJsonStr();
	}

	@RequestMapping(value = "/deleteBasRoleMenu")
	@ResponseBody
	@ApiOperation(value="删除菜单权限",httpMethod="POST",notes="删除菜单权限")
	public String deleteBasRoleMenu(@ApiParam(name="params", value ="删除参数") @RequestBody BasRoleMenu entity) {
		logger.info("begin deleteBasRoleMenu");
		ResponseValue res = new ResponseValue();
		basRoleMenuService.deleteByPrimaryKey(entity.getMenuId(), entity.getRoleId(), getBeid());
		res.setResultCode("1");
		res.setResultMessage("删除菜单权限成功");
		logger.info("end deleteBasRoleMenu");
		return res.getJsonStr();
	}
}
