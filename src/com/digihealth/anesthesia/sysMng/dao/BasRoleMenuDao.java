/*
 * BasRoleMenuDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-23 Created
 */
package com.digihealth.anesthesia.sysMng.dao;

import java.util.List;

import com.digihealth.anesthesia.sysMng.po.BasRoleMenu;
import com.digihealth.anesthesia.common.persistence.CrudDao;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

import org.apache.ibatis.annotations.Param;

@MyBatisDao
public interface BasRoleMenuDao extends CrudDao<BasRoleMenu>{
    int deleteByPrimaryKey(@Param("menuId") String menuId, @Param("roleId") String roleId, @Param("beid") String beid);

    List<BasRoleMenu> selectEntityList(BasRoleMenu params);
    
    int insert(BasRoleMenu entity);
    
    int insertSelective(BasRoleMenu record);

    BasRoleMenu selectByPrimaryKey(@Param("menuId") String menuId, @Param("roleId") String roleId, @Param("beid") String beid);

    int updateByPrimaryKeySelective(BasRoleMenu record);

    int updateByPrimaryKey(BasRoleMenu record);
    
    int deleteByRoleId(@Param("roleId")String roleId, @Param("module")String module, @Param("beid") String beid);
    
    int deleteByMenuId(@Param("menuId") String menuId, @Param("beid") String beid);
}