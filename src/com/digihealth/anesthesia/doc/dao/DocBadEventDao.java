/*
 * DocBadEventDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.dao;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.doc.po.DocBadEvent;

@MyBatisDao
public interface DocBadEventDao {

	/**
	 * 
	 * @discription 根据手术ID获取不良事件
	 * @author chengwang
	 * @created 2015-10-10 下午5:13:48
	 * @param regOptId
	 * @return
	 */
	public DocBadEvent searchBadEventByRegOptId(@Param("regOptId") String regOptId);
	
	/**
	 * 
	     * @discription 更新不良事件
	     * @author chengwang       
	     * @created 2015-10-21 上午11:18:09     
	     * @param preVisit
	 */
	public void updateBadEvent(@Param("badEvent")DocBadEvent badEvent);
	
	/**
	 * 
	     * @discription 根据ID获取不良事件
	     * @author chengwang       
	     * @created 2015-10-21 上午11:18:52     
	     * @param id
	     * @return
	 */
	public DocBadEvent searchBadEventById(@Param("id") String id);
}