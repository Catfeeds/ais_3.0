/*
 * DocAnaesRecordDao.java
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
import com.digihealth.anesthesia.doc.po.DocAnaesRecord;

@MyBatisDao
public interface DocAnaesRecordDao extends CrudDao<DocAnaesRecord> {
    int deleteByPrimaryKey(String anaRecordId);

    int insert(DocAnaesRecord record);

    int insertSelective(DocAnaesRecord record);

    DocAnaesRecord selectByPrimaryKey(String anaRecordId);

    int updateByPrimaryKeySelective(DocAnaesRecord record);

    int updateByPrimaryKey(DocAnaesRecord record);

	/**
	 * 
	 * @discription 根据手术ID获取麻醉记录
	 * @author liukui
	 * @created 2015-10-10 下午5:13:48
	 * @param regOptId
	 * @return
	 */
	public DocAnaesRecord searchAnaesRecordByRegOptId(@Param("regOptId") String regOptId);
	
	/**
	 * 
	     * @discription 根据ID获取麻醉记录
	     * @author liukui       
	     * @created 2015-10-21 上午11:18:52     
	     * @param id
	     * @return
	 */
	public DocAnaesRecord searchAnaesRecordById(@Param("id") String id);
	
	/**
	 * 获取单个手术的手术时长
	 * @param regOptId
	 * @return
	 */
	public Float getOperdateByRegOpt(@Param("regOptId") String regOptId);
	
	/**
	 * 获取单个手术的麻醉时长
	 * @param regOptId
	 * @return
	 */
	public Float getAnesdateByRegOpt(@Param("regOptId") String regOptId);
	
	public void updateAnaesInRoomTime(@Param("inTime")String inTime,@Param("regOptId")String regOptId);
	
	public void updatefievt(@Param("f")Float f,@Param("ie")String ie,@Param("vt")Float vt ,@Param("regOptId")String regOptId);

}