package com.digihealth.anesthesia.sysMng.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.sysMng.po.BasUserRole;
import com.digihealth.anesthesia.common.service.BaseService;

@Service
public class BasUserRoleService extends BaseService {

	public List<BasUserRole> selectRoleIdByUsername(String username,String beid){
		return basUserRoleDao.selectRoleIdByUsername(username,beid);
	}

	@Transactional
	public void insertEntity(BasUserRole entity) {
		entity.setBeid(getBeid());
		if (entity.getUserId() != null && entity.getRoleId() != null) {
			String[] roles = entity.getRoleId().split(",");
			for (String roleId : roles) {
				entity.setRoleId(roleId);
				List<BasUserRole> list = basUserRoleDao.selectEntityList(entity);
				if (list.isEmpty() && list.size() == 0) {
					basUserRoleDao.insert(entity);
				}
			}
		}
	}

	@Transactional
	public int deleteByPrimaryKey(String userId, String roleId, String beid) {
		return basUserRoleDao.deleteByPrimaryKey(userId, roleId, beid);
	}
}
