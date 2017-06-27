/*
 * BasInspectRecordDao.java
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
import com.digihealth.anesthesia.basedata.po.BasInspectRecord;
import com.digihealth.anesthesia.basedata.po.BasPatInspectRecord;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.evt.formbean.Filter;
import com.digihealth.anesthesia.inspect.formbean.PatInspectRecordFormbean;

@MyBatisDao
public interface BasInspectRecordDao {
    int deleteByPrimaryKey(String id);

    int insert(BasInspectRecord record);

    int insertSelective(BasInspectRecord record);

    BasInspectRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BasInspectRecord record);

    int updateByPrimaryKey(BasInspectRecord record);

    List<BasPatInspectRecord> getPatInspectRecordList(@Param("searchFormBean") SystemSearchFormBean searchFormBean,@Param("filters") List<Filter> filters);
    
    int getTotalPatInspectRecordList(@Param("searchFormBean") SystemSearchFormBean searchFormBean,@Param("filters") List<Filter> filters);
    
    List<PatInspectRecordFormbean> getRegInfoListByPatInspect(@Param("searchFormBean") SystemSearchFormBean searchFormBean,@Param("filters") List<Filter> filters);
    
    int getTotalRegInfoListByPatInspect(@Param("searchFormBean") SystemSearchFormBean searchFormBean,@Param("filters") List<Filter> filters);
}