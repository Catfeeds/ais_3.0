/*
 * DocSafeCheckDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.dao;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.common.persistence.CrudDao;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.doc.po.DocSafeCheck;

@MyBatisDao
public interface DocSafeCheckDao extends CrudDao<DocSafeCheck>{
    int deleteByPrimaryKey(String safCheckId);

    int insert(DocSafeCheck record);

    int insertSelective(DocSafeCheck record);

    DocSafeCheck selectByPrimaryKey(String safCheckId);

    int updateByPrimaryKeySelective(DocSafeCheck record);

    int updateByPrimaryKey(DocSafeCheck record);

	/**
	 * 
	 * @discription 根据手术ID获取手术核查
	 * @author chengwang
	 * @created 2015-10-10 下午5:13:48
	 * @param regOptId
	 * @return
	 */
	public DocSafeCheck searchSafeCheckByRegOptId(@Param("regOptId") String regOptId, @Param("beid") String beid);
	
	/**
	 * 
	     * @discription 更新手术核查
	     * @author chengwang       
	     * @created 2015-10-21 上午11:18:09     
	     * @param preVisit
	 */
	public void updateSafeCheck(@Param("safeCheck")DocSafeCheck safeCheck);
	
	/**
	 * 
	     * @discription 根据ID获取手术核查
	     * @author chengwang       
	     * @created 2015-10-21 上午11:18:52     
	     * @param id
	     * @return
	 */
	public DocSafeCheck searchSafeCheckById(@Param("id") String id);
}