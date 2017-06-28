/*
 * BasAnaesMedicineOutRecordDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-06-13 Created
 */
package com.digihealth.anesthesia.basedata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.formbean.BasMedicineRegOptFormBean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasAnaesMedicineOutRecord;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.evt.formbean.Filter;

@MyBatisDao
public interface BasAnaesMedicineOutRecordDao {
    int deleteByPrimaryKey(Integer id);

    int insert(BasAnaesMedicineOutRecord record);

    int insertSelective(BasAnaesMedicineOutRecord record);

    BasAnaesMedicineOutRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BasAnaesMedicineOutRecord record);

    int updateByPrimaryKey(BasAnaesMedicineOutRecord record);
    
    List<BasAnaesMedicineOutRecord>  queryMedicineOutRecordList(@Param("filters")List<Filter> filters,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);
    int queryMedicineOutRecordListTotal(@Param("filters")List<Filter> filters);
    
    //查询手术是否取药记录
    List<BasMedicineRegOptFormBean> selectRegOptInfoForOutRecordList(@Param("filters")List<Filter> filters,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);
    int selectRegOptInfoForOutRecordListTotal(@Param("filters")List<Filter> filters);
    
}