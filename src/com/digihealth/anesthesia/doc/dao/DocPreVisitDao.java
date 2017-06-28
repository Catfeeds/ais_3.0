/*
 * DocPreVisitDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.common.persistence.CrudDao;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.doc.po.DocPreVisit;
import com.digihealth.anesthesia.evt.formbean.SearchConditionFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchMyOperationFormBean;

@MyBatisDao
public interface DocPreVisitDao extends CrudDao<DocPreVisit>{
    int deleteByPrimaryKey(String preVisitId);

    int insert(DocPreVisit record);

    int insertSelective(DocPreVisit record);

    DocPreVisit selectByPrimaryKey(String preVisitId);

    int updateByPrimaryKeySelective(DocPreVisit record);

    int updateByPrimaryKey(DocPreVisit record);

	/**
	 * 
	 * @discription 根据手术ID获取术前访视单信息
	 * @author chengwang
	 * @created 2015-10-10 下午5:13:48
	 * @param regOptId
	 * @return
	 */
	public DocPreVisit searchPreVisitByRegOptId(@Param("regOptId") String regOptId);
	
	/**
	 * 
	     * @discription 更新术前方式单
	     * @author chengwang       
	     * @created 2015-10-21 上午11:18:09     
	     * @param preVisit
	 */
	public void updatePreVisit(DocPreVisit preVisit);
	
	/**
	 * 
	     * @discription 通过ID获取术前访视单
	     * @author chengwang       
	     * @created 2015-10-21 上午11:18:23     
	     * @param id
	     * @return
	 */
	public DocPreVisit searchPreVisitById(@Param("id") String id);
	
	
	public List<SearchMyOperationFormBean> searchNoEndPreVisit(@Param("loginName")String loginName,@Param("searchConditionFormBean")SearchConditionFormBean searchConditionFormBean, @Param("beid")String beid);

}