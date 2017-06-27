/*
 * DocAnaesPostopDao.java
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
import com.digihealth.anesthesia.doc.po.DocAnaesPostop;
import com.digihealth.anesthesia.evt.formbean.SearchConditionFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchMyOperationFormBean;

@MyBatisDao
public interface DocAnaesPostopDao {
    int deleteByPrimaryKey(String anaPostopId);

    int insert(DocAnaesPostop record);

    int insertSelective(DocAnaesPostop record);

    DocAnaesPostop selectByPrimaryKey(String anaPostopId);

    int updateByPrimaryKeySelective(DocAnaesPostop record);

    int updateByPrimaryKey(DocAnaesPostop record);
	
	/**
	 * 
	 * @discription 根据手术ID获取术后随访
	 * @author chengwang
	 * @created 2015-10-10 下午5:13:48
	 * @param regOptId
	 * @return
	 */
	public DocAnaesPostop searchAnaesPostopByRegOptId(@Param("regOptId") String regOptId);
	
	/**
	 * 
	     * @discription 更新术后随访
	     * @author chengwang       
	     * @created 2015-10-21 上午11:18:09     
	     * @param preVisit
	 */
	public void updateAnaesPostop(@Param("anaesPostop")DocAnaesPostop anaesPostop);
	
	/**
	 * 
	     * @discription 根据ID获取术后随访
	     * @author chengwang       
	     * @created 2015-10-21 上午11:18:52     
	     * @param id
	     * @return
	 */
	public DocAnaesPostop searchAnaesPostopById(@Param("id") String id);
	
	public List<SearchMyOperationFormBean> searchNoEndAnaesPostop(@Param("loginName")String loginName,@Param("searchConditionFormBean")SearchConditionFormBean searchConditionFormBean, @Param("beid")String beid);
	
}