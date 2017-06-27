/*
 * BasMonitorConfigDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-04-11 Created
 */
package com.digihealth.anesthesia.operProceed.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.operProceed.po.BasMonitorConfig;
import com.digihealth.anesthesia.operProceed.po.Observe;
import com.digihealth.anesthesia.research.formbean.LifeSignObserveFormBean;
@MyBatisDao
public interface BasMonitorConfigDao {
    int deleteByPrimaryKey(@Param("eventId") String eventId, @Param("beid") String beid);

    int insert(BasMonitorConfig record);

    int insertSelective(BasMonitorConfig record);

    BasMonitorConfig selectByPrimaryKey(@Param("eventId") String eventId, @Param("beid") String beid);

    int updateByPrimaryKeySelective(BasMonitorConfig record);

    int updateByPrimaryKey(BasMonitorConfig record);
    
    public List<BasMonitorConfig> selectList(@Param("beid") String beid);
    
    public List<BasMonitorConfig> selectMustShowList(@Param("beid") String beid);
    
    public List<BasMonitorConfig> selectWithoutMustShowList(@Param("beid") String beid);

    public List<BasMonitorConfig> queryAllMonitorConfig(@Param("beid") String beid);

    List<LifeSignObserveFormBean> getLifeSignList(@Param("beid") String beid);
    
    public List<String> selectEventIdByEventName(@Param("eventName") String eventName, @Param("beid") String beid);
    
    /* 根据手术室ID，查询所有的需要采集的参数 */
	public List<Observe> searchAnaesObserveList(@Param("beid") String beid, @Param("operId")  String operId);
	
	//查询所有监测项
	public List<Observe> searchAllAnaesObserveList(@Param("beid") String beid);
	
}