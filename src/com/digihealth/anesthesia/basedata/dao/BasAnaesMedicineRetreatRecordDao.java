/*
 * BasAnaesMedicineRetreatRecordDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-06-13 Created
 */
package com.digihealth.anesthesia.basedata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.formbean.CommonRetreatRecordFormBean;
import com.digihealth.anesthesia.basedata.formbean.OperationRetreatRecordFormBean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasAnaesMedicineRetreatRecord;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.evt.formbean.Filter;

@MyBatisDao
public interface BasAnaesMedicineRetreatRecordDao {
    int deleteByPrimaryKey(Integer id);

    int insert(BasAnaesMedicineRetreatRecord record);

    int insertSelective(BasAnaesMedicineRetreatRecord record);

    BasAnaesMedicineRetreatRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BasAnaesMedicineRetreatRecord record);

    int updateByPrimaryKey(BasAnaesMedicineRetreatRecord record);
    
    //普通取药列表信息
    List<CommonRetreatRecordFormBean> queryCommonRetreatRecordList(@Param("filters")List<Filter> filters,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);
    int queryCommonRetreatRecordListTotal(@Param("filters")List<Filter> filters);
    
    //手术取药列表信息
    List<OperationRetreatRecordFormBean> queryOperationRetreatRecordList(@Param("filters")List<Filter> filters,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);
    int queryOperationRetreatRecordListTotal(@Param("filters")List<Filter> filters);
    
    //通过取药id逻辑删除所有退药记录
    int updateEnableByOutRecordId(@Param("outRecordId")Integer outRecordId);
    
}