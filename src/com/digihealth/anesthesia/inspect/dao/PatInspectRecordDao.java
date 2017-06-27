/*
 * PatInspectRecordDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2016-07-22 Created
 */
package com.digihealth.anesthesia.inspect.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasPatInspectRecord;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.evt.formbean.Filter;
import com.digihealth.anesthesia.inspect.formbean.PatInspectRecordFormbean;

@MyBatisDao
public interface PatInspectRecordDao {
    int deleteByPrimaryKey(String id);

    int insert(BasPatInspectRecord record);

    int insertSelective(BasPatInspectRecord record);

    BasPatInspectRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BasPatInspectRecord record);

    int updateByPrimaryKey(BasPatInspectRecord record);
    
    List<BasPatInspectRecord> getPatInspectRecordList(@Param("searchFormBean") SystemSearchFormBean searchFormBean,@Param("filters") List<Filter> filters);
    
    int getTotalPatInspectRecordList(@Param("filters") List<Filter> filters);
    
    List<PatInspectRecordFormbean> getRegInfoListByPatInspect(@Param("searchFormBean") SystemSearchFormBean searchFormBean,@Param("filters") List<Filter> filters);
    
    int getTotalRegInfoListByPatInspect(@Param("filters") List<Filter> filters);
}