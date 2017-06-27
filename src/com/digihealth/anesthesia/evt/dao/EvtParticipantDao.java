/*
 * EvtParticipantDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-04-06 Created
 */
package com.digihealth.anesthesia.evt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.common.persistence.CrudDao;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.po.EvtParticipant;
import com.digihealth.anesthesia.sysMng.formbean.UserInfoFormBean;

@MyBatisDao
public interface EvtParticipantDao extends CrudDao<EvtParticipant>{
    int deleteByPrimaryKey(String partpId);

    int insert(EvtParticipant record);

    int insertSelective(EvtParticipant record);

    EvtParticipant selectByPrimaryKey(String partpId);

    int updateByPrimaryKeySelective(EvtParticipant record);

    int updateByPrimaryKey(EvtParticipant record);
    
    int deleteById(EvtParticipant evtParticipant);
    
	public List<UserInfoFormBean> getSelectParticipantList(@Param("searchBean")SearchFormBean searchBean, @Param("beid")String beid);
	
	public List<EvtParticipant> searchParticipantList(@Param("searchBean")SearchFormBean searchBean, @Param("beid")String beid);
	
	public int deleteByOperatorType(EvtParticipant participant);
	
	public void deleteByUserId(@Param("docId")String docId,@Param("userId")String userId);
	
	/**
	 * 获取主麻、主刀医生列表
	 * @param participant
	 * @return
	 */
	public List<EvtParticipant> getMainDocList(@Param("docId")String docId,@Param("role")String role,@Param("operatorType")String operatorType);
	
	//根据docid查询当次手术人员列表信息，这只包含麻醉医生、手术护士
	public List<EvtParticipant> queryOperPersonListByDocId(@Param("searchBean")SearchFormBean searchBean);
	
	
}