package com.digihealth.anesthesia.sysMng.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.common.beanvalidator.ValidatorBean;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.common.web.BaseController;
import com.digihealth.anesthesia.sysMng.formbean.BasUserFormBean;
import com.digihealth.anesthesia.sysMng.formbean.ChangeUserPasswordFormBean;
import com.digihealth.anesthesia.sysMng.formbean.UserFormbean;
import com.digihealth.anesthesia.sysMng.formbean.UserInfoFormBean;
import com.digihealth.anesthesia.sysMng.po.BasUser;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/sys")
@Api(value = "BasUserController", description = "用户信息处理类")
public class BasUserController extends BaseController {

	@RequestMapping(value = "/searchBasUserById")
	@ResponseBody
	@ApiOperation(value = "根据主键查询用户信息", httpMethod = "POST", notes = "根据主键查询用户信息")
	public String searchBasUserById(@ApiParam(name = "params", value = "系统查询参数") @RequestBody BasUserFormBean params) {
		logger.info("begin searchBasUser");
		Map<String, Object> map = new HashMap<String, Object>();
		params.setBeid(getBeid());
		BasUser entity = basUserService.selectEntityByPrimaryKey(params);
		map.put("resultCode", "1");
		map.put("resultMessage", "查询用户信息成功");
		map.put("entity", entity);
		logger.info("end searchBasUser");
		return JsonType.jsonType(map);
	}

	@RequestMapping(value = "/saveBasUser")
	@ResponseBody
	@ApiOperation(value = "保存用户信息", httpMethod = "POST", notes = "保存用户信息")
	public String saveBasUser(@ApiParam(name = "params", value = "保存参数") @RequestBody BasUser entity) {
		logger.info("begin saveBasUser");
		Map<String, Object> map = new HashMap<String, Object>();
		if (entity.getUserName() != null && entity.getUserName() != "" && entity.getBeid() != null && entity.getBeid() != "") {
			basUserService.updateEntity(entity);
		} else {
			basUserService.insertEntity(entity);
		}
		map.put("resultCode", "1");
		map.put("resultMessage", "保存用户信息成功");
		logger.info("end saveBasUser");
		return JsonType.jsonType(map);
	}

	@RequestMapping(value = "/deleteBasUserById")
	@ResponseBody
	@ApiOperation(value = "根据主键删除用户信息", httpMethod = "POST", notes = "根据主键删除用户信息")
	public String deleteBasUserById(@ApiParam(name = "id", value = "删除参数") @RequestBody BasUser basUser) {
		logger.info("begin deleteBasUser");
		ResponseValue resp = new ResponseValue();
		basUserService.deleteByPrimaryKey(basUser);
		resp.put("resultCode", "1");
		resp.put("resultMessage", "删除用户信息成功");
		logger.info("end deleteBasUser");
		return resp.getJsonStr();
	}
	
	/**
	 * 获取排程人员信息 liukui
	 * 
	 * @param baseQuery
	 * @return
	 */
	@RequestMapping(value = "/getUserList")
	@ResponseBody
	public String getUserList(@RequestBody BaseInfoQuery baseQuery) {
		logger.info("begin getUserList");
		if (baseQuery.getBeid()==null || "".equals(baseQuery.getBeid())) {
			baseQuery.setBeid(getBeid());
		}
		List<BasUser> users = basUserService.getUserList(baseQuery);
		logger.info("end getUserList");
		return JsonType.jsonType(users);
	}

	@RequestMapping(value = "/getAllUser")
	@ResponseBody
	@ApiOperation(value = "根据条件查询用户信息", httpMethod = "POST", notes = "根据条件查询用户信息")
	public String getAllUser(@ApiParam(name = "id", value = "删除参数") @RequestBody UserFormbean userFormbean) {
		logger.info("begin getAllUser");
		ResponseValue resp = new ResponseValue();
		List<BasUser> users = basUserService.getAllUser(userFormbean);
		int total = basUserService.getAllUserTotal(userFormbean);
		resp.put("userItem", users);
		resp.put("total", total);
		resp.setResultCode("1");
		resp.setResultMessage("获取用户成功!");
		logger.info("end getAllUser");
		return resp.getJsonStr();
	}
	
	@RequestMapping(value = "/getuserinf")
	@ResponseBody
	@ApiOperation(value = "查询用户信息列表", httpMethod = "POST", notes = "通过分页机制查询用户信息列表")
	public String getuserinf(@ApiParam(name = "systemSearchFormBean", value = "系统查询传参对象") @RequestBody SystemSearchFormBean systemSearchFormBean) {
		logger.info("begin getuserlist");
		List<BasUserFormBean> resultList = basUserService.queryUserList(systemSearchFormBean);
		int total = basUserService.queryUserListTotal(systemSearchFormBean);
		ResponseValue resp = new ResponseValue();
		resp.put("sysMngUser", resultList);
		resp.put("total", total);
		logger.info("end getuserlist");
		return resp.getJsonStr();
	}

	@RequestMapping(value = "/queryUserById")
	@ResponseBody
	@ApiOperation(value = "查询用户详细信息", httpMethod = "POST", notes = "查询用户详细信息")
	public String queryUserById(@ApiParam(name = "user", value = "用户对象") @RequestBody BasUser user) {
		logger.info("begin queryUserById");
		BasUser resultUser = basUserService.searchUserById(user.getUserName(),user.getBeid());
		// 增加判空
		if (null != resultUser) {
			resultUser.setPassword("");
			resultUser.setSalt("");
			resultUser.setToken("");
		}

		ResponseValue resp = new ResponseValue();
		resp.put("user", resultUser);

		logger.info("end queryUserById");
		return resp.getJsonStr();
	}

	@RequestMapping(value = "/createUser")
	@ResponseBody
	@ApiOperation(value = "新增用户信息", httpMethod = "POST", notes = "新增用户信息")
	public String createUser(@ApiParam(name = "user", value = "用户对象") @RequestBody BasUser user) {
		logger.info("begin createUser");
		ResponseValue req = new ResponseValue();
		BasUser selectUser = basUserService.selectByUsername(user.getUserName(), user.getBeid());
		if (selectUser != null) {
			req.setResultCode("0");
			req.setResultMessage("该账号已存在!");
			return req.getJsonStr();
		}
		basUserService.createUser(user);
		logger.info("end createUser");
		return req.getJsonStr();
	}

	@RequestMapping(value = "/updateUser")
	@ResponseBody
	@ApiOperation(value = "修改用户信息", httpMethod = "POST", notes = "修改用户信息")
	public String updateUser(@ApiParam(name = "user", value = "用户对象") @RequestBody BasUser user) {
		logger.info("begin updateUser");
		ResponseValue req = new ResponseValue();
		basUserService.updateUser(user);
		logger.info("end updateUser");
		return req.getJsonStr();
	}

	@RequestMapping(value = "/searchUserById")
	@ResponseBody
	@ApiOperation(value = "根据id查询用户信息", httpMethod = "POST", notes = "根据id查询用户信息")
	public String searchUserById(@ApiParam(name = "user", value = "用户对象") @RequestBody BasUser user) {
		logger.info("begin searchUserById");
		ResponseValue resp = new ResponseValue();
		String userName = user.getUserName() != null ? user.getUserName() : "0";
		String beid = user.getBeid() != null ? user.getBeid() : getBeid();
		BasUser basUser = basUserService.searchUserById(userName, beid);
		resp.put("resultList", basUser);
		logger.info("end searchUserById");
		return resp.getJsonStr();
	}

	@RequestMapping(value = "/deleteUserById")
	@ResponseBody
	@ApiOperation(value = "根据id删除用户信息", httpMethod = "POST", notes = "根据id删除用户信息")
	public String deleteUserById(@ApiParam(name = "user", value = "用户对象") @RequestBody BasUser user) {
		logger.info("begin deleteUserById");
		ResponseValue resp = new ResponseValue();
		basUserService.delete(user);
		logger.info("end deleteUserById");
		return resp.getJsonStr();
	}

	/**
	 * 术中检查用户账户密码是否正确
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/checkUserLogin")
	@ResponseBody
	@ApiOperation(value = "术中检查用户账户密码是否正确", httpMethod = "POST", notes = "术中检查用户账户密码是否正确")
	public String checkUserLogin(@ApiParam(name = "map", value = "用户对象") @RequestBody Map<String, Object> map) {
		logger.info("-------------------begin checkUserLogin-------------------");
		ResponseValue respValue = basUserService.checkOperateUserInfo(map);
		logger.info("-------------------end checkUserLogin-------------------");
		return respValue.getJsonStr();
	}

	/**
	 * 术中检查用户账户密码是否正确
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/checkPacuUserLogin")
	@ResponseBody
	@ApiOperation(value = "术中检查用户账户密码是否正确", httpMethod = "POST", notes = "术中检查用户账户密码是否正确")
	public String checkPacuUserLogin(@ApiParam(name = "map", value = "用户对象") @RequestBody Map<String, Object> map) {
		logger.info("-------------------begin checkUserLogin-------------------");
		ResponseValue respValue = basUserService.checkPacuOperateUserInfo(map);
		logger.info("-------------------end checkUserLogin-------------------");
		return respValue.getJsonStr();
	}

	@RequestMapping(value = "/getSelectUser")
	@ResponseBody
	@ApiOperation(value = "查询用户", httpMethod = "POST", notes = "查询用户")
	public String getSelectUser(@ApiParam(name = "userFormbean", value = "用户对象") @RequestBody UserFormbean userFormbean) {
		logger.info("-------------------begin getSelectUser-------------------");
		ResponseValue resp = new ResponseValue();
		List<UserInfoFormBean> users = basUserService.getSelectUser(userFormbean);
		resp.put("resultList", users);
		logger.info("-------------------end getSelectUser-------------------");
		return resp.getJsonStr();
	}
	
	/**
	 * 
	 * @discription 修改密码
	 * @author chengwang
	 * @created 2015年11月2日 下午5:10:45
	 * @param changeUserPasswordFormBean
	 * @return
	 */
	@RequestMapping(value = "/changeUserPassword")
	@ResponseBody
	@ApiOperation(value = "修改密码", httpMethod = "POST", notes = "修改用户密码")
	public String changeUserPassword(@ApiParam(name = "changeUserPasswordFormBean", value = "密码修改对象") @RequestBody ChangeUserPasswordFormBean changeUserPasswordFormBean) {
		logger.info("-------------------begin changeUserPassword-------------------");
		ResponseValue resp = new ResponseValue();
		ValidatorBean validatorBean = beanValidator(changeUserPasswordFormBean);
		if (!(validatorBean.isValidator())) {
			resp.setResultCode("10000001");
			resp.setResultMessage(validatorBean.getMessage());
			return resp.getJsonStr();
		}
		basUserService.changeUserPassword(changeUserPasswordFormBean, resp);

		logger.info("-------------------end changeUserPassword-------------------");
		return resp.getJsonStr();
	}

	@RequestMapping(value = "/resetUserPassword")
	@ResponseBody
	@ApiOperation(value = "重置密码", httpMethod = "POST", notes = "重置用户密码")
	public String resetUserPassword(@ApiParam(name = "changeUserPasswordFormBean", value = "密码修改对象") @RequestBody ChangeUserPasswordFormBean changeUserPasswordFormBean) {
		logger.info("-------------------begin resetUserPassword-------------------");
		ResponseValue req = new ResponseValue();
		try {
			basUserService.resetUserPassword(changeUserPasswordFormBean, req);
		} catch (Exception e) {
			req.setResultCode("10000000");
			req.setResultMessage("系统错误，请与系统管理员联系!");
		}

		logger.info("-------------------end resetUserPassword-------------------");
		return req.getJsonStr();
	}
}
