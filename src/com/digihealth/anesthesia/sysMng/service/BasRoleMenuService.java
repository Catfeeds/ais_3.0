package com.digihealth.anesthesia.sysMng.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.sysMng.po.BasRoleMenu;

@Service
public class BasRoleMenuService extends BaseService {

	@Transactional
	public void insertEntity(BasRoleMenu entity) {
		String permission = entity.getPermission();
		entity.setBeid(getBeid());
		if (entity.getMenuId() != null && entity.getRoleId() != null) {
			String[] roles = entity.getRoleId().split(",");
			String[] menus = entity.getMenuId().split(",");
			for (String roleId : roles) {
				for (String menuId : menus) {
					entity.setRoleId(roleId);
					entity.setMenuId(menuId);
					entity.setPermission(null);
					List<BasRoleMenu> list = basRoleMenuDao.selectEntityList(entity);
					if (list.isEmpty() && list.size() == 0) {
						entity.setPermission(permission);
						basRoleMenuDao.insert(entity);
					}
				}
			}
		}
	}

	@Transactional
	public int deleteByPrimaryKey(String menuId, String roleId, String beid) {
		return basRoleMenuDao.deleteByPrimaryKey(menuId, roleId, beid);
	}
}
