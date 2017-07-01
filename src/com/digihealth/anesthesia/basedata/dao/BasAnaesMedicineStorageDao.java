/*
 * BasAnaesMedicineStorageDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-06-13 Created
 */
package com.digihealth.anesthesia.basedata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.formbean.BasAnaesMedicineOutRecordFormBean;
import com.digihealth.anesthesia.basedata.formbean.BasAnaesMedicineStorageFormbean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasAnaesMedicineStorage;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.evt.formbean.Filter;

@MyBatisDao
public interface BasAnaesMedicineStorageDao {
    int deleteByPrimaryKey(Integer id);

    int insert(BasAnaesMedicineStorage record);

    int insertSelective(BasAnaesMedicineStorage record);

    BasAnaesMedicineStorage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BasAnaesMedicineStorage record);

    int updateByPrimaryKey(BasAnaesMedicineStorage record);
    
    BasAnaesMedicineStorage selectMedicineByMFSB(@Param("medicineCode")String medicineCode,@Param("firm")String firm,@Param("spec")String spec,@Param("batch")String batch);
    
    List<BasAnaesMedicineStorage> queryAnaesMedicineListGroupByNFS(@Param("filters")List<Filter> filters,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);
    
    int queryAnaesMedicineListGroupByNFSTotal(@Param("filters")List<Filter> filters);
    
    List<BasAnaesMedicineStorage> queryMedicineList(@Param("filters")List<Filter> filters,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);
    
    int queryMedicineListTotal(@Param("filters")List<Filter> filters);
    
    List<BasAnaesMedicineStorageFormbean> queryAnaesMedicineByMonth(@Param("filters")List<Filter> filters,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean,@Param("queryMonth")String queryMonth);
    
    int queryAnaesMedicineByMonthTotal(@Param("filters")List<Filter> filters);
    
    List<BasAnaesMedicineOutRecordFormBean> queryAnaesMedicineByPersonal(@Param("filters")List<Filter> filters,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);
    
    int queryAnaesMedicineByPersonalTotal(@Param("filters")List<Filter> filters);
    
    List<BasAnaesMedicineStorage> queryAnaesMedicineStorageByBeid(@Param("beid")String beid);
}