/*
 * BasDispatchDao.java
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
import com.digihealth.anesthesia.basedata.formbean.DispatchFormbean;
import com.digihealth.anesthesia.basedata.formbean.DispatchPeopleNameFormBean;
import com.digihealth.anesthesia.basedata.formbean.DispatchTimeFormbean;
import com.digihealth.anesthesia.basedata.formbean.PrintNoticeFormBean;
import com.digihealth.anesthesia.basedata.formbean.SearchDispatchFormBean;
import com.digihealth.anesthesia.basedata.formbean.SearchListScheduleFormBean;
import com.digihealth.anesthesia.basedata.po.BasDispatch;
import com.digihealth.anesthesia.basedata.po.BasSysCode;
import com.digihealth.anesthesia.common.persistence.CrudDao;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface BasDispatchDao extends CrudDao<BasDispatch>{
	/**
	 * 查询排程信息
	 * @param baseQuery
	 * @return
	 */
	public List<SearchDispatchFormBean> findList(@Param("baseQuery") BaseInfoQuery baseQuery);
	
	/**
	 * 打印手术通知单
	 * @param baseQuery
	 * @return
	 */
	public List<PrintNoticeFormBean> printOperNotice(@Param("baseQuery") BaseInfoQuery baseQuery);
	
	/**
	 * 重排时删除暂存信息
	 * @param regOptId
	 */
	public void deleteDispatchHold(@Param("regOptId") String regOptId);
	/**
	 * 获取排班信息
	 * @param regOptId
	 * @return
	 */
	public BasDispatch getDispatchOper(@Param("regOptId") String regOptId);
	
	
	/**
	 * 获取需要重排的排班信息
	 * @param operatDate
	 * @return
	 */
	public List<BasDispatch> getDispatchListByOperateDate(@Param("operatDate") String operatDate);
	
	/**
	 * 
	     * @discription 根据regOptId获取排班人员的名字
	     * @author chengwang       
	     * @created 2015年10月30日 下午2:07:23     
	     * @param regOptId
	     * @return
	 */
	public DispatchPeopleNameFormBean searchPeopleNameByRegOptId(@Param("regOptId") String regOptId,@Param("beid") String beid);
	
	public DispatchFormbean getDispatchOperByRegOptId(@Param("regOptId") String regOptId,@Param("beid") String beid);
	/**
	 * 根据手术日期、时间、手术室id，获取该时间段的排班数
	 * @param operDate
	 * @param startTime
	 * @param roomId
	 * @return
	 */
	public Integer searchPersonTotalInOperRoomByStartTime(@Param("operDate") String operDate,@Param("startTime") String startTime,@Param("roomId") String roomId,@Param("beid") String beid);
	
	public List<BasDispatch> selectDispatchGbOproomId(@Param("operaDate")String operaDate,@Param("beid")String beid);
	
	public int selectByOprroomOperDateStartTime(@Param("operaDate")String operaDate,@Param("operRoomId")String operRoomId,@Param("startTime")String startTime);

	/**
	 * 手术室内屏显示信息
	 * @param baseQuery
	 * @return
	 */
	public List<PrintNoticeFormBean> getOperateInfoByInsideScreen(@Param("beid") String beid);
	/**
	 * 手术室外屏显示信息
	 * @param baseQuery
	 * @return
	 */
	public List<PrintNoticeFormBean> getOperateInfoByOutsideScreen();
	
	
	public Integer checkOperateTimeBeUse(@Param("operDate") String operDate,@Param("startTime") String startTime,@Param("roomId") String roomId,@Param("beid") String beid);
	
	
	public List<DispatchTimeFormbean> getNotUseTimeList(BasDispatch dispatch);

	public List<BasSysCode> getNoUsePcsList(BasDispatch dispatch);
	
	public int searchDistchByRegOptId(@Param("regOptId")String regOptId);
	
	/**
     * 根据条件查询未排班的的列表
     * @param baseQuery
     * @return
     */
    public List<SearchListScheduleFormBean> searchAllDispatchList(@Param("baseQuery")BaseInfoQuery baseQuery);
}