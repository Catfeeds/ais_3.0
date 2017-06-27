/*
 * BasInspectItemDao.java
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
import com.digihealth.anesthesia.basedata.po.BasInspectItem;
import com.digihealth.anesthesia.basedata.po.BasPatInspectItem;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.evt.formbean.Filter;

@MyBatisDao
public interface BasInspectItemDao {
    int deleteByPrimaryKey(String id);

    int insert(BasInspectItem record);

    int insertSelective(BasInspectItem record);

    BasInspectItem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BasInspectItem record);

    int updateByPrimaryKey(BasInspectItem record);

    List<BasPatInspectItem> getPatInspectItemList(@Param("searchFormBean") SystemSearchFormBean searchFormBean,@Param("filters") List<Filter> filters);
}