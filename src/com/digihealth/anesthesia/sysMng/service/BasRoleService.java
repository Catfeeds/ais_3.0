package com.digihealth.anesthesia.sysMng.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.formbean.SysCodeFormbean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.common.config.Global;
import com.digihealth.anesthesia.common.persistence.PKEntity;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.evt.formbean.Filter;
import com.digihealth.anesthesia.sysMng.formbean.BasMenuFormBean;
import com.digihealth.anesthesia.sysMng.formbean.BasRoleFormBean;
import com.digihealth.anesthesia.sysMng.formbean.ButtonPermission;
import com.digihealth.anesthesia.sysMng.formbean.CheckButtonPermission;
import com.digihealth.anesthesia.sysMng.formbean.MenuFormBean;
import com.digihealth.anesthesia.sysMng.formbean.MenuSelectByRoleId;
import com.digihealth.anesthesia.sysMng.formbean.RoleSelectMenuFormBean;
import com.digihealth.anesthesia.sysMng.formbean.UpdateRoleMenuFormBean;
import com.digihealth.anesthesia.sysMng.po.BasRole;
import com.digihealth.anesthesia.sysMng.po.BasRoleMenu;

@Service
public class BasRoleService extends BaseService {

	public List<BasRole> selectEntityList(BasRoleFormBean params) {
		return basRoleDao.selectEntityList(params);
	}

	public BasRole selectByPrimaryKeyAndBeid(PKEntity<String> pk) {
		return basRoleDao.selectByPrimaryKeyAndBeid(pk);
	}

	public List<BasRole> findList(String  loginName) {
		return basRoleDao.findListRole(loginName, getBeid());
	}
	
	/**
	 * 
	     * @discription 查询角色接口
	     * @author chengwang       
	     * @created 2015年11月4日 上午10:57:58     
	     * @return
	 */
	public List<BasRole> findAllList(SystemSearchFormBean systemSearchFormBean){
		if (StringUtils.isEmpty(systemSearchFormBean.getSort())) {
			systemSearchFormBean.setSort("name");
		}
		if (StringUtils.isEmpty(systemSearchFormBean.getOrderBy())) {
			systemSearchFormBean.setOrderBy("ASC");
		}
		if (StringUtils.isEmpty(systemSearchFormBean.getBeid())) {
			systemSearchFormBean.setBeid(getBeid());
		}

		String filter = "";
		List<Filter> filters = systemSearchFormBean.getFilters();
		if (filters != null && filters.size() > 0) {
			for (int i = 0; i < filters.size(); i++) {
				if (!StringUtils.isEmpty(filters.get(i).getValue().toString())) {
					if("menuName".equals(filters.get(i).getField())) {
						filter += "";
					}else {
						filter += " AND a." + filters.get(i).getField() + " like '%" + filters.get(i).getValue() + "%' ";
					}
				}
			}
		}
		return basRoleDao.findAllList(filter, systemSearchFormBean);
	}

	public int findAllListTotal(SystemSearchFormBean systemSearchFormBean){
		if (StringUtils.isEmpty(systemSearchFormBean.getBeid())) {
			systemSearchFormBean.setBeid(getBeid());
		}

		String filter = "";
		List<Filter> filters = systemSearchFormBean.getFilters();
		if (filters != null && filters.size() > 0) {
			for (int i = 0; i < filters.size(); i++) {
				if (!StringUtils.isEmpty(filters.get(i).getValue().toString())) {
					if("menuName".equals(filters.get(i).getField())) {
						filter += "";
					}else {
						filter += " AND a." + filters.get(i).getField() + " like '%" + filters.get(i).getValue() + "%' ";
					}
				}
			}
		}
		return basRoleDao.findAllListTotal(filter, systemSearchFormBean);
	}
	
	@Transactional
	public void insertEntity(BasRole entity) {
		entity.setId(GenerateSequenceUtil.generateSequenceNo());
		entity.setBeid(super.getBeid());
		basRoleDao.insert(entity);
	}

	@Transactional
	public int updateEntity(BasRole entity) {
		entity.setBeid(super.getBeid());
		return basRoleDao.updateByPrimaryKey(entity);
	}

	@Transactional
	public int deleteByPrimaryKeyAndBeid(PKEntity<String> pk) throws Exception {
		pk.setBeid(getBeid());
		// Integer total = basRoleDao.isCanDeleteEntity(pk);
		// if (total > 0) {
		// throw new Exception("该权限存在关联数据，不能删除。");
		// }
		return basRoleDao.deleteByPrimaryKeyAndBeid(pk);
	}

	public List<BasRole> queryRoleList(SystemSearchFormBean systemSearchFormBean) {
		if (StringUtils.isEmpty(systemSearchFormBean.getSort())) {
			systemSearchFormBean.setSort("id");
		}
		if (StringUtils.isEmpty(systemSearchFormBean.getOrderBy())) {
			systemSearchFormBean.setOrderBy("ASC");
		}
		String filter = "";
		List<Filter> filters = systemSearchFormBean.getFilters();
		if (filters != null && filters.size() > 0) {
			for (int i = 0; i < filters.size(); i++) {
				if (!StringUtils.isEmpty(filters.get(i).getValue().toString())) {
					if("beName".equals(filters.get(i).getField())) {
						filter += " AND b.`name` LIKE '%" + filters.get(i).getValue() + "%'";
					}else {
						filter += " AND t." + filters.get(i).getField() + " like '%" + filters.get(i).getValue() + "%' ";
					}
				}
			}
		}
		String operatorAdmin = Global.getConfig("operatorAdmin").toString();
		if (!operatorAdmin.equals(getUserName())) {
			filter = filter + " AND t.beid = " + systemSearchFormBean.getBeid();
		}

		return basRoleDao.queryRoleList(filter, systemSearchFormBean);
	}

	public int queryRoleListTotal(SystemSearchFormBean systemSearchFormBean) {
		if (StringUtils.isEmpty(systemSearchFormBean.getSort())) {
			systemSearchFormBean.setSort("id");
		}
		if (StringUtils.isEmpty(systemSearchFormBean.getOrderBy())) {
			systemSearchFormBean.setOrderBy("ASC");
		}
		String filter = "";
		List<Filter> filters = systemSearchFormBean.getFilters();
		if (filters != null && filters.size() > 0) {
			for (int i = 0; i < filters.size(); i++) {
				if (!StringUtils.isEmpty(filters.get(i).getValue().toString())) {
					if("beName".equals(filters.get(i).getField())) {
						filter += " AND b.`name` LIKE '%" + filters.get(i).getValue() + "%'";
					}else {
						filter += " AND t." + filters.get(i).getField() + " like '%" + filters.get(i).getValue() + "%' ";
					}
				}
			}
		}

		String operatorAdmin = Global.getConfig("operatorAdmin").toString();
		if (!operatorAdmin.equals(getUserName())) {
			filter = filter + " AND beid = " + systemSearchFormBean.getBeid();
		}
		return basRoleDao.queryRoleListTotal(filter, systemSearchFormBean);
	}
	
	@Transactional
	public void updateRole(UpdateRoleMenuFormBean bean){
		BasRole role = bean.getRole();
		String beid = role.getBeid();
		if(StringUtils.isEmpty(beid)) {
			beid = getBeid();
			role.setBeid(beid);
		}
		role.setDescription(bean.getRole().getName());
		List<MenuFormBean> menuList = bean.getRoleMenus();
		if(role != null && StringUtils.isNotBlank(role.getId())){
			if(menuList!=null && menuList.size()>0){
				basRoleMenuDao.deleteByRoleId(role.getId(), bean.getModule(), beid);
				for(int i = 0 ; i < menuList.size();i++){
//					if(menuList.get(i).getChecked()){
						String permission = menuList.get(i).getPermission();
						BasRoleMenu roleMenu = new BasRoleMenu(menuList.get(i).getId(),role.getId(),beid,permission);
						basRoleMenuDao.insertSelective(roleMenu);
//					}
				}
			}
			basRoleDao.updateByPrimaryKeySelective(role);
		}else{
			role.setId(GenerateSequenceUtil.generateSequenceNo());
			if(menuList!=null && menuList.size()>0){
				basRoleMenuDao.deleteByRoleId(role.getId(), bean.getModule(), getBeid());
				for(int i = 0 ; i < menuList.size();i++){
//					if(menuList.get(i).getChecked()){
						String permission = menuList.get(i).getPermission();
						BasRoleMenu roleMenu = new BasRoleMenu(menuList.get(i).getId(),role.getId(),beid,permission);
						basRoleMenuDao.insertSelective(roleMenu);
//					}
				}
			}
			basRoleDao.insert(role);
		}
	}
	
	public BasRole searchRoleById(String id, String beid) {
		if (StringUtils.isBlank(beid)) {
			beid = getBeid();
		}
		return basRoleDao.searchRoleById(id, beid);
	}
	
	public List<RoleSelectMenuFormBean> selectRoleSelectMenuByRoleId(String roleId,String beid,String module){
		if(StringUtils.isBlank(module)){
			module = Global.getConfig("defModule").toString();
		}
		if (StringUtils.isBlank(beid)) {
			beid = getBeid();
		}
		return basRoleDao.selectRoleSelectMenuByRoleId(roleId,beid,module);
	}
	
	public Map<String, List<ButtonPermission>> getButtonPermissionList(String roleId, String beid,String module) {
		Map<String, List<ButtonPermission>> map = new HashMap<String, List<ButtonPermission>>();
		if(StringUtils.isBlank(module)){
			module = Global.getConfig("defModule").toString();
		}
		List<CheckButtonPermission> checkPerimissionList = new ArrayList<CheckButtonPermission>();
		if (StringUtils.isNoneBlank(roleId)) {
			checkPerimissionList = basRoleDao.selectRoleSelectButtonByRoleId(roleId, beid,module);
		}else {
			checkPerimissionList = basRoleDao.selectNewRoleSelectButton(beid, module);
		}
		List<SysCodeFormbean> sysCodeList = basSysCodeDao.searchSysCodeByGroupIdAndCodeValue("page_authority", null, beid);

		Map<String, String> dictMap = new HashMap<String, String>();
		if (null != sysCodeList && sysCodeList.size() > 0) {
			for (SysCodeFormbean sysCode : sysCodeList) {
				dictMap.put(sysCode.getCodeValue(), sysCode.getCodeName());
			}
		}

		if (null != checkPerimissionList && checkPerimissionList.size() > 0) {
			for (CheckButtonPermission cbp : checkPerimissionList) {
				List<ButtonPermission> bpList = new ArrayList<ButtonPermission>();
				String menuId = String.valueOf(cbp.getId());
				String permission = cbp.getPermission();
				String permission2 = cbp.getPermission2();
				String[] mpm = null;
				String[] rpm = null;
				if (StringUtils.isNotBlank(permission)) {
					mpm = permission.split(",");
				}
				if (StringUtils.isNotBlank(permission2)) {
					rpm = permission2.split(",");
				}

				if (null != mpm && mpm.length > 0) {
					for (int i = 0; i < mpm.length; i++) {
						ButtonPermission buttonPermission = new ButtonPermission();
						Boolean check = false;
						String perm = mpm[i].trim();
						if (null != rpm && rpm.length > 0) {
							for (int j = 0; j < rpm.length; j++) {
								String perm2 = rpm[j].trim();
								if (perm.equals(perm2)) {
									check = true;
									break;
								}
							}
						}
						buttonPermission.setId(perm);
						buttonPermission.setName(dictMap.get(perm));
						buttonPermission.setCheck(check);

						bpList.add(buttonPermission);
					}

				}
				map.put(menuId, bpList);
			}
		}
		return map;
	}

	public BasRole searchRoleById(String id){
		return basRoleDao.searchRoleById(id, getBeid());
	}
	
	public List<RoleSelectMenuFormBean> selectRoleSelectMenuByRoleId(String roleId){
		return basRoleDao.selectRoleSelectMenuByRoleId(roleId);
	}
	
	public List<MenuSelectByRoleId> searchMenuByRoleId(String roleId){
		return basRoleDao.searchMenuByRoleId(roleId, getBeid());
	}
	
	public List<BasRole> getAllRoleByDelFlag(){
		return basRoleDao.getAllRoleByDelFlag(getBeid());
	}
	
	@Transactional
	public void delete(BasRole role){
		basRoleDao.delete(role);
	}
}
