/*
 * BasUserRoleDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-23 Created
 */
package com.digihealth.anesthesia.sysMng.dao;

import java.util.List;

import com.digihealth.anesthesia.sysMng.po.BasUserRole;
import com.digihealth.anesthesia.common.persistence.CrudDao;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

import org.apache.ibatis.annotations.Param;

@MyBatisDao
public interface BasUserRoleDao extends CrudDao<BasUserRole>{
    int deleteByPrimaryKey(@Param("userId") String userId, @Param("roleId") String roleId, @Param("beid") String beid);

	List<BasUserRole> selectEntityList(BasUserRole params);
	
	int insert(BasUserRole entity);
	
    int insertSelective(BasUserRole record);

	public void insertUserRole(@Param("userId")String userId,@Param("roleId")String roleId, @Param("beid") String beid);
	
    List<BasUserRole> selectRoleIdByUsername(@Param("username")String username,@Param("beid")String beid);
    
    int updateByPrimaryKeySelective(@Param("username")String username,@Param("roleId")String roleId,@Param("beid")String beid);
    
    List<BasUserRole> selectByPrimarykey(@Param("userName")String userName,@Param("roleId")String roleId,@Param("beid")String beid);

	public int updateUserRole(@Param("userName") String userName,@Param("roleId") String roleId,@Param("beid")String beid);
}