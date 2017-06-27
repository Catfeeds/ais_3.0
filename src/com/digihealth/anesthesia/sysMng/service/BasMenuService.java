package com.digihealth.anesthesia.sysMng.service;

import java.util.List;
import java.util.Map;


import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.FindAllMenuFormBean;
import com.digihealth.anesthesia.basedata.po.BasDocument;
import com.digihealth.anesthesia.sysMng.formbean.BasMenuFormBean;
import com.digihealth.anesthesia.sysMng.po.BasMenu;
import com.digihealth.anesthesia.common.config.Global;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.persistence.PKEntity;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;

/**
 * 
 * Title: MenuService.java Description: 菜单service
 * 
 * @author chengwang
 * @created 2015-10-7 下午6:01:10
 */
@Service("bsaMenuService")
public class BasMenuService extends BaseService {

	/**
	 * 
	 * @discription 根据角色ID获取菜单
	 * @author chengwang
	 * @created 2015-10-8 下午1:47:27
	 * @param id
	 * @return
	 */
	public List<BasMenu> findAllByRoleId(String id) {
		return basMenuDao.findAllByRoleId(id);
	}

	/**
	 * 
	 * @discription 得到一级二级菜单
	 * @author chengwang
	 * @created 2015-10-9 下午1:59:06
	 * @return
	 */
	public List<BasMenu> findMenu(BasMenu params) {
		return basMenuDao.findMenu(params);
	}

	public List<BasMenu> findMenuByIds(List<String> ids, String roleId, String beid) {
		return basMenuDao.findMenuByIds(ids, roleId, beid);
	}

	public List<FindAllMenuFormBean> findAllMenu() {
		return basMenuDao.findAllMenu();
	}

	public List<BasMenu> findMenuByRoleId(String roleId, String beid) {
		return basMenuDao.findMenuByRoleId(roleId, beid);
	}

//	public List<BasMenuFormBean> selectMenuTree() {
//		return basMenuDao.selectMenuTree();
//	}
	
	public List<BasMenu> findMenuIsLeft() {
		return basMenuDao.findMenuIsLeft();
	}
	
	public List<Map<String, Object>> findMenuThr(BasMenu params) {
		return basMenuDao.findMenuThr(params);
	}

	public BasMenu selectEntityByPrimaryKey(PKEntity<String> pk) {
		return basMenuDao.selectByPrimaryKey(pk.getId(), pk.getBeid());
	}
	
	@SuppressWarnings("unchecked")
	public List<BasMenu> selectEntityList(BasMenu params) {
        return basMenuDao.selectEntityList(params);
    }
	
	@Transactional
	public void insertEntity(BasMenu entity) {
		entity.setId(GenerateSequenceUtil.generateSequenceNo());
		entity.setBeid(super.getBeid());
		basMenuDao.insert(entity);
	}

	@Transactional
	public int updateEntity(BasMenu entity) {
		return basMenuDao.updateByPrimaryKey(entity);
	}
	
	@Transactional
	public int deleteByPrimaryKeyAndBeid(PKEntity<String> pk) {
		pk.setBeid(super.getBeid());
		return basMenuDao.deleteByPrimaryKeyAndBeid(pk);
	}
	
	public List<BasMenuFormBean> selectMenuTree(String beid,String module){
		return basMenuDao.selectMenuTree(beid,module);
	}
	
	/**
	 *删除菜单 
	 */
	@Transactional
	public void delMenu(String id, String beid, ResponseValue resp) {
		List<BasMenu> subMenuList = basMenuDao.findSubMenuById(id, beid);
		// 不是叶子菜单不能删除
		if (null != subMenuList && subMenuList.size() > 0) {
			resp.setResultCode("20000010");
			resp.setResultMessage(Global.getRetMsg("20000010"));
		} else {
			BasMenu menu = basMenuDao.selectByPrimaryKey(id, beid);
			// 菜单存在才去删除，并且从角色拥有的菜单表里删除
			if (null != menu) {
				if (null != menu.getSort()) {
					int sort = menu.getSort().intValue();
					// 通过父id查询出所有的并列菜单，然后重新排序
					List<BasMenu> menuList = basMenuDao.findSubMenuById(menu.getParentId(), menu.getBeid());
					if (null != menuList && menuList.size() > 0) {
						for (int i = 0; i < menuList.size(); i++) {
							// 找到从什么地方开始就都往前摞1
							if (i + 1 > sort && sort != menuList.size()) {
								BasMenu m = menuList.get(i);
								m.setSort(i);
								basMenuDao.updateByPrimaryKeySelective(m);
							}
						}
					}

				}
				basMenuDao.deleteByPrimaryKey(id, beid);
				basRoleMenuDao.deleteByMenuId(id, beid);
			}
		}

	}
	
	@Transactional
	public void addMenu(BasMenu menu) {
		// 通过父id查询出所有的并列菜单
		List<BasMenu> menuList = basMenuDao.findSubMenuById(menu.getParentId(), menu.getBeid());
		if (null != menuList && menuList.size() > 0) {
			menu.setSort(menuList.size() + 1);
		} else {
			menu.setSort(1);
		}
		// 如果菜单被设置为仅目录，菜单权限为空
		if (null != menu.getType() && menu.getType().intValue() == 0) {
			menu.setPermission("");
		}
		if(StringUtils.isBlank(menu.getId())){
			menu.setId(GenerateSequenceUtil.generateSequenceNo());
		}
		if(StringUtils.isBlank(menu.getUrlType())){//前端页面不传递，默认存link
			menu.setUrlType("link");
		}
		if(StringUtils.isBlank(menu.getModule())){//如果前端未传递，则取配置文件中的模块值
			String defModule = Global.getConfig("defModule").toString();
			menu.setModule(defModule);
		}
		basMenuDao.insertSelective(menu);
		// 新增的菜单赋给管理员
		//		BasMenu mn = basMenuDao.selectMenuByName(menu.getName(), menu.getParentId(), menu.getBeid());
		//		if (null != mn) {
		//			BasRoleMenu roleMenu = new BasRoleMenu(mn.getId(), 5, mn.getBeid(), menu.getPermission());
		//			basRoleMenuDao.insertSelective(roleMenu);
		//		}
	}
	
	/**
	 *修改菜单 
	 */
	@Transactional
	public void updateMenu(BasMenu menu) {
		// 判断排序字段是否改变
		BasMenu oldMenu = basMenuDao.selectByPrimaryKey(menu.getId(), menu.getBeid());
		if (null != oldMenu.getSort() && null != menu.getSort()) {
			// 发送改变
			if (oldMenu.getSort().intValue() != menu.getSort().intValue()) {
				int oldSort = oldMenu.getSort().intValue();
				int sort = menu.getSort().intValue();
				// 通过父id查询出所有的并列菜单，然后重新排序
				List<BasMenu> menuList = basMenuDao.findSubMenuById(menu.getParentId(), menu.getBeid());
				if (null != menuList && menuList.size() > 0) {
					for (int i = 0; i < menuList.size(); i++) {
						// 找到原来sort

						// 老值往前移动 找到从什么地方开始就都往后摞1
						if (oldSort > sort && i + 1 >= sort && i + 1 < oldSort) {
							BasMenu m = menuList.get(i);
							m.setSort(i + 2);
							basMenuDao.updateByPrimaryKeySelective(m);
						}

						// 老值向后移动 找到从什么地方开始就都往前摞1
						if (oldSort < sort && i + 1 > oldSort && i + 1 <= sort) {
							BasMenu m = menuList.get(i);
							m.setSort(i);
							basMenuDao.updateByPrimaryKeySelective(m);
						}
					}
				}
			}
		}
		// 如果菜单被设置为仅目录，菜单权限为空
		if (null != menu.getType() && menu.getType().intValue() == 0) {
			menu.setPermission("");
		}
		basMenuDao.updateByPrimaryKeySelective(menu);
	}
	
	public List<BasDocument> getBaseDocumentList(BaseInfoQuery query){
		if(StringUtils.isBlank(query.getBeid())){
			query.setBeid(getBeid());
		}
		return basDocumentDao.searchAllDocumentMenu(query.getBeid());
	}
	
}
