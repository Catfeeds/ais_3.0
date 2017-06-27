/*
 * PatInspectItemDao.java
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
import com.digihealth.anesthesia.basedata.po.BasPatInspectItem;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.evt.formbean.Filter;

@MyBatisDao
public interface PatInspectItemDao {
    int deleteByPrimaryKey(String id);

    int insert(BasPatInspectItem record);

    int insertSelective(BasPatInspectItem record);

    BasPatInspectItem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BasPatInspectItem record);

    int updateByPrimaryKey(BasPatInspectItem record);
    
    List<BasPatInspectItem> getPatInspectItemList(@Param("searchFormBean") SystemSearchFormBean searchFormBean,@Param("filters") List<Filter> filters);
}