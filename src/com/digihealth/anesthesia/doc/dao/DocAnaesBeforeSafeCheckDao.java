/*
 * DocAnaesBeforeSafeCheckDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.dao;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.doc.po.DocAnaesBeforeSafeCheck;

@MyBatisDao
public interface DocAnaesBeforeSafeCheckDao {
    int deleteByPrimaryKey(String anesBeforeId);

    int insert(DocAnaesBeforeSafeCheck record);

    int insertSelective(DocAnaesBeforeSafeCheck record);

    DocAnaesBeforeSafeCheck selectByPrimaryKey(String anesBeforeId);

    int updateByPrimaryKeySelective(DocAnaesBeforeSafeCheck record);

    int updateByPrimaryKey(DocAnaesBeforeSafeCheck record);

	/**
	 * 
	 * @discription 根据手术ID获取麻醉前核查
	 * @author chengwang
	 * @created 2015-10-10 下午5:13:48
	 * @param regOptId
	 * @return
	 */
	public DocAnaesBeforeSafeCheck searchAnaBeCheckByRegOptId(@Param("regOptId") String regOptId);
	
	/**
	 * 
	     * @discription 更新麻醉前核查
	     * @author chengwang       
	     * @created 2015-10-21 上午11:18:09     
	     * @param preVisit
	 */
	public void updateAnaBeCheck(@Param("anaesBeforeSafeCheck")DocAnaesBeforeSafeCheck anaesBeforeSafeCheck);
	
	/**
	 * 
	     * @discription 根据ID获取麻醉前核查
	     * @author chengwang       
	     * @created 2015-10-21 上午11:18:52     
	     * @param id
	     * @return
	 */
	public DocAnaesBeforeSafeCheck searchAnaBeCheckById(@Param("id") String id);
}