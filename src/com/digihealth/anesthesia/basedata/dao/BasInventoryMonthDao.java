/*
 * BasInventoryMonthDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.dao;

import com.digihealth.anesthesia.basedata.po.BasInventoryMonth;
import com.digihealth.anesthesia.common.persistence.CrudDao;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface BasInventoryMonthDao extends CrudDao<BasInventoryMonth>{
    int deleteByPrimaryKey(String invtMonId);

    int insert(BasInventoryMonth record);

    int insertSelective(BasInventoryMonth record);

    BasInventoryMonth selectByPrimaryKey(String invtMonId);

    int updateByPrimaryKeySelective(BasInventoryMonth record);

    int updateByPrimaryKey(BasInventoryMonth record);
}