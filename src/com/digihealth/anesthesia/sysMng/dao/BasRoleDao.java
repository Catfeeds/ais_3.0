/*
 * BasRoleDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-23 Created
 */
package com.digihealth.anesthesia.sysMng.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.sysMng.formbean.BasRoleFormBean;
import com.digihealth.anesthesia.sysMng.formbean.CheckButtonPermission;
import com.digihealth.anesthesia.sysMng.formbean.MenuSelectByRoleId;
import com.digihealth.anesthesia.sysMng.formbean.RoleSelectMenuFormBean;
import com.digihealth.anesthesia.sysMng.po.BasRole;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.common.persistence.CrudDao;
import com.digihealth.anesthesia.common.persistence.PKEntity;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface BasRoleDao extends CrudDao<BasRole>{
	List<BasRole> selectEntityList(BasRoleFormBean params);

	public BasRole getByName(BasRole role, @Param("beid")String beid);
	
	public BasRole getByEnname(BasRole role, @Param("beid")String beid);

	/**
	 * 维护角色与菜单权限关系
	 * @param role
	 * @return
	 */
	public int deleteRoleMenu(BasRole role);

	public int insertRoleMenu(BasRole role);
	
	
	/**
	 * 维护角色与公司部门关系
	 * @param role
	 * @return
	 */
	public int deleteRoleOffice(BasRole role);

	public int insertRoleOffice(BasRole role);
	
	public List<BasRole> findListRole(@Param("loginName") String loginName, @Param("beid")String beid);
	
	public List<BasRole> findList(BasRole entity, @Param("beid")String beid);
	
	public List<BasRole> findAllList(@Param("filter")String filter, @Param("systemSearchFormBean") SystemSearchFormBean systemSearchFormBean);

	public int findAllListTotal(@Param("filter")String filter, @Param("systemSearchFormBean") SystemSearchFormBean systemSearchFormBean);
	
	public List<MenuSelectByRoleId> searchMenuByRoleId(@Param("roleId") String roleId, @Param("beid")String beid) ;
	
	public List<BasRole> getAllRoleByDelFlag(@Param("beid")String beid);
	
	public List<RoleSelectMenuFormBean> selectRoleSelectMenuByRoleId(@Param("roleId")String roleId);
	
	BasRole selectByPrimaryKeyAndBeid(PKEntity<String> primaryKey);
	
	int insert(BasRole entity);
	
    int insertSelective(BasRole record);

    int updateByPrimaryKey(BasRole entity);
    
    int updateByPrimaryKeySelective(BasRole record);

    int deleteByPrimaryKeyAndBeid(PKEntity<String> pk);
    
    public List<BasRole> queryRoleList(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);
    
    public int queryRoleListTotal(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);
    
    public List<BasRole> getRoleOrderbyId(@Param("beid")String beid);
    
	public List<BasRole> searchRoleLikeName(@Param("name")String name, @Param("beid")String beid);
	
	public BasRole searchRoleById(@Param("id")String id, @Param("beid") String beid);
	
	public List<RoleSelectMenuFormBean> selectRoleSelectMenuByRoleId(@Param("roleId")String roleId, @Param("beid") String beid,@Param("module")String module);
	
	//对比菜单和角色菜单拥有的button权限对象
	public List<CheckButtonPermission> selectRoleSelectButtonByRoleId(@Param("roleId")String roleId, @Param("beid") String beid,@Param("module")String module);

	public List<CheckButtonPermission> selectNewRoleSelectButton(@Param("beid") String beid, @Param("module")String module);
}