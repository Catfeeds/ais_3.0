/*
 * BasAnaesMedicineStorageHisDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-06-28 Created
 */
package com.digihealth.anesthesia.basedata.dao;

import com.digihealth.anesthesia.basedata.po.BasAnaesMedicineStorageHis;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface BasAnaesMedicineStorageHisDao {
    int deleteByPrimaryKey(Integer id);

    int insert(BasAnaesMedicineStorageHis record);

    int insertSelective(BasAnaesMedicineStorageHis record);

    BasAnaesMedicineStorageHis selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BasAnaesMedicineStorageHis record);

    int updateByPrimaryKey(BasAnaesMedicineStorageHis record);
}