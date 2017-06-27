/*
 * BasObserveDataDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-04-07 Created
 */
package com.digihealth.anesthesia.operProceed.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.operProceed.formbean.RealTimeDataFormBean;
import com.digihealth.anesthesia.operProceed.po.BasObserveData;
import com.digihealth.anesthesia.operProceed.po.Observe;

@MyBatisDao
public interface BasObserveDataDao {
    int deleteByPrimaryKey(@Param("id") String id, @Param("time") Date time);

    int insert(BasObserveData record);

    int insertSelective(BasObserveData record);

    BasObserveData selectByPrimaryKey(@Param("id") String id, @Param("time") Date time);

    int updateByPrimaryKeySelective(BasObserveData record);

    int update(BasObserveData record);
    
    public List<BasObserveData> searchObserveDataList(@Param("baseQuery") BaseInfoQuery baseQuery);
    
    public Integer searchObserveDataListTotal(@Param("baseQuery") BaseInfoQuery baseQuery);
    
	//获取手术时间轴信息
	public List<BasObserveData> searchObserveTimeById(@Param("regOptId") String regOptId);
	
	//获取单个手术设备采集项信息
	public List<BasObserveData> searchObserveIdById(@Param("regOptId") String regOptId);
	
	//获取采集设备对应时间轴信息
	public List<BasObserveData> searchObserveDataById(@Param("regOptId") String regOptId,@Param("obserIdItems") List<String> obserIdItems,@Param("items") String items);
	
	//观察点数据
	public BasObserveData searchObserveDataByObserveId(@Param("id") String id);
	
	public void updateIconAndColor(@Param("regOptId") String regOptId, @Param("observeId") String observeId,
			 @Param("icon") String icon, @Param("color") String color);
	
	//根据时间获取对应的采集数据列表
	public List<BasObserveData> searchObserveDataBytime (@Param("time")String time);
	
	public void deleteObserveDataById(@Param("id") String id);
	
	public void updateIntervalTime(BasObserveData observeData);
	
	public Timestamp queryDbTime() ;
	
	public BasObserveData getUniqObserveData(@Param("regOptId") String regOptId,@Param("time")String time,@Param("observeId")String observeId);
	
	public void updateValue (BasObserveData observeData);
	
	/**
	 * 查询术中实时监测项
	 */
	public List<RealTimeDataFormBean> searchObserveDataByPosition(@Param("baseQuery") BaseInfoQuery baseQuery);
	
	/**
	 * 查询对应数据的点的数据
	 */
	public List<BasObserveData> findObserveDataListByTime(@Param("regOptId")String regOptId,@Param("time") String time, @Param("observeIds")List<String> observeIds);
	
	/* 根据床号，查询所有的需要采集的参数 */
	public List<Observe> searchObserveListByBedId(@Param("bedId") int bedId);
	
	public int searchMonitorDisplayByTime(@Param("regOptId")String regOptId,@Param("time")String time);
	
	
}