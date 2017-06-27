/*
 * BasCheckItemDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasCheckItem;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface BasCheckItemDao {
    int deleteByPrimaryKey(String chkItemId);

    int insert(BasCheckItem record);

    int insertSelective(BasCheckItem record);

    BasCheckItem selectByPrimaryKey(String chkItemId);

    int updateByPrimaryKeySelective(BasCheckItem record);

    int update(BasCheckItem record);
    
    public List<BasCheckItem> searchAllCheckItem(@Param("baseQuery")BaseInfoQuery baseQuery);
    
    public BasCheckItem queryCheckItemById(@Param("cheItemId") String cheItemId); 
    
    public List<BasCheckItem> queryCheckItemList(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);

    public int queryCheckItemListTotal(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);
    
    public void deleteCheckItem(@Param("cheItemId") String cheItemId); 
    
    public List<BasCheckItem> selectByCode(@Param("code")String code, @Param("beid")String beid);
    
    public int updateEnable(@Param("beid")String beid);
    
    public List<BasCheckItem> selectCheckItemByBeid(@Param("beid")String beid);

}