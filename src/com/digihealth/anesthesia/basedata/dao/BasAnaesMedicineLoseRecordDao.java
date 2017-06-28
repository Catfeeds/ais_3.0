/*
 * BasAnaesMedicineLoseRecordDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-06-13 Created
 */
package com.digihealth.anesthesia.basedata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.formbean.BasAnaesMedicineLoseRecordFormBean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasAnaesMedicineLoseRecord;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.evt.formbean.Filter;

@MyBatisDao
public interface BasAnaesMedicineLoseRecordDao {
    int deleteByPrimaryKey(Integer id);

    int insert(BasAnaesMedicineLoseRecord record);

    int insertSelective(BasAnaesMedicineLoseRecord record);

    BasAnaesMedicineLoseRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BasAnaesMedicineLoseRecord record);

    int updateByPrimaryKey(BasAnaesMedicineLoseRecord record);
    
    //通过取药id逻辑删除所有报损记录
    int updateEnableByOutRecordId(@Param("outRecordId")Integer outRecordId);
    
    public List<BasAnaesMedicineLoseRecordFormBean> queryMedicineLoseRecordList(@Param("filters")List<Filter> filters,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);
    int queryMedicineLoseRecordListTotal(@Param("filters")List<Filter> filters);
    
    public Integer queryMedicineLoseRecordForLine(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("beid")String beid);
    
    public Integer queryMedicineLoseRecordByReason(@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("reason")String reason,@Param("beid")String beid);
}