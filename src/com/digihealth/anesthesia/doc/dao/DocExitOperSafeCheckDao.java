/*
 * DocExitOperSafeCheckDao.java
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
import com.digihealth.anesthesia.doc.po.DocExitOperSafeCheck;

@MyBatisDao
public interface DocExitOperSafeCheckDao extends CrudDao<DocExitOperSafeCheck>{
    int deleteByPrimaryKey(String exitOperId);

    int insert(DocExitOperSafeCheck record);

    int insertSelective(DocExitOperSafeCheck record);

    DocExitOperSafeCheck selectByPrimaryKey(String exitOperId);

    int updateByPrimaryKeySelective(DocExitOperSafeCheck record);

    int updateByPrimaryKey(DocExitOperSafeCheck record);

	/**
	 * 
	 * @discription 根据手术ID获取出手术室核查
	 * @author chengwang
	 * @created 2015-10-10 下午5:13:48
	 * @param regOptId
	 * @return
	 */
	public DocExitOperSafeCheck searchExitOperCheckByRegOptId(@Param("regOptId") String regOptId, @Param("beid") String beid);
	
	/**
	 * 
	     * @discription 更新出手术室核查
	     * @author chengwang       
	     * @created 2015-10-21 上午11:18:09     
	     * @param preVisit
	 */
	public void updateExitOperCheck(DocExitOperSafeCheck exitOperSafeCheck);
	
	/**
	 * 
	     * @discription 根据ID获取出手术室核查
	     * @author chengwang       
	     * @created 2015-10-21 上午11:18:52     
	     * @param id
	     * @return
	 */
	public DocExitOperSafeCheck searchExitOperCheckById(@Param("id") String id, @Param("beid") String beid);
}