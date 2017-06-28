/*
 * BasAnaesMedicineInRecordDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-06-13 Created
 */
package com.digihealth.anesthesia.basedata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasAnaesMedicineInRecord;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.evt.formbean.Filter;

@MyBatisDao
public interface BasAnaesMedicineInRecordDao {
    int deleteByPrimaryKey(Integer id);

    int insert(BasAnaesMedicineInRecord record);

    int insertSelective(BasAnaesMedicineInRecord record);

    BasAnaesMedicineInRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BasAnaesMedicineInRecord record);

    int updateByPrimaryKey(BasAnaesMedicineInRecord record);
    
    List<BasAnaesMedicineInRecord> queryMedicineInRecordList(@Param("filters")List<Filter> filters,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);
    
    int queryMedicineInRecordListTotal(@Param("filters")List<Filter> filters);
}