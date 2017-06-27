/*
 * BasInventoryDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasInventory;
import com.digihealth.anesthesia.common.persistence.CrudDao;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface BasInventoryDao extends CrudDao<BasInventory>{
    int deleteByPrimaryKey(String invtId);

    int insert(BasInventory record);

    int insertSelective(BasInventory record);

    BasInventory selectByPrimaryKey(String invtId);

    int updateByPrimaryKeySelective(BasInventory record);

    int updateByPrimaryKey(BasInventory record);
    
    public List<BasInventory> queryInventoryList(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);
    
    public int queryInventoryListTotal(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);
    
    public BasInventory searchInventoryById(@Param("invtId")String invtId);
}