package com.digihealth.anesthesia.sysMng.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digihealth.anesthesia.sysMng.formbean.BasMenuFormBean;
import com.digihealth.anesthesia.sysMng.po.BasMenu;
import com.digihealth.anesthesia.basedata.po.BasOperateLog;
import com.digihealth.anesthesia.sysMng.po.BasUser;
import com.digihealth.anesthesia.sysMng.po.BasUserRole;
import com.digihealth.anesthesia.sysMng.service.BasMenuService;
import com.digihealth.anesthesia.basedata.utils.UserUtils;
import com.digihealth.anesthesia.common.config.Global;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.jwt.JwtUtils;
import com.digihealth.anesthesia.common.utils.CacheUtils;
import com.digihealth.anesthesia.common.utils.DateUtils;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.common.utils.Md5Utils;
import com.digihealth.anesthesia.common.utils.PasswordHelper;
import com.digihealth.anesthesia.common.web.BaseController;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/sys")
@Api(value="LoginController",description="登录登出处理类")
public class LoginController extends BaseController {
	@Autowired
	private BasMenuService basMenuService;

	@Autowired
	private PasswordHelper passwordHelper;
	
	@RequestMapping(value = "/login")
	@ResponseBody
	@ApiOperation(value = "登录", httpMethod = "POST", notes = "登录处理方法，需要前台传用户名、密码、局点参数")
	public String login(@ApiParam(name = "username", value = "用户名") @RequestParam("username") String username, @ApiParam(name = "password", value = "密码") @RequestParam("password") String password) {
		logger.info("-------------begin login-----------------");
		String error = null;
		ResponseValue resp = new ResponseValue();

		String operatorAdmin = Global.getConfig("operatorAdmin").trim();
		String operatorBeid = Global.getConfig("operatorBeid").trim();
		String beid = "";
		UserUtils.getByLoginName(username);
		// 如果是运营平台管理员
		if (operatorAdmin.equals(username)) {
			beid = operatorBeid;
		} else {
			// 查询当前使用的局点id
			beid = basBusEntityService.getBeid();
		}
		BasUser user = basUserService.selectByUsername(username, beid);

		if (null == user) {
			error = "用户名错误";
			logger.warn(error + ", time:" + DateUtils.formatDateTime(new Date()));
			resp.setResultCode("20000001");
			resp.setResultMessage(error);
			return resp.getJsonStr();
		}

		if (user.getEnable() != 1) {
			error = "当前账户已失效";
			logger.warn(error + ", time:" + DateUtils.formatDateTime(new Date()));
			resp.setResultCode("20000008");
			resp.setResultMessage(error);
			return resp.getJsonStr();
		}

		List<BasUserRole> userRoleList = basUserRoleService.selectRoleIdByUsername(username, beid);
		if (userRoleList == null || userRoleList.size() <= 0) {
			error = "当前账户没有权限访问";
			logger.warn(error + ", time:" + DateUtils.formatDateTime(new Date()));
			resp.setResultCode("20000009");
			resp.setResultMessage(error);
			return resp.getJsonStr();
		}

		// 根据用户名查询当天错误登录记录
		// List<BasOperateLog> sysErrorList =
		// basOperateLogService.selectLogionRecordByUserName(username,beid);

		// 记录到用户登录记录表
		BasOperateLog basOperateLog = new BasOperateLog();
		basOperateLog.setId(GenerateSequenceUtil.generateSequenceNo());
		basOperateLog.setOperName(username);
		basOperateLog.setOperId(username);
		basOperateLog.setOperTime(new Date());
		basOperateLog.setIsError(0);
		basOperateLog.setChannel("1");
		basOperateLog.setBeid(beid);

		String salt = user.getCredentialsSalt();
		String md5Pass = Md5Utils.md5ToHex(password, salt, 2);
		if (StringUtils.isBlank(md5Pass) || !user.getPassword().equals(md5Pass)) {
			basOperateLog.setIsError(1);
			resp.setResultCode("20000001");
			resp.setResultMessage("用户名或密码错误！");
			basOperateLog.setOperContents("用户名或密码错误！");
			basOperateLogService.addSysLogionLog(basOperateLog);
			return resp.getJsonStr();
		}

		// 保存到用户登录记录表
		basOperateLogService.addSysLogionLog(basOperateLog);

		// 获得私密
		String secretKey = Global.getConfig("secretKey").trim();
		long ttlMillis = Long.parseLong(Global.getConfig("ttlMillis").trim());// 从配置文件中获取过期时间
		// 生成subject
		String subject = JwtUtils.generalSubject(user);
		// 生成token
		String token = JwtUtils.createJWT(subject, ttlMillis, secretKey);

		// 设置新生成token，传递给页面
		user.setToken(token);

		BasUser user1 = new BasUser();
		user1.setToken(token);
		user1.setUserName(user.getUserName());
		user1.setBeid(beid);
		basUserService.updateUser(user1);

		UserUtils.setUserCache(user);

		// 缓存中存入token
		String key = JwtUtils.getKey(username, beid);
		CacheUtils.put(key, token);

		// 清空敏感信息
		user.setPassword("");
		user.setSalt("");

		BasUser user2 = UserUtils.getUserCache();
		BasMenuFormBean params = new BasMenuFormBean();
		params.setEnable(1);
		params.setBeid(beid);
		List<BasMenu> menus = basMenuService.findMenu(params);
		List<String> ids = new ArrayList<String>();
		for (int i = 0; i < menus.size(); i++) {
			ids.add(menus.get(i).getId());
		}

//		List<BasMenu> menusAll = basMenuService.selectEntityList(params);
		List<BasMenu> menuList = basMenuService.findMenuByRoleId(user2.getRoleId(), beid);
		String urlString = "";
		if (menuList != null && menuList.size() > 0) {
			for (int i = 0; i < menuList.size(); i++) {
				urlString = urlString + menuList.get(i).getUrl() + ",";
			}
		}
		resp.setResultCode("1");
		resp.setResultMessage("登录成功!");
		resp.put("urlString", urlString);
		resp.put("user", user2);
		resp.put("menus", menuList);

		logger.info("----------------end login------------------");
		return resp.getJsonStr();
	}

	@RequestMapping("/logout")
	@ResponseBody
	@ApiOperation(value = "登出", httpMethod = "POST", notes = "登出处理方法，需要前台传用户名、局点参数")
	public String logout(@ApiParam(name = "username", value = "用户名") @RequestParam("username") String username) {
		logger.info("-----------------start logout---------------------");
		String beid = request.getHeader("beid");
		ResponseValue resp = new ResponseValue();
		String error = null;
		if (null == beid || StringUtils.isBlank(beid)) {
			error = "beid不能为空";
			resp.setResultCode("20000001");
			resp.setResultMessage(error);
			return resp.getJsonStr();
		}
		BasUser user = basUserService.selectByUsername(username, beid);
		if (null == user) {
			error = "用户名错误";
			logger.warn(error + ", time:" + DateUtils.formatDateTime(new Date()));
			resp.setResultCode("20000001");
			resp.setResultMessage(error);
			return resp.getJsonStr();
		}

		if (null != user) {
			// 把token清理
			user.setToken(null);
			basUserService.updateToken(user);
			// 把缓存清理
			UserUtils.clearCache(user);
			// 清空缓存中token
			String key = JwtUtils.getKey(username, beid);
			CacheUtils.remove(key);
		}

		resp.setResultCode("1");
		resp.setResultMessage("处理成功");
		logger.info("-----------------end logout---------------------");
		return resp.getJsonStr();
	}
	
	public static void main(String[] args) {
		String pass = new Md5Hash("1234").toHex();
		RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

		String salt = "chengw" + randomNumberGenerator.nextBytes().toHex();
		System.out.println("salt=" + salt);
		String newPassword = Md5Utils.md5ToHex(pass, salt, 2);

		System.out.println("---------" + newPassword);
	}


}
