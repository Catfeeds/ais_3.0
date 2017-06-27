/*
 * DocOperBeforeSafeCheckDao.java
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
import com.digihealth.anesthesia.doc.po.DocOperBeforeSafeCheck;

@MyBatisDao
public interface DocOperBeforeSafeCheckDao extends CrudDao<DocOperBeforeSafeCheck>{
    int deleteByPrimaryKey(String operBeforeId);

    int insert(DocOperBeforeSafeCheck record);

    int insertSelective(DocOperBeforeSafeCheck record);

    DocOperBeforeSafeCheck selectByPrimaryKey(String operBeforeId);

    int updateByPrimaryKeySelective(DocOperBeforeSafeCheck record);

    int updateByPrimaryKey(DocOperBeforeSafeCheck record);

	/**
	 * 
	 * @discription 根据手术ID获取手术前核查
	 * @author chengwang
	 * @created 2015-10-10 下午5:13:48
	 * @param regOptId
	 * @return
	 */
	public DocOperBeforeSafeCheck searchOperBeCheckByRegOptId(@Param("regOptId") String regOptId);

	/**
	 * 
	 * @discription 更新手术前核查
	 * @author chengwang
	 * @created 2015-10-21 上午11:18:09
	 * @param preVisit
	 */
	public void updateOperBeCheck(@Param("operBeforeSafeCheck") DocOperBeforeSafeCheck operBeforeSafeCheck);

	/**
	 * 
	 * @discription 根据ID获取手术前核查
	 * @author chengwang
	 * @created 2015-10-21 上午11:18:52
	 * @param id
	 * @return
	 */
	public DocOperBeforeSafeCheck searchOperBeCheckById(@Param("id") String id);
}