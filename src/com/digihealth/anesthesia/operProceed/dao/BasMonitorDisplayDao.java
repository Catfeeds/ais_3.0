/*
 * BasMonitorDisplayDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-04-07 Created
 */
package com.digihealth.anesthesia.operProceed.dao;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.operProceed.po.BasMonitorDisplay;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

@MyBatisDao
public interface BasMonitorDisplayDao {
    int deleteByPrimaryKey(@Param("id") String id, @Param("time") Date time);

    int insert(BasMonitorDisplay record);

    int insertSelective(BasMonitorDisplay record);

    BasMonitorDisplay selectByPrimaryKey(@Param("id") String id, @Param("time") Date time);
    
    BasMonitorDisplay selectById(@Param("id")String id);

    int updateByPrimaryKeySelective(BasMonitorDisplay record);

    int updateByPrimaryKey(BasMonitorDisplay record);
    
    List<BasMonitorDisplay> selectDisplayByRegOptId(@Param("regOptId") String regOptId);
    
    int getDisplayTotalByRegOptId(@Param("regOptId") String regOptId);
    
    List<Date> selectMonitorDisplayTime(@Param("regOptId") String regOptId);
    
    public Date findLastestTime(@Param("regOptId") String regOptId);
    
    public BasMonitorDisplay findLastestMonitorDisplay(@Param("regOptId")String regOptId);
    
    public List<BasMonitorDisplay> findLastestedMonitors(@Param("regOptId")String regOptId);
    
    public void updateIntevalTime(BasMonitorDisplay md);
    
    public List<BasMonitorDisplay> searchMonitorDisplayList(@Param("regOptId")String regOptId,@Param("pageNo")Integer pageNo,
    		@Param("pageSize")Integer pageSize,@Param("observeIds")List<String> observeIds,@Param("inTime")String inTime);
    
    public Integer searchMonitorDisplayListTotal(@Param("regOptId")String regOptId,
    		@Param("observeIds")List<String> observeIds,@Param("inTime")String inTime);
    
    public List<BasMonitorDisplay> getobsdatNew(@Param("regOptId")String regOptId, @Param("startTime")String startTime, 
			@Param("endTime")String endTime,@Param("observeIds") List<String> observeIds);
    
    public List<BasMonitorDisplay> getMonDataNew(@Param("regOptId")String regOptId, @Param("startTime")String startTime, 
			@Param("observeIds") List<String> observeIds);
    
    public void deleteByOperTime(@Param("time")String time,@Param("regOptId")String regOptId);
    
    public BasMonitorDisplay findMonitorDisplaybyTime(@Param("regOptId")String regOptId,@Param("time")String time);
    
    public BasMonitorDisplay getUniqMonitorDisplay(@Param("regOptId") String regOptId,@Param("time")Date time,@Param("observeId")String observeId);
    
    public List<BasMonitorDisplay> getobsDataNew2(@Param("regOptId")String regOptId,
			@Param("startTime")String startTime,@Param("observeIds")List<String> observeIds);
    
    public int searchMonitorDisplayByTime(@Param("regOptId")String regOptId,@Param("time")String time);
    
    public BasMonitorDisplay findLastestedDataByObserveId(@Param("regOptId")String regOptId,@Param("observeId")String observeId);
    
    public List<BasMonitorDisplay> searchObserveTimeById(@Param("regOptId")String regOptId,@Param("observeIds") List<String> observeIds);
    
    public List<BasMonitorDisplay> searchObserveDataList(@Param("baseQuery") BaseInfoQuery baseQuery,@Param("observeIds")List<String> observeIds);
    
    public BasMonitorDisplay findMonitorDisplayByInTimeLimit1(@Param("regOptId")String regOptId,@Param("time")Date time);
}