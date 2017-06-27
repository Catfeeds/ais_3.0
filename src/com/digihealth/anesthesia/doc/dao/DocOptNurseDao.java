/*
 * DocOptNurseDao.java
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
import com.digihealth.anesthesia.doc.po.DocOptNurse;

@MyBatisDao
public interface DocOptNurseDao extends CrudDao<DocOptNurse>{
    int deleteByPrimaryKey(String optNurseId);

    int insert(DocOptNurse record);

    int insertSelective(DocOptNurse record);

    DocOptNurse selectByPrimaryKey(String optNurseId);

    int updateByPrimaryKeySelective(DocOptNurse record);

    int updateByPrimaryKey(DocOptNurse record);

	/**
	 * 
	 * @discription 根据手术ID获取手术护理
	 * @author chengwang
	 * @created 2015-10-10 下午5:13:48
	 * @param regOptId
	 * @return
	 */
	public DocOptNurse searchOptNurseByRegOptId(@Param("regOptId") String regOptId);
	
	/**
	 * 
	     * @discription 更新手术护理
	     * @author chengwang       
	     * @created 2015-10-21 上午11:18:09     
	     * @param preVisit
	 */
	public void updateOptNurse(@Param("optNurse")DocOptNurse optNurse);
	
	/**
	 * 
	     * @discription 根据ID获取手术护理
	     * @author chengwang       
	     * @created 2015-10-21 上午11:18:52     
	     * @param id
	     * @return
	 */
	public DocOptNurse searchOptNurseById(@Param("id") String id);
}