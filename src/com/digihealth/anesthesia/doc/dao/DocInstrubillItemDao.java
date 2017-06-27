/*
 * DocInstrubillItemDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.doc.po.DocInstrubillItem;
@MyBatisDao
public interface DocInstrubillItemDao {
    int deleteByPrimaryKey(String instruItemId);

    int insert(DocInstrubillItem record);

    int insertSelective(DocInstrubillItem record);

    DocInstrubillItem selectByPrimaryKey(String instruItemId);

    int updateByPrimaryKeySelective(DocInstrubillItem record);

    int updateByPrimaryKey(DocInstrubillItem record);

	/**
	 * 
	 * @discription 根据手术ID获取手术使用器械
	 * @author chengwang
	 * @created 2015-10-10 下午5:13:48
	 * @param regOptId
	 * @return
	 */
	public List<DocInstrubillItem> searchInstrubillItemByRegOptId(@Param("regOptId") String regOptId);
	
	/**
	 * 
	     * @discription 更新手术使用器械
	     * @author chengwang       
	     * @created 2015-10-21 上午11:18:09     
	     * @param preVisit
	 */
	public void updateInstrubillItem(@Param("instrubillItem")DocInstrubillItem instrubillItem);
	
	/**
	 * 
	     * @discription 根据ID获取手术使用器械
	     * @author chengwang       
	     * @created 2015-10-21 上午11:18:52     
	     * @param id
	     * @return
	 */
	public DocInstrubillItem searchInstrubillItemById(@Param("id") String id);
	
	/**
	 * 
	     * @discription 删除器械
	     * @author chengwang       
	     * @created 2015-10-22 下午4:41:48     
	     * @param id
	 */
	public int deleteInstrubillItem(@Param("instruItemId")String instruItemId);
	
	/**
	 * 
	     * @discription 器械备份到历史表
	     * @author chengwang       
	     * @created 2015-10-22 下午4:46:26
	 */
	public void insertInstrubillItemHis(@Param("instrubillItem")DocInstrubillItem instrubillItem);
	
	public List<DocInstrubillItem> searchInstrubillItemByInstrumentId(@Param("instrumentId")int instrumentId);
	
	public DocInstrubillItem searchInstrubillItemByCodeAndRegOptId(@Param("regOptId") String regOptId,@Param("instrumentId") String instrumentId);

}