/*
 * DocAccedeDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.dao;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.doc.po.DocAccede;

@MyBatisDao
public interface DocAccedeDao {
    int deleteByPrimaryKey(String accedeId);

    int insert(DocAccede record);

    int insertSelective(DocAccede record);

    DocAccede selectByPrimaryKey(String accedeId);

    int updateByPrimaryKeySelective(DocAccede record);

    int updateByPrimaryKey(DocAccede record);

	/**
	 * 
	 * @discription 根据手术ID获取麻醉同意书
	 * @author chengwang
	 * @created 2015-10-10 下午5:13:48
	 * @param regOptId
	 * @return
	 */
	public DocAccede searchAccedeByRegOptId(@Param("regOptId") String regOptId);
	
	/**
	 * 
	     * @discription 更新麻醉同意书
	     * @author chengwang       
	     * @created 2015-10-21 上午11:18:09     
	     * @param preVisit
	 */
	public void updateAccede(DocAccede accede);
	
	/**
	 * 
	     * @discription 根据ID获取麻醉同意书
	     * @author chengwang       
	     * @created 2015-10-21 上午11:18:52     
	     * @param id
	     * @return
	 */
	public DocAccede searchAccedeById(@Param("id") String id);
}