/*
 * BasOperroomDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.OperRoomFormBean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasOperroom;
import com.digihealth.anesthesia.common.persistence.CrudDao;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface BasOperroomDao extends CrudDao<BasOperroom>{
    int deleteByPrimaryKey(String id);

	List<BasOperroom> selectEntityList(BasOperroom params);
	
    int insert(BasOperroom record);
    
    int insertSelective(BasOperroom record);

    BasOperroom selectByPrimaryKey(String id);

    int updateByPrimaryKey(BasOperroom record);
    
    int updateByPrimaryKeySelective(BasOperroom record);

	public List<OperRoomFormBean> findList(@Param("baseQuery")BaseInfoQuery baseQuery);
	
	public List<BasOperroom> queryRoomList(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);
	
	public int queryRoomListTotal(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);
	
	public BasOperroom queryRoomListById(@Param("operRoomId")String operRoomId, @Param("beid")String beid);
	
	public int updateHealthnurse(@Param("operRoomId")String operRoomId,@Param("healthnurse")String healthnurse);
	
	public List<OperRoomFormBean> selectPrint(@Param("type")String type,@Param("stateItems")List<String> stateItems,@Param("sta")int sta, @Param("beid")String beid);

}