package com.digihealth.anesthesia.sysMng.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.sysMng.formbean.BasUserFormBean;
import com.digihealth.anesthesia.sysMng.formbean.ChangeUserPasswordFormBean;
import com.digihealth.anesthesia.sysMng.formbean.UserFormbean;
import com.digihealth.anesthesia.sysMng.formbean.UserInfoFormBean;
import com.digihealth.anesthesia.sysMng.po.BasRole;
import com.digihealth.anesthesia.sysMng.po.BasUser;
import com.digihealth.anesthesia.sysMng.po.BasUserRole;
import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.SysCodeFormbean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasDispatch;
import com.digihealth.anesthesia.common.config.Global;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.DateUtils;
import com.digihealth.anesthesia.common.utils.EncryptUtil;
import com.digihealth.anesthesia.common.utils.Md5Utils;
import com.digihealth.anesthesia.common.utils.PasswordHelper;
import com.digihealth.anesthesia.common.utils.PingYinUtil;
import com.digihealth.anesthesia.evt.formbean.Filter;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.po.EvtShiftChange;

@Service
public class BasUserService extends BaseService {

	@Autowired
	private PasswordHelper passwordHelper;

	public BasUser selectByUsername(String username, String beid) {
		if (null == beid || "".equals(beid)) {
			beid = basBusEntityDao.getBeid();
		}
		return basUserDao.selectByPrimaryKey(username, beid);
	}

	public List<BasUser> selectEntityList(BasUser params) {
        return basUserDao.selectEntityList(params);
    }

	public BasUser get(String loginName, String beid) {
		if (StringUtils.isEmpty(beid)) {
			beid = getBeid();
		}
		return basUserDao.getByLoginName(loginName, beid);
	}
	
	/**
	 * 根据登录名和基线id查询用户信息
	 * 
	 * @param params
	 * @return
	 */
	public BasUser selectEntityByPrimaryKey(BasUserFormBean params) {
		return basUserDao.selectByPrimaryKey(params.getUserName(), params.getBeid());
	}

	@Transactional
	public int updateUser(BasUser user) {
		if (user.getRoleId() != null) {
			if(StringUtils.isBlank(user.getBeid())){
				user.setBeid(getBeid());
			}
			List<BasUserRole> userRoleList = basUserRoleDao.selectRoleIdByUsername(user.getUserName(), user.getBeid());
			if (userRoleList == null || userRoleList.size() <= 0) {
				BasUserRole userRole = new BasUserRole();
				userRole.setRoleId(user.getRoleId());
				userRole.setUserId(user.getUserName());
				userRole.setBeid(user.getBeid());
				basUserRoleDao.insertUserRole(user.getUserName(), user.getRoleId(), user.getBeid());
			} else {
				basUserRoleDao.updateUserRole(user.getUserName(), user.getRoleId(), user.getBeid());
			}
		}
		
		return basUserDao.updateByPrimaryKeySelective(user);
	}

	@Transactional
	public int updateToken(BasUser user) {
		return basUserDao.updateToken(user);
	}

	@Transactional
	public void insertEntity(BasUser entity) {
		basUserDao.insertSelective(entity);
	}

	@Transactional
	public void updateEntity(BasUser entity) {
		basUserDao.updateByPrimaryKeySelective(entity);
	}

	public List<BasUserFormBean> queryUserList(SystemSearchFormBean systemSearchFormBean) {
		if (StringUtils.isEmpty(systemSearchFormBean.getSort())) {
			systemSearchFormBean.setSort("userType");
		}
		if (StringUtils.isEmpty(systemSearchFormBean.getOrderBy())) {
			systemSearchFormBean.setOrderBy("ASC");
		}
		String filter = "";
		List<Filter> filters = systemSearchFormBean.getFilters();
		if (filters != null && filters.size() > 0) {
			for (int i = 0; i < filters.size(); i++) {
				if (!"starttime".equals(filters.get(i).getField()) && !"endtime".equals(filters.get(i).getField())) {
					if (!StringUtils.isEmpty(filters.get(i).getValue().toString())) {
						filter = filter + " AND u." + filters.get(i).getField() + " like '%" + filters.get(i).getValue() + "%' ";
					}
				}
			}
		}
		String userName = getUserName();
		String operatorAdmin = Global.getConfig("operatorAdmin").toString();
		if (!operatorAdmin.equals(userName)) {
			filter = filter + " AND u.beid = " + systemSearchFormBean.getBeid();
		}
		return basUserDao.queryUserList(filter, systemSearchFormBean);
	}

	public List<UserInfoFormBean> getSelectUser(UserFormbean userFormbean) {
		String sql = "";
		String beid = userFormbean.getBeid();
		if (org.apache.commons.lang.StringUtils.isBlank(beid)) {
			beid = getBeid();
		}
		List<Filter> filters = userFormbean.getFilters();
		if (filters != null && filters.size() > 0) {
			for (int i = 0; i < filters.size(); i++) {
				if(filters.get(i).getField().toString().equals("pinYin")){
					sql = sql
							+ " AND a."
							+ filters.get(i).getField()
							+ " like '%" + PingYinUtil.getFirstSpell(filters.get(i).getValue().toString()) + "%' ";
				}else if(filters.get(i).getField().toString().equals("roleName")){
					List<BasRole> roleList = basRoleDao.searchRoleLikeName(filters.get(i).getValue().toString(), beid);
					if(roleList !=null && roleList.size()>0){
						sql = sql + " AND (";
						for(int j = 0 ; j < roleList.size();j++){
							if(j ==0){
								sql = sql
										+ "  r.id"
										+ " = '" + roleList.get(j).getId() + "' ";
							}else{
								sql = sql
										+ " or r.id"
										+ " = '" + roleList.get(j).getId() + "' ";
							}
							
						}
						sql = sql + " ) ";
					}
					
				}else if(filters.get(i).getField().toString().equals("professionalTitle")||filters.get(i).getField().toString().equals("administrativeLeve")){
					List<SysCodeFormbean> list = null;
					if(filters.get(i).getField().toString().equals("professionalTitle")){
						list = basSysCodeDao.searchSysCodeByGroupIdAndCodeName("professionalTitle", filters.get(i).getValue().toString(), beid);
					}
					if(filters.get(i).getField().toString().equals("administrativeLeve")){
						list = basSysCodeDao.searchSysCodeByGroupIdAndCodeName("executiveLevel", filters.get(i).getValue().toString(), beid);
					}
					
					if(list !=null&&list.size()>0){
						sql = sql + " AND (";
						for(int j = 0 ; j < list.size();j++){
							if(j == 0){
								sql = sql
										+ " a."
										+ filters.get(i).getField()
										+ " = '" + list.get(j).getCodeValue() + "' ";
							}else{
								sql = sql
										+ " or a."
										+ filters.get(i).getField()
										+ " = '" + list.get(j).getCodeValue() + "' ";
							}
							
						}
						sql = sql + " ) ";
						
					}
				}else{
					sql = sql
							+ " AND a."
							+ filters.get(i).getField()
									+ " like '%" + filters.get(i).getValue().toString() + "%' ";
				}
				
			}

		}
		return basUserDao.getSelectUser(sql, beid);
	}

	/**
	 * 
	 * @discription 根据条件查询总数
	 * @author chengwang
	 * @created 2015-10-10 下午12:28:49
	 * @param delFlag
	 * @param start
	 * @param pageSize
	 * @param pinyin
	 * @return
	 */
	public int getAllUserTotal(UserFormbean userFormbean) {
		String sql = "";
		String beid = userFormbean.getBeid();
		if (org.apache.commons.lang.StringUtils.isBlank(beid)) {
			beid = getBeid();
		}
		List<Filter> filters = userFormbean.getFilters();
		if (filters != null && filters.size() > 0) {
			for (int i = 0; i < filters.size(); i++) {
				if(filters.get(i).getField().toString().equals("pinYin")){
					sql = sql
							+ " AND a."
							+ filters.get(i).getField()
							+ " like '%" + filters.get(i).getValue().toString() + "%' ";
				}else if(filters.get(i).getField().toString().equals("roleName")){
					List<BasRole> roleList = basRoleDao.searchRoleLikeName(filters.get(i).getValue().toString(), beid);
					if(roleList !=null && roleList.size()>0){
						sql = sql + " AND (";
						for(int j = 0 ; j < roleList.size();j++){
							if(j ==0){
								sql = sql
										+ "  r.id"
										+ " = '" + roleList.get(j).getId() + "' ";
							}else{
								sql = sql
										+ " or r.id"
										+ " = '" + roleList.get(j).getId() + "' ";
							}
							
						}
						sql = sql + " ) ";
					}
					
				}else if(filters.get(i).getField().toString().equals("professionalTitle")||filters.get(i).getField().toString().equals("administrativeLeve")){
					//List<SysCodeFormbean> list = basSysCodeDao.searchSysCodeByGroupId(StringUtils.zhuanData(filters.get(i).getValue().toString()));
					List<SysCodeFormbean> list = null;
					if(filters.get(i).getField().toString().equals("professionalTitle")){
						list = basSysCodeDao.searchSysCodeByGroupIdAndCodeName("professional_title", filters.get(i).getValue().toString(), beid);
					}
					if(filters.get(i).getField().toString().equals("administrativeLeve")){
						list = basSysCodeDao.searchSysCodeByGroupIdAndCodeName("executive_level", filters.get(i).getValue().toString(), beid);
					}
					
					if(list !=null&&list.size()>0){
						sql = sql + " AND (";
						for(int j = 0 ; j < list.size();j++){
							if(j == 0){
								sql = sql
										+ " a."
										+ filters.get(i).getField()
										+ " = '" + list.get(j).getCodeValue() + "' ";
							}else{
								sql = sql
										+ " or a."
										+ filters.get(i).getField()
										+ " = '" + list.get(j).getCodeValue() + "' ";
							}
							
						}
						sql = sql + " ) ";
						
					}
				}else{
					sql = sql
							+ " AND a."
							+ filters.get(i).getField()
							+ " like '%" + filters.get(i).getValue().toString() + "%' ";
				}
			}

		}
		return basUserDao.getAllUserTotal(sql, beid);
	}
	
	public int queryUserListTotal(SystemSearchFormBean systemSearchFormBean) {
		if (StringUtils.isEmpty(systemSearchFormBean.getSort())) {
			systemSearchFormBean.setSort("userType");
		}
		if (StringUtils.isEmpty(systemSearchFormBean.getOrderBy())) {
			systemSearchFormBean.setOrderBy("ASC");
		}
		String filter = "";
		List<Filter> filters = systemSearchFormBean.getFilters();
		if (filters != null && filters.size() > 0) {
			for (int i = 0; i < filters.size(); i++) {
				if (!StringUtils.isEmpty(filters.get(i).getValue().toString())) {
					filter = filter + " AND u." + filters.get(i).getField() + " like '%" + filters.get(i).getValue() + "%' ";
				}
			}
		}
		String userName = getUserName();
		String operatorAdmin = Global.getConfig("operatorAdmin").toString();
		if (!operatorAdmin.equals(userName)) {
			filter = filter + " AND u.beid = " + systemSearchFormBean.getBeid();
		}
		return basUserDao.queryUserListTotal(filter, systemSearchFormBean);
	}

	public BasUser searchUserById(String username,String beid) {
		if(StringUtils.isBlank(beid)){
			beid = getBeid();
		}
		return basUserDao.searchUserById(username,beid);
	}

	public List<BasUser> getUserList(BaseInfoQuery baseQuery) {
		return basUserDao.getUserList(baseQuery);
	}

	public BasUser searchHnUserById(String id){
		return basUserDao.searchHnUserById(id, getBeid());
	}
	
	/**
	 * 
	 * @discription 获取系统用户
	 * @author chengwang
	 * @created 2015-10-10 下午12:03:24
	 * @param start
	 * @param pageSize
	 * @param pinyin
	 * @return
	 */
	public List<BasUser> getAllUser(UserFormbean userFormbean) {
		String sql = "";
		List<Filter> filters = userFormbean.getFilters();
		if (filters != null && filters.size() > 0) {
			for (int i = 0; i < filters.size(); i++) {
				if(filters.get(i).getField().toString().equals("pinYin")){
					sql = sql
							+ " AND a."
							+ filters.get(i).getField()
							+ " like '%" + PingYinUtil.getFirstSpell(filters.get(i).getValue().toString()) + "%' ";
				}else if(filters.get(i).getField().toString().equals("roleName")){
					List<BasRole> roleList = basRoleDao.searchRoleLikeName(filters.get(i).getValue().toString(), getBeid());
					if(roleList !=null && roleList.size()>0){
						sql = sql + " AND (";
						for(int j = 0 ; j < roleList.size();j++){
							if(j ==0){
								sql = sql
										+ "  r.id"
										+ " = '" + roleList.get(j).getId() + "' ";
							}else{
								sql = sql
										+ " or r.id"
										+ " = '" + roleList.get(j).getId() + "' ";
							}
							
						}
						sql = sql + " ) ";
					}
					
				}else if(filters.get(i).getField().toString().equals("professionalTitle")||filters.get(i).getField().toString().equals("executiveLevel")){
					List<SysCodeFormbean> list = null;
					if(filters.get(i).getField().toString().equals("professionalTitle")){
						list = basSysCodeDao.searchSysCodeByGroupIdAndCodeName("professional_title", filters.get(i).getValue().toString(), getBeid());
					}
					if(filters.get(i).getField().toString().equals("executiveLevel")){
						list = basSysCodeDao.searchSysCodeByGroupIdAndCodeName("executive_level", filters.get(i).getValue().toString(), getBeid());
					}
					
					if(list !=null&&list.size()>0){
						sql = sql + " AND (";
						for(int j = 0 ; j < list.size();j++){
							if(j == 0){
								sql = sql
										+ " a."
										+ filters.get(i).getField()
										+ " = '" + list.get(j).getCodeValue() + "' ";
							}else{
								sql = sql
										+ " or a."
										+ filters.get(i).getField()
										+ " = '" + list.get(j).getCodeValue() + "' ";
							}
							
						}
						sql = sql + " ) ";
						
					}
				}else if(filters.get(i).getField().toString().equals("name"))
				{
					sql = sql + " AND ( a.name like '%" + filters.get(i).getValue().toString() + "%' or a.pinYin like '%" + filters.get(i).getValue().toString() + "%' )";
				}
				else{
					sql = sql
							+ " AND a."
							+ filters.get(i).getField()
									+ " like '%" + filters.get(i).getValue().toString() + "%' ";
				}
				
			}

		}
		return basUserDao.getAllUser(sql,getBeid(),userFormbean.getPageNo() == null ? 0 : userFormbean.getPageNo(),
						userFormbean.getPageSize() == null ? 0 : userFormbean.getPageSize());
	}
	
	@Transactional
	public int createUser(BasUser user) {
		String beid = user.getBeid();
		if(StringUtils.isBlank(user.getBeid())){
			beid = getBeid();
			user.setBeid(beid);
		}
		// 加密密码
		user.setPassword(new Md5Hash("1234").toHex());
		passwordHelper.encryptPassword(user);
		user.setPinYin(PingYinUtil.getFirstSpell(user.getName()));
		user.setCreateUser(getUserName());
		user.setCreateDate(new Date());
		List<BasUserRole> userRoleList = basUserRoleDao.selectByPrimarykey(user.getUserName(), user.getRoleId(), user.getBeid());
		if (userRoleList == null || userRoleList.size() <= 0) {
			BasUserRole userRole = new BasUserRole();
			userRole.setRoleId(user.getRoleId());
			userRole.setUserId(user.getUserName());
			userRole.setBeid(user.getBeid());
			basUserRoleDao.insertUserRole(user.getUserName(), user.getRoleId(), beid);
		}
		return basUserDao.insert(user);
	}

	@Transactional
	public void changeUserPassword(ChangeUserPasswordFormBean changeUserPasswordFormBean, ResponseValue resp) {
		if(StringUtils.isBlank(changeUserPasswordFormBean.getBeid())){
			changeUserPasswordFormBean.setBeid(getBeid());
		}
		BasUser user = basUserDao.searchUserById(changeUserPasswordFormBean.getLoginName(),changeUserPasswordFormBean.getBeid());
		if (user == null) {
			resp.setResultCode("20000001");
			resp.setResultMessage("用户不存在!");
			return;
		}

		String salt = user.getCredentialsSalt();
		
		String md5Pass = Md5Utils.md5ToHex(new Md5Hash(changeUserPasswordFormBean.getPassword()).toHex(), salt, 2);
		if (null == md5Pass || ("").equals(md5Pass) || !user.getPassword().equals(md5Pass)) {
			logger.warn("密码错误, time:" + DateUtils.formatDateTime(new Date()));
			resp.setResultCode("20000002");
			resp.setResultMessage("密码错误");
			return;
		} else {
			String newPass = new Md5Hash(changeUserPasswordFormBean.getNewPassword()).toHex();
			user.setPassword(newPass);
			passwordHelper.encryptPassword(user);
			basUserDao.updateByPrimaryKeySelective(user);
			resp.setResultMessage("修改密码成功!");
			return;
		}
	}

	public ResponseValue checkOperateUserInfo(Map<String, Object> map){
		ResponseValue respValue = new ResponseValue();
		BasUser user1 = selectByUsername(map.get("userName").toString(), map.get("beid") != null ? map.get("beid").toString() : getBeid());
		if (!(user1 != null && EncryptUtil.match(map.get("password").toString(), user1.getPassword()))) {
			if(user1 == null){
				respValue.setResultCode("20000001");
				respValue.setResultMessage("用户名错误！");
				return respValue;
	 		}else{
	 			respValue.setResultCode("20000002");
	 			respValue.setResultMessage("密码错误！");
	 			return respValue;
	 		}
		}
		/**
		 * 根据optType判断用户验证用户类型
		 * 如果为空则验证是否为麻醉医生
		 * opt=NURSE
		 */
		if(map.get("optType") == null || "".equals(map.get("optType"))){
			if(!user1.getUserType().equals("ANAES_DOCTOR")){
				respValue.setResultCode("20000002");
				respValue.setResultMessage("此用户非麻醉医生，不允许提交信息！");
	 			return respValue;
			}
		}
		
		if(map.get("optType").equals("NURSE")){
			if(!user1.getUserType().equals("NURSE")){
				respValue.setResultCode("20000002");
				respValue.setResultMessage("此用户非护士，不允许提交信息！");
	 			return respValue;
			}
		}
		if(map.get("optType").equals("ANAES_DOCTOR")){
			if(!user1.getUserType().equals("ANAES_DOCTOR")){
				respValue.setResultCode("20000002");
				respValue.setResultMessage("此用户非麻醉医生，不允许提交信息！");
	 			return respValue;
			}
		}
		
		//如果传入的docId不为空则需要验证交接班人员信息
		if(map.get("regOptId") !=null && !"".equals(map.get("regOptId"))){
			String docId = docAnaesRecordDao.searchAnaesRecordByRegOptId(map.get("regOptId").toString()).getAnaRecordId();
			SearchFormBean searchBean = new SearchFormBean();
			searchBean.setDocId(docId);
			List<EvtShiftChange> shiftList = evtShiftChangeDao.getAllShiftChangeList(searchBean);
			//对交接班信息表中的数据进行比对
			if(shiftList.size()>0){
				EvtShiftChange shift = shiftList.get(shiftList.size()-1);
				if(!shift.getShiftChangePeopleId().equals(user1.getUserName())){
					respValue.setResultCode("20000003");
		 			respValue.setResultMessage("最后一次交接班人员信息与此用户信息不符，请核查！");
		 			return respValue;
				}
			}else{//无交接班信息时，取排班表中的麻醉医生信息进行核实
				BasDispatch disPatch = basDispatchDao.getDispatchOper(map.get("regOptId").toString());
				if(!user1.getUserName().toString().equals(disPatch.getAnesthetistId())){
					respValue.setResultCode("20000003");
		 			respValue.setResultMessage("最后一次交接班人员信息与此用户信息不符，请核查！");
		 			return respValue;
				}
			}
		}
		
		if(user1!=null){
			respValue.put("id", user1.getUserName());
			respValue.put("name", user1.getName());
		}
		return respValue;
	}

	public ResponseValue checkPacuOperateUserInfo(Map<String, Object> map){
		ResponseValue respValue = new ResponseValue();
		BasUser user1 = selectByUsername(map.get("userName").toString(), map.get("beid") != null ? map.get("beid").toString() : getBeid());
		if (!(user1 != null && EncryptUtil.match(map.get("password").toString(), user1.getPassword()))) {
			if(user1 == null){
				respValue.setResultCode("20000001");
				respValue.setResultMessage("用户名错误！");
				return respValue;
	 		}else{
	 			respValue.setResultCode("20000002");
	 			respValue.setResultMessage("密码错误！");
	 			return respValue;
	 		}
		}
		if(user1!=null){
			respValue.put("id", user1.getUserName());
			respValue.put("name", user1.getName());
		}
		return respValue;
	}
	
	@Transactional
	public void resetUserPassword(ChangeUserPasswordFormBean changeUserPasswordFormBean, ResponseValue resp) {
		if(StringUtils.isBlank(changeUserPasswordFormBean.getBeid())){
			changeUserPasswordFormBean.setBeid(getBeid());
		}
		BasUser user = basUserDao.selectByPrimaryKey(changeUserPasswordFormBean.getLoginName(), changeUserPasswordFormBean.getBeid());
		if (user == null) {
			resp.setResultCode("20000001");
			resp.setResultMessage("用户不存在!");
			return;
		}
		String newPassword = new Md5Hash("1234").toHex();
		user.setPassword(newPassword);
		passwordHelper.encryptPassword(user);
		basUserDao.updateByPrimaryKeySelective(user);
		return;
	}

	/**
	 * 获取Key加载信息
	 */
	public static boolean printKeyLoadMessage() {
		StringBuilder sb = new StringBuilder();
		sb.append("\r\n======================================================================\r\n");
		sb.append("\r\n    欢迎使用 " + Global.getConfig("productName")
				+ "  - Powered By http://digihealth.com\r\n");
		sb.append("\r\n======================================================================\r\n");
		System.out.println(sb.toString());
		return true;
	}
	
	@Transactional
	public void deleteByPrimaryKey(BasUser basUser) {
		basUserDao.deleteByPrimaryKey(basUser.getUserName(), StringUtils.isNotBlank(basUser.getBeid()) ? basUser.getBeid() : getBeid());
	}

	@Transactional
	public int delete(BasUser user){
		if (StringUtils.isBlank(user.getBeid())) {
			user.setBeid(getBeid());
		}
		return basUserDao.delete(user);
	}

	public void checkUserById(ResponseValue respValue, String id, String password) {
		if (null == password) {
			respValue.setResultCode("20000002");
			respValue.setResultMessage("密码错误！");
			return;
		}

		if (StringUtils.isBlank(id)) {
			respValue.setResultCode("20000001");
			respValue.setResultMessage("用户名错误！");
			return;
		}

		BasUser user = basUserDao.searchUserById(id, getBeid());
		if(user ==null){
			respValue.setResultCode("20000001");
			respValue.setResultMessage("用户名错误！");
		}else{
			String pass = user.getPassword();//当前用户的密码
			String credentialsSalt = user.getCredentialsSalt();//当前用户的（用户名+盐）
			String md5ToHex = Md5Utils.md5ToHex(password, credentialsSalt, 2); //求得返回的密码
			if(!md5ToHex.equals(pass)){//比对
				respValue.setResultCode("20000002");
				respValue.setResultMessage("密码错误！");
			}
		}
	}
}
